package com.telus.udsnative.components.typography

import com.telus.udsnative.models.Appearance

class TypographyAppearance(variant: TypographyVariant) : Appearance {
    val variant: TypographyVariant

    init {
        this.variant = variant
    }

    override fun asMap(): Map<String, Any?>  = mapOf(
        "bold" to variant.bold,
        "color" to variant.colour,
        "compact" to variant.compact,
        "inverse" to variant.inverse,
        "size" to variant.size
    )
}