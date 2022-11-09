package com.telus.udsnative

import com.google.gson.GsonBuilder
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import com.telus.udsnative.components.button.TextAlignment
import com.telus.udsnative.components.button.TextAlignmentDeserializer
import com.telus.udsnative.components.button.TextLine
import com.telus.udsnative.components.button.TextLineDeserializer
import com.telus.udsnative.components.typography.TypographyFontName
import com.telus.udsnative.components.typography.TypographyFontNameDeserializer
import com.telus.udsnative.models.ComponentResolver
import com.telus.udsnative.models.Rule
import com.telus.udsnative.models.RuleDeserializer
import com.telus.udsnative.models.Tokens

object ThemeResolver {
    var themeData: String? = null
    var storage: MutableMap<String, Any> = mutableMapOf()

    val gson = GsonBuilder()
        .serializeNulls()
        .registerTypeAdapter(Rule::class.java, RuleDeserializer())
        .registerTypeAdapter(TextAlignment::class.java, TextAlignmentDeserializer())
        .registerTypeAdapter(TextLine::class.java, TextLineDeserializer())
        .registerTypeAdapter(TypographyFontName::class.java, TypographyFontNameDeserializer())
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
            val componentsJson = jsonObject.remove("components").asJsonObject
            val componentJson = componentsJson.remove(component)

            val componentTheme = gson.fromJson<ComponentResolver<T>>(componentJson, object: TypeToken<ComponentResolver<T>>(){}.type)
            storage[component] = componentTheme

            val tokensJson = componentJson.asJsonObject.remove("tokens")

            componentTheme.rawTokens = gson.fromJson(tokensJson, object: TypeToken<Map<String, Any>>(){}.type)

            return componentTheme
        }
    }
}
