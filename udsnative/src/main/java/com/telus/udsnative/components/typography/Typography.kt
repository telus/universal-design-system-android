package com.telus.udsnative.components.typography

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
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
    val resolver = ThemeResolver.resolve<TypographyTokens>(component = "Typography")
    val appearance = TypographyAppearance(variant = variant)
    val tokens = typographyTokens ?: resolver.resolve(appearance = appearance.asMap()) ?: return

    val fontSize = if (tokens.fontScaleCap != null && tokens.fontSize.sp > tokens.fontScaleCap.sp) {
        tokens.fontScaleCap.sp
    } else {
        tokens.fontSize.sp
    }

    val textToDisplay = if(tokens.textTransform == TextTransform.uppercase) {
        text.uppercase()
    } else {
        text
    }

    val fontWeight = if(tokens.fontWeight != null) {
        FontWeight(tokens.fontWeight)
    } else {
        FontWeight.Normal
    }

    Text(
        modifier = modifier,
        text = textToDisplay,
        style = TextStyle(
            fontSize = fontSize,
            color = tokens.color.color,
            letterSpacing = tokens.letterSpacing.sp,
            lineHeight = tokens.lineHeight.sp,
            fontWeight = fontWeight
        )

    )


}