package com.telus.udsnative.model

import com.google.gson.annotations.SerializedName

class Rule(
    @SerializedName("if")
    val conditions: Map<String, Boolean>,
    val tokens: Map<String, Any>
)

//class Condition(
//    val name: String,
//    val value: Any
//)