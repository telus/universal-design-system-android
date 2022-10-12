package com.telus.udsnative.components.progressbar

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.telus.udsnative.ThemeResolver
import com.telus.udsnative.components.Appearance
import com.telus.udsnative.model.ComponentResolver
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
    variant: ProgressBarVariant = ProgressBarVariant(),
    enabled: Boolean = true
) {
    val progressState = progress.collectAsState()
    val componentResolver = ThemeResolver.resolve<ProgressBarTokens>(component = "ProgressBar")

    if (componentResolver !is ComponentResolver<ProgressBarTokens>) { return }

    val appearance = ProgressBarAppearance(variant = variant, isInactive = !enabled).asMap()
    val tokens = progressBarTokens ?: componentResolver.resolve(appearance = appearance) ?: return

//    LinearProgressIndicator(
//        progress = progressState.value,
//        modifier = modifier
//            .clip(RoundedCornerShape(tokens.borderRadius))
//            .border(
//                width = tokens.outlineWidth,
//                color = tokens.outlineColor,
//                shape = RoundedCornerShape(tokens.borderRadius)
//            )
//            .background(Brush.horizontalGradient(listOf(Color(0xffFD7D20), Color(0xffFBE41A)))),
//        color = tokens.gradient ?: tokens.backgroundColor,
//        backgroundColor = Color(0xFFFFFFFF)
//    )

    val brush = Brush.horizontalGradient(listOf(Color(0xffFD7D20), Color(0xffFBE41A)))

    Canvas(
        modifier
            .progressSemantics(progressState.value)
            .size(LinearIndicatorWidth, LinearIndicatorHeight)
            .clip(RoundedCornerShape(tokens.borderRadius))
            .border(
                width = tokens.outlineWidth,
                color = tokens.outlineColor,
                shape = RoundedCornerShape(tokens.borderRadius)
            )
    ) {
        val strokeWidth = size.height
        drawLinearIndicatorBackground(Color(0xFFFFFFFF), strokeWidth)
        drawLinearIndicator(0f, progressState.value, brush, strokeWidth)
    }
}

private val LinearIndicatorHeight = ProgressIndicatorDefaults.StrokeWidth
private val LinearIndicatorWidth = 240.dp

class ProgressBarAppearance(variant: ProgressBarVariant, isInactive: Boolean): Appearance {
    val inactive: Boolean
    val negative: Boolean

    init {
        inactive = isInactive
        negative = variant.negative
    }

    override fun asMap(): Map<String, Any> = mapOf(
        "inactive" to inactive,
        "negative" to negative
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
        enabled = false
    )
}

private fun DrawScope.drawLinearIndicator(
    startFraction: Float,
    endFraction: Float,
    color: Color,
    strokeWidth: Float
) {
    val width = size.width
    val height = size.height
    // Start drawing from the vertical center of the stroke
    val yOffset = height / 2

    val isLtr = layoutDirection == LayoutDirection.Ltr
    val barStart = (if (isLtr) startFraction else 1f - endFraction) * width
    val barEnd = (if (isLtr) endFraction else 1f - startFraction) * width

    // Progress line
    drawLine(color, Offset(barStart, yOffset), Offset(barEnd, yOffset), strokeWidth)
}

private fun DrawScope.drawLinearIndicator(
    startFraction: Float,
    endFraction: Float,
    brush: Brush,
    strokeWidth: Float
) {
    val width = size.width
    val height = size.height
    // Start drawing from the vertical center of the stroke
    val yOffset = height / 2

    val isLtr = layoutDirection == LayoutDirection.Ltr
    val barStart = (if (isLtr) startFraction else 1f - endFraction) * width
    val barEnd = (if (isLtr) endFraction else 1f - startFraction) * width

    // Progress line
    drawLine(brush, Offset(barStart, yOffset), Offset(barEnd, yOffset), strokeWidth)
}

private fun DrawScope.drawLinearIndicatorBackground(
    color: Color,
    strokeWidth: Float
) = drawLinearIndicator(0f, 1f, color, strokeWidth)
