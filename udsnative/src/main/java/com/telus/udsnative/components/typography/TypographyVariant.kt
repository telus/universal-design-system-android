package com.telus.udsnative.components.typography

import com.telus.udsnative.models.Variant

data class TypographyVariant(
    val bold: Boolean = false,
    val colour: TypographyColor = TypographyColor.default,
    val compact: Boolean = false,
    val inverse: Boolean = false,
    val size: TypographySize = TypographySize.default,
    val viewport: TypographyViewport = TypographyViewport.lg

) : Variant