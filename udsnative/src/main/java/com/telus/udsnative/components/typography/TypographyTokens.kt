package com.telus.udsnative.components.typography

import androidx.compose.ui.unit.TextUnit
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.telus.udsnative.models.Tokens
import com.telus.udsnative.models.UDSColor
import java.lang.reflect.Type

data class TypographyTokens(
    val color: UDSColor,
    val fontName: TypographyFontName?,
    val fontSize: Int,
    val fontScaleCap: Int?,
    val letterSpacing: Double,
    val lineHeight: Double,
    val textTransform: TextTransform
) : Tokens