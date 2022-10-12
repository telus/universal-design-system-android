package com.telus.udsnative.model

import androidx.compose.ui.graphics.Color
import androidx.core.graphics.toColorInt

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
            return value.stops.map { toColor(it.color) }
        }


    private fun toColor(colorString: String): Color {
        val pattern = """rgba?\((?<red>[0-9]{1,3}),\s?(?<green>[0-9]{1,3}),?\s?(?<blue>[0-9]{1,3}).\s?(?<alpha>[0-9]*)?\)?""".toRegex()

        val result = pattern.find(colorString)

        // convert hex string
        if (result == null) {
            return Color(colorString.toColorInt())
        }

        // convert rbga string
        val list = result.groups.toList()

        val red = list[1]?.value?.toIntOrNull() ?: 0
        val green = list[2]?.value?.toIntOrNull() ?: 0
        val blue = list[3]?.value?.toIntOrNull() ?: 0
        val alpha = list[4]?.value?.toIntOrNull() ?: 0

        val color = Color(red = red, green = green, blue = blue)

        // Adding alpha is currently breaking gradients so temporarily removing it
        return color
    }
}