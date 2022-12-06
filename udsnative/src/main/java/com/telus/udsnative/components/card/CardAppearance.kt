package com.telus.udsnative.components.card

import com.telus.udsnative.models.Appearance

class CardAppearance(variant: CardVariant): Appearance {
    val background: Background
    val padding: Padding

    init {
        this.background = variant.background
        this.padding = variant.padding
    }

    override fun asMap(): Map<String, Any> = mapOf(
        "background" to background.name,
        "padding" to padding.name
    )
}