package com.telus.udsnative.model

import com.google.gson.reflect.TypeToken
import com.telus.udsnative.ThemeResolver

data class ComponentResolver<T: Tokens>(
    val rules: List<Rule>,
    var tokens: T,

    @Transient
    var rawTokens: Map<String, Any> = mapOf()
) {
    inline fun <reified T: Tokens> resolve(appearance: Map<String, Any>): T? {
        var finalRawTokens = rawTokens

        for (rule in rules) {
            if (rule.conditions.all { appearance[it.key] != null && appearance[it.key] == it.value }) {
                finalRawTokens = finalRawTokens + rule.tokens // overwrite duplicate keys with values from rule.tokens
            }
        }

        val tokensJson = ThemeResolver.gson.toJson(finalRawTokens)
        return ThemeResolver.gson.fromJson<T>(tokensJson, object: TypeToken<T>(){}.type)
    }
}
