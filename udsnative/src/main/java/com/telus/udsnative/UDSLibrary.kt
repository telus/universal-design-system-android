package com.telus.udsnative

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Mock Palette - Temporary
object Palette {
    object Colors {
        val greenAccessible = Color(0xFF2b8000)
        val green = Color(0xFF1f5c09)
        val redDark = Color(0xFFc12335)
        val greyCloud = Color(0xFFb2b9bf)
        val greyThunder = Color(0xFF2c2e30)

        val white = Color(0xFFFFFFFF)
        val greyMystic = Color(0xFFE3E6E8)
        val greyAthens = Color(0xFFF4F4F7)
        val greyAlabaster = Color(0xFFFAFAFA)
    }

    object Radius {
        val radius6 = 6.dp
        val radius12 = 12.dp
    }

    object Border {
        val none = 0.dp
        val border1 = 1.dp
    }

    object Size {
        val size32 = 32.dp
        val size24 = 24.dp
        val size48 = 48.dp
        val size16 = 16.dp
    }
}

object SystemValues {
    object Gradient {
        val none = Color(0xFF2b8000)
    }

    object Size {
        val none = 0.dp
    }
}