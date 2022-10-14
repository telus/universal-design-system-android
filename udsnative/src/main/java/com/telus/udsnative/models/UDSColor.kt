package com.telus.udsnative.models

import androidx.compose.ui.graphics.Color
import com.telus.udsnative.utility.ColorUtil

// Temporary fix for issues with Gson's deserialization of strings to Compose Color types breaking
data class UDSColor(
    val colorString: String,
    val color: Color = ColorUtil.toColor(colorString)
)
