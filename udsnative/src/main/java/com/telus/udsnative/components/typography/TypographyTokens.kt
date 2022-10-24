package com.telus.udsnative.components.typography

import androidx.compose.ui.unit.TextUnit
import com.telus.udsnative.models.Tokens
import com.telus.udsnative.models.UDSColor

data class TypographyTokens(
    val color: UDSColor,
    val fontName: String?,
    val fontSize: TextUnit,
    val fontScaleCap: Int?,
    val letterSpacing: TextUnit,
    val lineHeight: TextUnit,
    val textTransform: TextTransform
) : Tokens