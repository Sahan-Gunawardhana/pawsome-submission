package com.example.pawsomepetcare.ui.screens.productsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pawsomepetcare.data.DataSource
import com.example.pawsomepetcare.ui.Common.ProductCardOne

@Composable
fun ProductDetails(productId: String, navController: NavController) {
    val colors = MaterialTheme.colorScheme
    val ftProducts = DataSource().loadFeaturedProducts()
    val product = DataSource().getProductById(productId)
    var count by remember { mutableStateOf(1) }

    product?.let {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(colors.background)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
        ) {
            // Product Image
            Image(
                painter = painterResource(id = it.imageResourceId),
                contentDescription = stringResource(id = it.desc),
                modifier = Modifier
                    .clip(shape = MaterialTheme.shapes.medium)
                    .fillMaxWidth()
            )

            // Product Name
            Text(
                text = stringResource(id = it.name),
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = 24.sp),
                color = colors.onBackground,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Product Description
            Text(
                text = stringResource(id = it.desc),
                style = MaterialTheme.typography.bodyLarge,
                color = colors.onBackground,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            // Product Price
            Text(
                text = stringResource(id = it.price),
                style = MaterialTheme.typography.titleMedium,
                color = colors.primary,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Quantity Selector
            Row(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { if (count > 1) count-- }) {
                        Icon(imageVector = Icons.Filled.Remove, contentDescription = "Decrease count")
                    }
                    Text(
                        text = "$count",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    IconButton(onClick = { count++ }) {
                        Icon(imageVector = Icons.Filled.Add, contentDescription = "Increase count")
                    }
                }

                // Add to Cart Button
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = colors.onPrimaryContainer,
                        containerColor = colors.primaryContainer
                    ),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp, pressedElevation = 0.dp),
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Text(text = "Add to Cart")
                }
            }
            HorizontalDivider()
            Spacer(modifier = Modifier.height(24.dp))

            // You Might Also Like Section
            Text(
                text = "You Might Also Like",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            LazyRow {
                items(ftProducts) { product ->
                    ProductCardOne(product, navController)
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
