package com.example.pawsomepetcare.ui.screens.servicesscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun leftRight(titleTitleId:String,titleDescId:String,imageResourceId: String){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .height(150.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(id = titleTitleId.toInt()),style = typography.bodyLarge, fontWeight = FontWeight(600))
            Text(text = stringResource(id = titleDescId.toInt()), style = typography.bodyMedium)
        }
        Image(painter = painterResource(id = imageResourceId.toInt()), contentDescription = stringResource(
            id = imageResourceId.toInt()
        ), modifier = Modifier
            .clip(shape = shapes.small)
            .weight(1f)
        )
    }
}

@Composable
fun rightLeft(titleTitleId:String,titleDescId:String,imageResourceId: String){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .height(150.dp)
    ) {
        Image(painter = painterResource(id = imageResourceId.toInt()), contentDescription = stringResource(
            id = imageResourceId.toInt()
        ), modifier = Modifier
            .clip(shape = shapes.small)
            .weight(1f)
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = stringResource(id = titleTitleId.toInt()),style = typography.bodyLarge, fontWeight = FontWeight(600))
            Text(text = stringResource(id = titleDescId.toInt()), style = typography.bodyMedium)
        }
    }
}
