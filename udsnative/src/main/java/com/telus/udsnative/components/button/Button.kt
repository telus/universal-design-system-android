package com.telus.udsnative.components.button

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.telus.udsnative.ThemeResolver
import com.telus.udsnative.utility.advancedShadow
import com.telus.udsnative.utility.getResourceId

/**
 * @param text: The text displayed on the button
 * @param modifier: Separate modifier to provide more customization of Button such as size, padding, etc.
 * @param buttonTokens: The list of tokens for Button to override the look and feel of the button. This value overrides any tokens provided via the resolver.
 * @param variant: ButtonVariant types to display. A default variant is used if one is not provided
 * @param state: The state of the button.  Either Inactive or Normal.  When inactive, the click action on button is ignored
 * @param onClick: the action taken when the button is clicked.
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
    var boxModifier = Modifier.border(
        shape = RoundedCornerShape(tokens.borderRadius),
        width = tokens.outerBorderWidth,
        color = tokens.outerBorderColor.color
    )

    if(tokens.shadow != null) {
        boxModifier = boxModifier.advancedShadow(
            color = tokens.shadow.color.color,
            cornersRadius = tokens.shadow.spread,
            shadowBlurRadius = tokens.shadow.blur,
            offsetX = tokens.shadow.offsetX,
            offsetY = tokens.shadow.offsetY
        )
    }

    Box(modifier = boxModifier) {

        //initializing button content styles
        val contentSpacing = tokens.iconSpace?.dp ?: 0.dp
        val contentAlignment = tokens.textAlign?.alignment ?: Alignment.CenterHorizontally

        Row(
            modifier = modifier
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = onClick,
                    enabled = appearance.state != ButtonState.Inactive
                )
                .padding(2.dp + tokens.outerBorderGap)
                .indication(
                    interactionSource = interactionSource,
                    indication = null
                )
                .background(
                    color = tokens.backgroundColor.color,
                    shape = RoundedCornerShape(tokens.borderRadius)
                )
                .border(
                    shape = RoundedCornerShape(tokens.borderRadius),
                    width = tokens.borderWidth,
                    color = tokens.borderColor.color
                )
                .clip(shape = RoundedCornerShape(tokens.borderRadius))
                .padding(start = tokens.paddingLeft, top = tokens.paddingTop, end = tokens.paddingRight, bottom = tokens.paddingBottom),
            horizontalArrangement = Arrangement.spacedBy(
                space = contentSpacing,
                alignment = contentAlignment
            )
        ) {

            if(iconResourceId != null && tokens.iconPosition == IconPosition.Left) {
                Image(
                    painter = painterResource(id = iconResourceId),
                    contentDescription = "") //TODO need ot include contentDescription for accessibility
            }

            Text(
                text = text,
                fontSize = tokens.fontSize,
                color = tokens.color.color,
                textDecoration = tokens.textLine.textDecoration
            )

            if(iconResourceId != null && tokens.iconPosition == IconPosition.Right) {
                Image(
                    painter = painterResource(id = iconResourceId),
                    contentDescription = "") //TODO need ot include contentDescription for accessibility
            }
        }
    }
}
