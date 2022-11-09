package com.telus.udsnative.models

import androidx.compose.ui.graphics.Color

data class UDSColor(
    val red: Float,
    val green: Float,
    val blue: Float,
    val alpha: Float
) {
    val color: Color
        get() = Color(red = red, green = green, blue = blue, alpha = alpha)
}
