package com.example.pawsomepetcare.ui.screens.cartscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pawsomepetcare.model.Product

//cart item cards for each item
@Composable
fun CartItemCard(item: Product, quantity: String, onDeleteClick: () -> Unit) {
    val colors = MaterialTheme.colorScheme

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = item.imageResourceId),
            contentDescription = stringResource(id = item.name),
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        ) {
            Text(
                text = stringResource(id = item.name),
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = stringResource(id = item.price),
                style = MaterialTheme.typography.bodyMedium
            )
        }


        IconButton(onClick = onDeleteClick) {
            Icon(
                imageVector = Icons.Outlined.Delete,
                contentDescription = "Delete Item",
                tint = colors.errorContainer
            )
        }


        Text(
            text = quantity,
            style = MaterialTheme.typography.bodyLarge
        )
    }

    // Divider
    HorizontalDivider(
        color = colors.primary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    )
}