package com.example.pawsomepetcare.ui.screens.profilescreen


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun ExtendedFloatingActionButtonCommon(title:String, onClick:()-> Unit, modifier: Modifier = Modifier){
    ExtendedFloatingActionButton(
        onClick = { onClick() },
        icon = { Icon(imageVector = Icons.Filled.Edit, contentDescription = null)},
        text = { Text(text = title)},
        modifier = modifier
    )
}
