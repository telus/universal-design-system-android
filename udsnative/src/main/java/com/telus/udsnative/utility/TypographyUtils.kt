package com.telus.udsnative.utility

import androidx.compose.ui.text.font.FontWeight

//Temporary code.  This will be switched to reference .ttf files when we receive them from the theme libraries
object TypographyUtils {
    fun toFontWeight(fontName: String): FontWeight {
        return when(fontName) {
            "Helvetica Bold" -> FontWeight.Bold
            "Helvetica Light" -> FontWeight.Light
            else -> FontWeight.Normal
        }
    }
}