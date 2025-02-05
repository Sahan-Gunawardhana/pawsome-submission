package com.example.pawsomepetcare.ui.screens.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pawsomepetcare.Authentications.AuthState
import com.example.pawsomepetcare.Authentications.AuthViewModel
import com.example.pawsomepetcare.R
import com.example.pawsomepetcare.data.DataSource
import com.example.pawsomepetcare.navigation.Screens
import com.example.pawsomepetcare.ui.Common.ProductCardOne
import com.example.pawsomepetcare.ui.Common.SearchBar
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier, authViewModel: AuthViewModel){
    val colors = MaterialTheme.colorScheme
    val ftproducts = DataSource().loadFeaturedProducts()
    val dogProducts = DataSource().loadDogProducts()
    val catProducts = DataSource().loadCatProducts()
    val birdProducts = DataSource().loadBirdProducts()
    val newslist = DataSource().loadNews()
    val authState = authViewModel.authState.observeAsState()

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.UnAuthenticated -> navController.navigate(Screens.LoginScreen.name)
            else -> Unit
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 0.dp,
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            )
            .verticalScroll(rememberScrollState())
            .background(colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SearchBar()
        Spacer(modifier = Modifier.height(15.dp))
        NewsPager(newsList = newslist)
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = stringResource(R.string.featured),
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 0.dp, bottom = 6.dp),
            style = typography.headlineSmall,
        )
        LazyRow (){
            items(ftproducts) { product ->
                ProductCardOne(product, navController)
            }
        }

        Text(text = "Browse Our Store",style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 8.dp, bottom = 8.dp, top = 8.dp))

        ProductTabs(navController)
    }
}

@Composable
fun ProductTabs(navController: NavController) {
    val tabTitles = listOf("Dogs", "Cats", "Birds")
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    val dogProducts = DataSource().loadDogProducts()
    val catProducts = DataSource().loadCatProducts()
    val birdProducts = DataSource().loadBirdProducts()

    // Define the content to display based on selected tab
    val productLists = listOf(
        dogProducts,
        catProducts,
        birdProducts
    )

    // Render Tabs
    Column {
        ScrollableTabRow(selectedTabIndex = selectedTabIndex) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(title) }
                )
            }
        }

        // Display the products for the selected tab
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(productLists[selectedTabIndex]) { product ->
                ProductCardOne(product = product, navController = navController)
            }
        }
    }
}

