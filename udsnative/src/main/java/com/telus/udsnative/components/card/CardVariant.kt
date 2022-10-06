package com.telus.udsnative.components.card

import com.telus.udsnative.components.Variant


enum class Background {
    Default, Alternative, Subtle, Grid
}

enum class Padding {
    Default, Narrow, Intermediate, Compact, Custom
}

data class CardVariant(val background: Background = Background.Default, val padding: Padding = Padding.Default): Variant