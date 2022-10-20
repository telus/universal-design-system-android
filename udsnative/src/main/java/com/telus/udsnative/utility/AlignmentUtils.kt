package com.telus.udsnative.utility

import androidx.compose.ui.Alignment

object AlignmentUtils {
    fun toArrangement(colorString: String): Alignment.Horizontal {
        return when(colorString) {
            "left" -> Alignment.Start
            "right" -> Alignment.End
            "center" -> Alignment.CenterHorizontally
            else -> Alignment.CenterHorizontally
        }
    }
}