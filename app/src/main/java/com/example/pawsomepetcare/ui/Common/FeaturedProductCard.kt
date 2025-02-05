package com.example.pawsomepetcare.ui.Common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pawsomepetcare.ViewModels.FeaturedViewModel
import com.example.pawsomepetcare.model.Featured

@Composable
fun FeaturedProductCard(product:Featured){
    Card(
        modifier = Modifier.padding(horizontal = 12.dp).width(200.dp).height(280.dp)
    ) {
        Column()
        {
            AsyncImage(
                model = product.pro_image_url,
                contentDescription = product.pro_name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(130.dp).width(200.dp)
            )
            Text(
                text = product.pro_name,
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            )
            Text(
                text = "${product.pro_price}",
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth().padding(10.dp)
            )
            Button(
                onClick = {/* */},
                modifier = Modifier.padding(8.dp)

            ) {
                Text(
                    text = "Add to Cart",
                    style = typography.button
                )
            }
        }
    }
}

@Composable
fun ProductList(featuredViewModel: FeaturedViewModel){
    val products by featuredViewModel.products.collectAsState()
    val error by featuredViewModel.error.collectAsState()

    if(error != null){
        Text(
            text = "Error: $error"
        )
    }else{
        LazyRow(modifier = Modifier)
        {
            items(products){
                product -> FeaturedProductCard(product)
            }
        }
    }
}