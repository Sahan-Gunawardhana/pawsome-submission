package com.example.pawsomepetcare.ui.screens.favouritesscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pawsomepetcare.data.DataSource
import com.example.pawsomepetcare.ui.Common.ProductCardTwo
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme


//favourites screen
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouritesScreen(navController: NavController, modifier: Modifier = Modifier) {
    val colors = MaterialTheme.colorScheme
    val favs = DataSource().loadFavourites()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colors.background)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = "Your Favourites",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp),
            color = colors.onPrimaryContainer
        )


        favs.forEach { fav ->
            ProductCardTwo(fav, navController)
            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(color = colors.onBackground.copy(alpha = 0.2f), thickness = 1.dp)
        }
    }
}

@Preview
@Composable
fun pv() {
    PawsomePetCareTheme(darkTheme = false) {
        FavouritesScreen(navController = rememberNavController())
    }
}
