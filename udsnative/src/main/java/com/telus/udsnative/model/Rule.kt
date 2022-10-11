package com.telus.udsnative.model

class Rule(
    val conditions: Map<String, Boolean>,
    val tokens: Map<String, Any>
)