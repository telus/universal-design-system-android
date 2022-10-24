package com.telus.udsnative.components.typography

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.telus.udsnative.ThemeResolver


/**
 * @param text: the text to set to the typography
 * @param modifier: Separate modifier to provide more customization of Typography such as size, padding, etc.
 * @param typographyTokens: The list of tokens for Typography to override the look and feel of the text. This value overrides any tokens provided via the resolver.
 * @param variant: TypographyVariant types to display. A default variant is used if one is not provided
 */
@Composable
fun Typography(
    text: String,
    modifier: Modifier = Modifier,
    typographyTokens: TypographyTokens? = null,
    variant: TypographyVariant = TypographyVariant(),
) {

    /**
     * Generating tokens from the variant provided
     */
    val resolver = ThemeResolver.resolve<TypographyTokens>(component = "Button")
    val appearance = TypographyAppearance(variant = variant)
    val tokens = typographyTokens ?: resolver.resolve(appearance = appearance.asMap()) ?: return

    Text(text = text)


}