package com.example.pawsomepetcare.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class News (
    val id: String,
    @StringRes val headline: Int,
    @StringRes val headline2:Int,
    @DrawableRes val imageResourceId: Int
)