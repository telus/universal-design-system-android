package com.telus.udsnative.components.progressbar

import com.telus.udsnative.Palette
import com.telus.udsnative.SystemValues
import com.telus.udsnative.components.TokenResolver
import com.telus.udsnative.components.Tokens
import com.telus.udsnative.components.Variant

class ProgressBarTokenResolver: TokenResolver {

    // Mock Tokens based off of Allium's theme.json - Temporary
    private val progressBarDefaultTokens = ProgressBarTokens()

    private val progressBarNegativeVariantTokens = ProgressBarTokens(
        backgroundColor = Palette.Colors.redDark,
        gradient = SystemValues.Gradient.none,
        outlineColor = Palette.Colors.redDark
    )

    private val progressBarInactiveVariantTokens = ProgressBarTokens(
        backgroundColor = Palette.Colors.greyCloud,
        gradient = SystemValues.Gradient.none,
        outlineColor = Palette.Colors.greyThunder
    )

    // Mock resolution - Temporary
    override fun resolveTokens(_variant: Variant): ProgressBarTokens {
        val variant = _variant as? ProgressBarVariant ?: return progressBarDefaultTokens

        var tokens = progressBarDefaultTokens

        if (variant.inactive) {
            tokens.apply(progressBarInactiveVariantTokens)
        }

        if(variant.negative) {
            tokens.apply(progressBarNegativeVariantTokens)
        }

        return tokens
    }

}
