package com.telus.udsnative.models

import com.google.gson.reflect.TypeToken
import com.telus.udsnative.ThemeResolver
import com.telus.udsnative.TokensCache

data class ComponentResolver<T: Tokens>(
    val rules: List<Rule>,
    var tokens: T,

    @Transient
    var rawTokens: Map<String, Any> = mapOf(),

    @Transient
    var tokensCache: TokensCache?
) {
    inline fun <reified T: Tokens> resolve(appearance: Map<String, Any?>): T? {
        if (tokensCache == null) tokensCache = TokensCache()

        var finalRawTokens = rawTokens

        val cachedState = tokensCache?.tokens(key = appearance.hashCode())

        if (cachedState != null) {
            return cachedState as? T
        } else {
            for (rule in rules) {
                if (rule.conditions
                        .all {
                            when {
                                /**
                                 * The value of the rule could be null but still exist as a condition. So we need to check if the rule exist
                                 * within the Component's appearance and apply he proper token values
                                 */
                                appearance[it.name] == null && it.value == null -> true
                                else -> when (it.value) {
                                    /**
                                     * A condition may return a list of possible appearances instead of just a single appearance. In this case we should
                                     * parse the condition as an array and see if the appearance exists within the list
                                     */
                                    is ArrayList<*> -> {
                                        it.value.contains(appearance[it.name])
                                    }
                                    else -> appearance[it.name] != null && appearance[it.name] == it.value
                                }



                            }
                        }
                ) {
                    finalRawTokens = finalRawTokens + rule.tokens // overwrite duplicate keys with values from rule.tokens
                }
            }

            val tokensJson = ThemeResolver.gson.toJson(finalRawTokens)
            val tokens = ThemeResolver.gson.fromJson<T>(tokensJson, object : TypeToken<T>() {}.type)
            tokensCache?.updateCache(key = appearance.hashCode(), tokens = tokens)

            return tokens
        }
    }
}
