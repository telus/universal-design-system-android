package com.telus.udsnative.components.card


import androidx.compose.ui.unit.Dp
import com.telus.udsnative.components.card.models.Shadow
import com.telus.udsnative.models.Tokens
import com.telus.udsnative.models.UDSColor

data class CardTokens(
    var backgroundColor: UDSColor,
    var borderColor: UDSColor,
    var borderRadius: Dp,
    var borderWidth: Dp,
    var minWidth: Dp,
    var paddingBottom: Dp,
    var paddingLeft: Dp,
    var paddingRight: Dp,
    var paddingTop: Dp,
    var shadow: Shadow
): Tokens