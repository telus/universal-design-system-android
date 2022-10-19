package com.telus.udsnative.components.button

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.telus.udsnative.models.PaletteGradient
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
//    val iconSize: Dp?,
    val iconSpace: Int?,
    val iconPosition: IconPosition?,
//    val lineHeight: Dp?,
//    val minWidth: Dp?,
    val opacity: Dp,
    val outerBackgroundColor: UDSColor,
    val outerBorderColor: UDSColor,
    val outerBorderGap: Dp,
    val outerBorderWidth: Dp,
    val paddingBottom: Dp,
    val paddingLeft: Dp,
    val paddingRight: Dp,
    val paddingTop: Dp,
//    val shadow: Shadow?,
//    val textAlign: TextAlignment?,
//    val textLine: TextLine,
//    val textLineStyle: TextLineStyle
): Tokens {
//    var padding: EdgeInsets {
//        EdgeInsets(top: paddingTop, leading: paddingLeft, bottom: paddingBottom, trailing: paddingRight)
//    }
}

enum class IconPosition {
    Left,
    Right
}
