package com.telus.udsnative.components.badge


enum class Purpose {
    Default, Editorial, Offer
}

data class BadgeVariant(val purpose: Purpose, val outline: Boolean, val Alternative: Boolean)