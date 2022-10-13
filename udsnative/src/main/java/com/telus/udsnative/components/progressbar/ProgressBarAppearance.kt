package com.telus.udsnative.components.progressbar

import com.telus.udsnative.model.Appearance

class ProgressBarAppearance(variant: ProgressBarVariant, inactive: Boolean): Appearance {
    val inactive: Boolean
    val negative: Boolean

    init {
        this.inactive = inactive
        negative = variant.negative
    }

    override fun asMap(): Map<String, Any> = mapOf(
        "inactive" to inactive,
        "negative" to negative
    )
}
