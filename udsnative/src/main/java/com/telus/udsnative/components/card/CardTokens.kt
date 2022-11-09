package com.telus.udsnative.components.card


import androidx.compose.ui.unit.Dp
import com.telus.udsnative.components.card.models.Shadow
import com.telus.udsnative.models.Tokens
import com.telus.udsnative.models.UDSColor

data class CardTokens(
    val backgroundColor: UDSColor,
    val borderColor: UDSColor,
    val borderRadius: Dp,
    val borderWidth: Dp,
    val minWidth: Dp,
    val paddingBottom: Dp,
    val paddingLeft: Dp,
    val paddingRight: Dp,
    val paddingTop: Dp,
    val shadow: Shadow?
): Tokens