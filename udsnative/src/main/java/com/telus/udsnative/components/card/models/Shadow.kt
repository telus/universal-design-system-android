package com.telus.udsnative.components.card.models

import androidx.compose.ui.unit.Dp
import com.telus.udsnative.models.UDSColor

data class Shadow(
    val blur: Dp,
    val color: UDSColor,
    val inset: Boolean, // - Not sure if this translates to mobile
    val offsetX: Dp,
    val offsetY: Dp,
    val spread: Dp

)