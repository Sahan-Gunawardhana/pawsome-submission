package com.example.pawsomepetcare.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Service(
    val id: String,
    @StringRes val desc:Int,
    @DrawableRes val imageResourceId: Int
)