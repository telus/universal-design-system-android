package com.telus.udsnative

import com.telus.udsnative.components.Tokens
import com.telus.udsnative.model.ComponentResolver

object ThemeResolver {
    var themeData: String? = null
    var storage: Map<String, Any> = mapOf()

    fun setup(jsonString: String) {
        themeData = jsonString
    }

    fun <T:Tokens> resolve(component: String): ComponentResolver<T>? {
        if (storage[component] is ComponentResolver<*>) {
            storage[component]
        }

        if (themeData == null) {
            throw IllegalStateException()
        }

        return null
    }
}