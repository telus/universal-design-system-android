package com.telus.udsnative.components.card

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.telus.udsnative.components.card.models.CustomPadding


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
    variant: CardVariant = CardVariant(background = Background.Default, padding = Padding.Default),
    content: @Composable () -> Unit
) {

    val tokenResolver = CardTokenResolver()
    val tokens = cardTokens ?: tokenResolver.resolveTokens(variant)

    /**
     * Using BoxWithConstraints to allow for adapting content to display in a row
     * or a column depending on maxwidth. Currently we only display content in a row
     * but have the ability to change that to a column when needed
     */
    BoxWithConstraints(
        modifier = modifier
    ) {
        androidx.compose.material.Card(
            modifier = Modifier
                .border(
                    width = tokens.borderWidth!!,
                    color = tokens.borderColor!!,
                    shape = RoundedCornerShape(tokens.borderRadius!!)
                ),
            shape = RoundedCornerShape(tokens.borderRadius!!),
            backgroundColor = tokens.backgroundColor!!
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = customInnerContentPadding?.start ?: tokens.paddingLeft!!,
                        top = customInnerContentPadding?.top ?: tokens.paddingTop!!,
                        end = customInnerContentPadding?.end ?: tokens.paddingLeft!!,
                        bottom = customInnerContentPadding?.bottom ?: tokens.paddingBottom!!
                    )
            ) {
                content()
            }
        }
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
        variant = CardVariant(background = Background.Alternative, padding = Padding.Narrow)
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
        variant = CardVariant(background = Background.Alternative, padding = Padding.Custom)
    ) {
        Text(text = "content1")
        Text(text = "content2")
    }
}