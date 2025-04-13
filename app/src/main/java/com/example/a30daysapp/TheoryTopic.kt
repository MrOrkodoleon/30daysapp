package com.example.a30daysapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class TheoryTopic(
    val day: Int,
    @StringRes val titleResId: Int,
    @StringRes val descriptionResId: Int,
    @DrawableRes val imageResId: Int
)
