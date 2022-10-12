package com.telus.udsnative.model

import com.telus.udsnative.components.Tokens
import com.telus.udsnative.components.progressbar.ProgressBarTokens

data class ComponentResolver<T: Tokens>(
    val rules: List<Rule>,
    val tokens: T,
    val rawTokens: Map<String, Any>
) {
//    inline fun <reified T: Tokens> resolve(appearance: Map<String, Any>): T? {
//
//    }
}