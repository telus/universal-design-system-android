package com.telus.udsnative.model

import com.google.gson.*
import com.google.gson.reflect.TypeToken
import com.telus.udsnative.components.progressbar.ProgressBarTokens
import com.telus.udsnative.components.progressbar.ProgressBarTokensDeserializer

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

        val gson = GsonBuilder()
            .serializeNulls()
            .registerTypeAdapter(ProgressBarTokens::class.java, ProgressBarTokensDeserializer())
            .create()

        val tokensJson = gson.toJson(finalRawTokens)
        return gson.fromJson<T>(tokensJson, object: TypeToken<T>(){}.type)
    }
}
