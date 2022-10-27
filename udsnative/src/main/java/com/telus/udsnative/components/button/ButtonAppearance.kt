package com.telus.udsnative.components.button

import com.telus.udsnative.models.Appearance

class ButtonAppearance(variant: ButtonVariant, state: ButtonState): Appearance {
    val variant: ButtonVariant
    val state: ButtonState

    init {
        this.variant = variant
        this.state = state
    }

    override fun asMap(): Map<String, Any?> = mapOf(
        "danger" to variant.danger,
        "inverse" to variant.inverse,
        "priority" to variant.priority?.value,
        "text" to variant.text,
        state.value to true
    )
}
