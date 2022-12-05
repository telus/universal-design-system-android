package com.telus.udsnative.components.card

import com.telus.udsnative.models.Variant


enum class Background {
    default, alternative, subtle, grid
}

enum class Padding {
    default, narrow, intermediate, compact, custom
}

enum class Viewport {
    xs, sm, md, lg, xl
}

data class CardVariant(val background: Background = Background.default, val padding: Padding = Padding.default, val viewport: Viewport = Viewport.lg): Variant