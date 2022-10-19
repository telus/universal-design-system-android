package com.telus.udsnative.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.telus.udsnative.ThemeResolver
import com.telus.udsnative.utility.getResourceId
import kotlinx.coroutines.flow.collect

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

    /**
     * Creating a click state observable that will override the ButtonState of Appearance to "Pressed" when button is clicked
     */
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val buttonState = if(isPressed) ButtonState.Pressed else state

    /**
     * Generating tokens from the variant provided
     */
    val resolver = ThemeResolver.resolve<ButtonTokens>(component = "Button")
    val appearance = ButtonAppearance(variant = variant, state = buttonState)
    val tokens = buttonTokens ?: resolver.resolve(appearance = appearance.asMap()) ?: return

    /**
     * prepare icon if it exists within tokens
     */
    val iconResourceId = getResourceId(tokens.icon)


    Button(
        onClick = onClick,
        modifier = modifier
            .indication(
                interactionSource = interactionSource,
                indication = null
            ),
        interactionSource = interactionSource,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = tokens.backgroundColor.color
        ),
        shape = RoundedCornerShape(tokens.borderRadius),
        border = BorderStroke(tokens.borderWidth, tokens.borderColor.color),
        enabled = appearance.state != ButtonState.Inactive
        ) {

        if(iconResourceId != null && tokens.iconPosition == IconPosition.Left) {
            Image(painter = painterResource(id = iconResourceId), contentDescription = "")
        }
        Text(
            text = text,
            fontSize = tokens.fontSize,
            color = tokens.color.color
        )
    }
}
