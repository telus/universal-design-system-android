package com.telus.udsnative

import com.google.gson.*
import com.google.gson.reflect.TypeToken
import com.telus.udsnative.components.button.TextAlignment
import com.telus.udsnative.components.button.TextAlignmentDeserializer
import com.telus.udsnative.components.button.TextLine
import com.telus.udsnative.components.button.TextLineDeserializer
import com.telus.udsnative.models.Tokens
import com.telus.udsnative.models.UDSColor
import com.telus.udsnative.components.progressbar.UDSColorDeserializer
import com.telus.udsnative.models.ComponentResolver
import com.telus.udsnative.models.Rule
import com.telus.udsnative.models.RuleDeserializer

object ThemeResolver {
    var themeData: String? = null
    var storage: MutableMap<String, Any> = mutableMapOf()

    val gson = GsonBuilder()
        .serializeNulls()
        .registerTypeAdapter(Rule::class.java, RuleDeserializer())
        .registerTypeAdapter(UDSColor::class.java, UDSColorDeserializer())
        .registerTypeAdapter(TextAlignment::class.java, TextAlignmentDeserializer())
        .registerTypeAdapter(TextLine::class.java, TextLineDeserializer())
        .create()

    fun setup(jsonString: String) {
        themeData = jsonString
    }

    inline fun <reified T: Tokens> resolve(component: String): ComponentResolver<T> {
        if (storage[component] is ComponentResolver<*>) {
            return storage[component] as ComponentResolver<T>
        }

        if (themeData == null) {
            throw IllegalStateException()
        } else {
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
