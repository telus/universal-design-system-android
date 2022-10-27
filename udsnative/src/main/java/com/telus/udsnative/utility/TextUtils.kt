package com.telus.udsnative.utility

import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextDecoration

object TextAlignmentUtils {
    fun toArrangement(colorString: String): Alignment.Horizontal {
        return when(colorString) {
            "left" -> Alignment.Start
            "right" -> Alignment.End
            "center" -> Alignment.CenterHorizontally
            else -> Alignment.CenterHorizontally
        }
    }
}

object TextLineUtils {
    fun toTextDecoration(textLineString: String): TextDecoration {
        return when(textLineString) {
            "none" -> TextDecoration.None
            "underline" -> TextDecoration.Underline
            else -> TextDecoration.None
        }
    }
}