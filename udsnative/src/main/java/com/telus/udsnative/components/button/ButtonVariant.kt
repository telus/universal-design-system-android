package com.telus.udsnative.components.button

data class ButtonVariant(
    val danger: Boolean = false,
    val inverse: Boolean = false,
    val priority: ButtonPriority? = null,
    val text: Boolean = false
)
