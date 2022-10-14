package com.telus.udsnative.components.progressbar

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.telus.udsnative.ThemeResolver
import com.telus.udsnative.models.ComponentResolver
import com.telus.udsnative.utility.drawLinearIndicator
import com.telus.udsnative.utility.drawLinearIndicatorBackground
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * @param modifier: Separate modifier to provide more customization of ProgressBar such as size, padding, etc.
 * @param progress: The progress value of the progress bar from 0 to 1.  Type is MutableStateFlow so view will automatically update as progress param value is changed.
 * @param progressBarTokens: The list of tokens for progressBar to override the look and feel of the progressbar. This value overrides any tokens provided via the resolver.
 * @param variant: ProgressBarVariant types to display. A default variant is used if one is not provided.
 * @param inactive: Boolean that indicates whether the component is inactive, false by default.
 */
@Composable
fun ProgressBar(
    modifier: Modifier = Modifier,
    progress: MutableStateFlow<Float>,
    progressBarTokens: ProgressBarTokens? = null,
    variant: ProgressBarVariant = ProgressBarVariant(),
    inactive: Boolean = false
) {
    val progressState = progress.collectAsState()
    val componentResolver = ThemeResolver.resolve<ProgressBarTokens>(component = "ProgressBar")

    if (componentResolver !is ComponentResolver<ProgressBarTokens>) { return }

    val appearance = ProgressBarAppearance(variant = variant, inactive = inactive).asMap()
    val tokens = progressBarTokens ?: componentResolver.resolve(appearance = appearance) ?: return

    val brush = tokens.gradient?.colors?.let { Brush.linearGradient(it) }

    Canvas(
        modifier
            .progressSemantics(progressState.value)
            .size(LinearIndicatorWidth, LinearIndicatorHeight)
            .clip(RoundedCornerShape(tokens.borderRadius))
            .border(
                width = tokens.outlineWidth,
                color = tokens.outlineColor.color,
                shape = RoundedCornerShape(tokens.borderRadius)
            )
    ) {
        val strokeWidth = size.height
        drawLinearIndicatorBackground(Color(0xFFFFFFFF), strokeWidth)

        if (brush == null) {
            drawLinearIndicator(0f, progressState.value, tokens.backgroundColor.color, strokeWidth)
        } else {
            drawLinearIndicator(0f, progressState.value, brush, strokeWidth)
        }
    }
}

private val LinearIndicatorHeight = 8.dp
private val LinearIndicatorWidth = 240.dp

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
        inactive = true
    )
}
