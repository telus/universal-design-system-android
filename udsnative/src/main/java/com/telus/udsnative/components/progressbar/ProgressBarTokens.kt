package com.telus.udsnative.components.progressbar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.telus.udsnative.Palette
import com.telus.udsnative.components.Tokens

data class ProgressBarTokens (
    var backgroundColor: Color = Palette.Colors.greenAccessible,
    var borderRadius: Dp = Palette.Radius.radius12,
    var gradient: Color = Palette.Colors.green,
    var outlineColor: Color = Palette.Colors.greenAccessible,
    var outlineWidth: Dp = Palette.Border.border1
): Tokens {

    fun apply(tokens: ProgressBarTokens) {
        backgroundColor = tokens.backgroundColor
        borderRadius = tokens.borderRadius
        gradient = tokens.gradient
        outlineColor = tokens.outlineColor
    }
}