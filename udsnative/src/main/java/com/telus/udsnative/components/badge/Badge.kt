package com.telus.udsnative.components.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Badge(
    modifier: Modifier = Modifier,
    text: String,
    badgeVariant: BadgeVariant = BadgeVariant(purpose = Purpose.Default, outline = false, Alternative = false)
) {
    androidx.compose.material.Badge(
        modifier = Modifier
            .border(
                width = 1.dp,
                //set a gradient angled at 45 degress from the top left to the bottom right
                brush = Brush.linearGradient(
                    colors = listOf(Color.Red, Color.Green),
                    start = Offset(0f, 0f),
                    end = Offset(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)
                ),
                shape = RoundedCornerShape(2.dp)
            ),
        backgroundColor = Color.Transparent,
        contentColor = Color.Red
    ) {
        Text(text = text)

    }
}

@Preview
@Composable
fun BadgePreview() {
    Badge(text = "testing")
}