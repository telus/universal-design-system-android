package com.telus.udsnative.components.typography

import com.telus.udsnative.models.Appearance

class TypographyAppearance(variant: TypographyVariant) : Appearance {
    val variant: TypographyVariant

    init {
        this.variant = variant
    }

    override fun asMap(): Map<String, Any?>  = mapOf(
        "bold" to variant.bold,
        "colour" to variant.colour.name,
        "compact" to variant.compact,
        "inverse" to variant.inverse,
        "size" to variant.size.name,
        "viewport" to variant.viewport.name // Temporary hardcoded value until viewport is removed from theme file
    )
}