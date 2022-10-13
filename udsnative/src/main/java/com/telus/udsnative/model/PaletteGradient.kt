package com.telus.udsnative.model

import androidx.compose.ui.graphics.Color
import com.telus.udsnative.utility.ColorUtil

data class PaletteGradient(
    val description: String,
    val value: Value
) {
    data class Value(
        val specification: String?,
        val angle: Double,
        val stops: List<GradientStop>,
        val type: GradientType
    )

    data class GradientStop(
        val color: String,
        val hint: Double?
    )

    enum class GradientType {
        linear,
        radial
    }

    val colors: List<Color>
        get() {
            return value.stops.map { ColorUtil.toColor(it.color) }
        }
}