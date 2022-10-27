package com.telus.udsnative.components.button

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.telus.udsnative.components.card.models.Shadow
import com.telus.udsnative.models.Tokens
import com.telus.udsnative.models.UDSColor

data class ButtonTokens(
    val backgroundColor: UDSColor,
    val borderColor: UDSColor,
    val borderRadius: Dp,
    val borderWidth: Dp,
    val color: UDSColor,
    val fontName: String,
    val fontSize: TextUnit,
    val icon: String?,
    val iconSize: Int?, //Gson having trouble deserializing Dp Optional so using Int instead
    val iconSpace: Int?,
    val iconPosition: IconPosition?,
    val lineHeight: Float?, //Gson having trouble deserializing Dp Optional so using Int instead
    val minWidth: Int? = null, //Gson having trouble deserializing Dp Optional so using Int instead
    val opacity: Dp,
    val outerBackgroundColor: UDSColor,
    val outerBorderColor: UDSColor,
    val outerBorderGap: Dp,
    val outerBorderWidth: Dp,
    val paddingBottom: Dp = 0.dp,
    val paddingLeft: Dp = 0.dp,
    val paddingRight: Dp = 0.dp,
    val paddingTop: Dp = 0.dp,
    val shadow: Shadow?,
    val textAlign: TextAlignment?,
    val textLine: TextLine,
    val textLineStyle: String //TODO change to class that is android compatable
): Tokens

enum class IconPosition {
    Left,
    Right
}
