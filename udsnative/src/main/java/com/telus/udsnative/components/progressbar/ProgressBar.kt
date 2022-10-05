package com.telus.udsnative.components.progressbar

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * @param modifier: Separate modifier to provide more customization of ProgressBar such as size, padding, etc
 * @param progress: The progress value of the progress bar from 0 to 1.  Type is MutableStateFlow so view will automatically
 * update as progress param value is changed
 * @param progressBarTokens: The list of tokens for progressBar to override to look and feel of the progressbar.  This
 * value overrides any tokens provided
 * @param variant: Variant types to display. A default variant is used if one is not provided
 */
@Composable
fun ProgressBar(
    modifier: Modifier = Modifier,
    progress: MutableStateFlow<Float>,
    progressBarTokens: ProgressBarTokens? = null,
    variant: ProgressBarVariant = ProgressBarVariant(inactive = false, negative = false)
) {

    val progressState = progress.collectAsState()
    val tokensResolver = ProgressBarTokenResolver()
    val tokens = progressBarTokens ?: tokensResolver.resolveTokens(variant)

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
private fun ProgressBar_Default() {
    ProgressBar(progress = MutableStateFlow(0.5f))
}

@Preview
@Composable
private fun ProgressBar_NegativeVariant() {
    ProgressBar(
        progress = MutableStateFlow(0.5f),
        variant = ProgressBarVariant(negative = true)
    )
}

@Preview
@Composable
private fun ProgressBar_InactiveVariant() {
    ProgressBar(
        progress = MutableStateFlow(0.5f),
        variant = ProgressBarVariant(inactive = true)
    )
}