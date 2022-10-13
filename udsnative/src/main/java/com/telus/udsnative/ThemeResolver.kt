package com.telus.udsnative

import com.google.gson.*
import com.google.gson.reflect.TypeToken
import com.telus.udsnative.model.Tokens
import com.telus.udsnative.components.progressbar.ProgressBarTokens
import com.telus.udsnative.components.progressbar.ProgressBarTokensDeserializer
import com.telus.udsnative.model.ComponentResolver

object ThemeResolver {
    var themeData: String? = null
    var storage: MutableMap<String, Any> = mutableMapOf()

    fun setup(jsonString: String) {
        themeData = jsonString
    }

    inline fun <reified T: Tokens> resolve(component: String): ComponentResolver<T>? {
        if (storage[component] is ComponentResolver<*>) {
            storage[component]
        }

        if (themeData == null) {
            throw IllegalStateException()
        } else {
            val gson = GsonBuilder()
                .serializeNulls()
                .registerTypeAdapter(ProgressBarTokens::class.java, ProgressBarTokensDeserializer())
                .create()

            val jsonObject = JsonParser.parseString(themeData).asJsonObject
            val componentJson = jsonObject.remove(component)

            val componentTheme = gson.fromJson<ComponentResolver<T>>(componentJson, object: TypeToken<ComponentResolver<T>>(){}.type)
            storage[component] = componentTheme

            val tokensJson = componentJson.asJsonObject.remove("tokens")

            componentTheme.rawTokens = gson.fromJson(tokensJson, object: TypeToken<Map<String, Any>>(){}.type)

            return componentTheme
        }
    }
}
