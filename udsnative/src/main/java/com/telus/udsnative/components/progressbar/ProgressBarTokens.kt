package com.telus.udsnative.components.progressbar

import androidx.compose.ui.unit.Dp
import com.telus.udsnative.models.PaletteGradient
import com.telus.udsnative.models.Tokens
import com.telus.udsnative.models.UDSColor

data class ProgressBarTokens (
    var backgroundColor: UDSColor,
    var borderRadius: Dp,
    var gradient: PaletteGradient? = null,
    var outlineColor: UDSColor,
    var outlineWidth: Dp
): Tokens
