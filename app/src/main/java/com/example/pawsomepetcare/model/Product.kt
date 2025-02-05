package com.example.pawsomepetcare.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Product(
    val id: String,
    @StringRes val name: Int,
    @StringRes val price:Int,
    @StringRes val desc: Int,
    @DrawableRes val imageResourceId: Int
)
