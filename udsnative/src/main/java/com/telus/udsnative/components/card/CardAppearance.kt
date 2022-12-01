package com.telus.udsnative.components.card

import com.telus.udsnative.models.Appearance

class CardAppearance(variant: CardVariant): Appearance {
    val background: Background
    val padding: Padding
    val viewport: Viewport // Temporary hardcoded value until viewport is removed from theme file

    init {
        this.background = variant.background
        this.padding = variant.padding
        this.viewport = variant.viewport
    }

    override fun asMap(): Map<String, Any> = mapOf(
        "background" to background.name,
        "padding" to padding.name,
        "viewport" to viewport.name
    )
}