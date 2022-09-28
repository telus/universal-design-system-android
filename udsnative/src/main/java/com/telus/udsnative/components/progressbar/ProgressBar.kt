package com.telus.udsnative.components.progressbar

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import com.telus.udsnative.components.Variant
import kotlinx.coroutines.flow.MutableStateFlow


data class ProgressBarVariant(val inactive: Boolean, val negative: Boolean) : Variant

@Composable
fun ProgressBar(
    modifier: Modifier = Modifier,
    progress: MutableStateFlow<Float>,
    variant: ProgressBarVariant = ProgressBarVariant(inactive = false, negative = false)
) {

    val progressState = progress.collectAsState()
    val tokensResolver = ProgressBarTokenResolver()
    val tokens = tokensResolver.resolveTokens(variant) as ProgressBarTokens

    LinearProgressIndicator(
        progress = progressState.value,
        modifier = modifier
            .clip(RoundedCornerShape(tokens.borderRadius))
            .border(
                width = tokens.outlineWidth,
                color = tokens.outlineColor,
                shape = RoundedCornerShape(tokens.borderRadius)
            ),
        color = tokens.backgroundColor,
        backgroundColor = tokens.backgroundColor.copy(alpha = 0.4f)
    )
}

@Preview
@Composable
fun ProgressBar_Default() {
    ProgressBar(progress = MutableStateFlow(0.5f))
}

@Preview
@Composable
fun ProgressBar_NegativeVariant() {
    ProgressBar(
        progress = MutableStateFlow(0.5f),
        variant = ProgressBarVariant(inactive = true, negative = false)
    )
}

@Preview
@Composable
fun ProgressBar_InactiveVariant() {
    ProgressBar(
        progress = MutableStateFlow(0.5f),
        variant = ProgressBarVariant(inactive = false, negative = true)
    )
}