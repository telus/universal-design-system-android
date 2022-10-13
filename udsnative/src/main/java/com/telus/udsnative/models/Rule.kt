package com.telus.udsnative.models

import com.google.gson.annotations.SerializedName

data class Rule(
    @SerializedName("if")
    val conditions: Map<String, Any>,
    val tokens: Map<String, Any>
)