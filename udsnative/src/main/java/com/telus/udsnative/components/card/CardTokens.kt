package com.telus.udsnative.components.card

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.telus.udsnative.components.Tokens

//temporarily optional properties but will be changed to non-optional once we use the data driven parser
data class CardTokens(
    var backgroundColor: Color? = null,
    var borderColor: Color? = null,
    var borderRadius: Dp? = null,
    var borderWidth: Dp? = null,
    var flex: Float? = null, //similar to android weight
    var minWidth: Dp? = null,
    var paddingBottom: Dp? = null,
    var paddingLeft: Dp? = null,
    var paddingRight: Dp? = null,
    var paddingTop: Dp? = null,
    var shadow: Int? = null
): Tokens {

    fun apply(tokens: CardTokens) {
        backgroundColor = tokens.backgroundColor ?: backgroundColor
        borderColor = tokens.borderColor ?: borderColor
        borderRadius = tokens.borderRadius ?: borderRadius
        borderWidth = tokens.borderWidth ?: borderWidth
        flex = tokens.flex ?: flex
        minWidth = tokens.minWidth ?: minWidth
        paddingBottom = tokens.paddingBottom ?: paddingBottom
        paddingLeft = tokens.paddingLeft ?: paddingLeft
        paddingRight = tokens.paddingRight ?: paddingRight
        paddingTop = tokens.paddingTop ?: paddingTop
        shadow = tokens.shadow ?: shadow
    }
}