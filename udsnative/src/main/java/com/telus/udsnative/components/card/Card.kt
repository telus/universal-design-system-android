package com.telus.udsnative.components.card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.telus.udsnative.ThemeResolver
import com.telus.udsnative.components.card.models.CustomPadding
import com.telus.udsnative.models.ComponentResolver
import com.telus.udsnative.utility.advancedShadow


/**
 * @param modifier: Separate modifier to provide more customization of Card such as size, padding, etc
 * @param customInnerContentPadding: custom inner padding to the card if the custom variant padding is selected
 * @param cardTokens: The list of tokens for Card to override to look and feel of the Card.  This
 * value overrides any tokens provided
 * @param variant: Variant types to display. A default variant is used if one is not provided
 */
@Composable
fun Card(
    modifier: Modifier = Modifier,
    customInnerContentPadding: CustomPadding? = null,
    cardTokens: CardTokens? = null,
    variant: CardVariant = CardVariant(),
    horizontalAlignment: Alignment.Horizontal = Alignment.Start,
    content: @Composable () -> Unit
) {

    val componentResolver = ThemeResolver.resolve<CardTokens>(component = "Card")

    if (componentResolver !is ComponentResolver<CardTokens>) {
        return
    }

    val appearance = CardAppearance(variant = variant).asMap()
    val tokens = cardTokens ?: componentResolver.resolve(appearance = appearance) ?: return

    var cardModifier = modifier
        .border(
            width = tokens.borderWidth,
            color = tokens.borderColor.color,
            shape = RoundedCornerShape(tokens.borderRadius)
        )

    if(tokens.shadow != null) {
        cardModifier = cardModifier.advancedShadow(
            color = tokens.shadow.color.color,
            cornersRadius = tokens.shadow.spread,
            shadowBlurRadius = tokens.shadow.blur,
            offsetX = tokens.shadow.offsetX,
            offsetY = tokens.shadow.offsetY
        )
    }

        Column (
            modifier = cardModifier
                .clip(RoundedCornerShape(tokens.borderRadius))
                .background(tokens.backgroundColor.color)
                .padding(
                    start = customInnerContentPadding?.start ?: tokens.paddingLeft,
                    top = customInnerContentPadding?.top ?: tokens.paddingTop,
                    end = customInnerContentPadding?.end ?: tokens.paddingLeft,
                    bottom = customInnerContentPadding?.bottom ?: tokens.paddingBottom
                ),
            horizontalAlignment = horizontalAlignment
        ) {
            content()
        }

}

@Preview
@Composable
fun CardDefaultPreview() {
    Card(
        modifier = Modifier
            .width(300.dp)
            .height(200.dp)
    ) {
        Text(text = "content1")
        Text(text = "content2")
    }
}

@Preview
@Composable
fun CardAlternativePreview() {
    Card(
        modifier = Modifier
            .width(300.dp)
            .height(200.dp),
        variant = CardVariant(background = Background.alternative, padding = Padding.narrow)
    ) {
        Text(text = "content1")
        Text(text = "content2")
    }
}

@Preview
@Composable
fun CardAlternativeCustomPaddingPreview() {
    Card(
        modifier = Modifier
            .width(300.dp)
            .height(200.dp),
        customInnerContentPadding = CustomPadding(start = 50.dp),
        variant = CardVariant(background = Background.alternative, padding = Padding.default)
    ) {
        Text(text = "content1")
        Text(text = "content2")
    }
}