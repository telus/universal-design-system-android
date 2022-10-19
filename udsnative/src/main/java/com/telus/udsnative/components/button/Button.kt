package com.telus.udsnative.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.telus.udsnative.ThemeResolver
import com.telus.udsnative.components.progressbar.ProgressBarTokens
import com.telus.udsnative.components.progressbar.ProgressBarVariant
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * @param modifier: Separate modifier to provide more customization of Button such as size, padding, etc.
 * @param buttonTokens: The list of tokens for Button to override the look and feel of the button. This value overrides any tokens provided via the resolver.
 * @param variant: ButtonVariant types to display. A default variant is used if one is not provided
 */
@Composable
fun Button(
    text: String,
    modifier: Modifier = Modifier,
    buttonTokens: ButtonTokens? = null,
    variant: ButtonVariant = ButtonVariant(),
    state: ButtonState = ButtonState.Normal,
    onClick: () -> Unit
) {
    val resolver = ThemeResolver.resolve<ButtonTokens>(component = "Button")
    val appearance = ButtonAppearance(variant = variant, state = state)
    val tokens = buttonTokens ?: resolver.resolve(appearance = appearance.asMap()) ?: return

    androidx.compose.material.Button(
        onClick = onClick,
        modifier = modifier,
        enabled = appearance.state != ButtonState.Inactive
        ) {
        Text(
            text = text,
            fontSize = tokens.fontSize,
            color = tokens.color.color
        )
    }
}
