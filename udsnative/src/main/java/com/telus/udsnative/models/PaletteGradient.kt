package com.telus.udsnative.models

import androidx.compose.ui.graphics.Color

data class PaletteGradient(
    val description: String,
    val angle: Double,
    val stops: List<GradientStop>,
    val type: GradientType
) {

    data class GradientStop(
        val stop: Int,
        val color: UDSColor
    )

    enum class GradientType {
        Linear,
        Radial
    }

    val colors: List<Color>
        get() {
            return arrayListOf<Color>().apply {
                stops.forEach{
                    add(it.stop, it.color.color)
                }
            }
        }
}
