package com.telus.udsnative.components.card

import androidx.compose.ui.unit.dp
import com.telus.udsnative.Palette
import com.telus.udsnative.SystemValues
import com.telus.udsnative.components.TokenResolver
import com.telus.udsnative.components.Variant

class CardTokenResolver : TokenResolver {

    // Mock Tokens based off of Allium's theme.json - Temporary
    private val cardDefaultTokens = CardTokens(
        backgroundColor = Palette.Colors.white,
        borderColor = Palette.Colors.greyMystic,
        borderRadius = Palette.Radius.radius6,
        borderWidth = Palette.Border.border1,
        flex = 1f, //similar to android weight
        minWidth = SystemValues.Size.none,
        paddingBottom = Palette.Size.size32,
        paddingLeft = Palette.Size.size24,
        paddingRight = Palette.Size.size24,
        paddingTop = Palette.Size.size32,
        shadow = 1
    )

    private val cardAlternativeBackgroundTokens = CardTokens(
        backgroundColor = Palette.Colors.greyAthens
    )

    private val cardSubtleBackgroundTokens = CardTokens(
        backgroundColor = Palette.Colors.greyAlabaster
    )

    private val cardGridBackgroundTokens = CardTokens(
        backgroundColor = Palette.Colors.greyAlabaster,
        borderWidth = Palette.Border.none
    )

    private val cardDefaultPaddingTokens = CardTokens(
        paddingBottom = Palette.Size.size32,
        paddingLeft = Palette.Size.size24,
        paddingRight = Palette.Size.size24,
        paddingTop = Palette.Size.size32
    )


    private val cardNarrowPaddingTokens = CardTokens(
        paddingBottom = Palette.Size.size24,
        paddingLeft = Palette.Size.size16,
        paddingRight = Palette.Size.size16,
        paddingTop = Palette.Size.size24
    )

    private val cardIntermediatePaddingTokens = CardTokens(
        paddingBottom = Palette.Size.size24,
        paddingLeft = Palette.Size.size24,
        paddingRight = Palette.Size.size24,
        paddingTop = Palette.Size.size24
    )

    private val cardCompactPaddingTokens = CardTokens(
        paddingBottom = Palette.Size.size16,
        paddingLeft = Palette.Size.size16,
        paddingRight = Palette.Size.size16,
        paddingTop = Palette.Size.size16
    )

    private val cardCustomPaddingTokens = CardTokens(
        paddingBottom = 0.dp,
        paddingLeft = 0.dp,
        paddingRight = 0.dp,
        paddingTop = 0.dp
    )


    override fun resolveTokens(_variant: Variant): CardTokens {
        val variant = _variant as? CardVariant ?: return cardDefaultTokens

        var tokens = cardDefaultTokens

        when (variant.background) {
            Background.Default -> tokens.apply(cardDefaultTokens)
            Background.Alternative -> tokens.apply(cardAlternativeBackgroundTokens)
            Background.Subtle -> tokens.apply(cardSubtleBackgroundTokens)
            Background.Grid -> tokens.apply(cardGridBackgroundTokens)
        }

        when (variant.padding) {
            Padding.Default -> tokens.apply(cardDefaultPaddingTokens)
            Padding.Narrow -> tokens.apply(cardNarrowPaddingTokens)
            Padding.Intermediate -> tokens.apply(cardIntermediatePaddingTokens)
            Padding.Compact -> tokens.apply(cardCompactPaddingTokens)
            Padding.Custom -> tokens.apply(cardCustomPaddingTokens)

        }

        return tokens
    }
}