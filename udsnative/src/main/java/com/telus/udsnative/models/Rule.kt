package com.telus.udsnative.models

import com.google.gson.*
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import com.telus.udsnative.ThemeResolver
import java.lang.reflect.Type

data class Rule(
    val conditions: List<Condition>,
    val tokens: Map<String, Any>
)

data class Condition(
    val name: String,
    val value: Any
)

class RuleDeserializer: JsonDeserializer<Rule> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Rule {
        json as JsonObject

        val conditionsMap = ThemeResolver.gson.fromJson<Map<String, Any>>(json["if"], object : TypeToken<Map<String, Any>>() {}.type)
        val conditions: List<Condition> = conditionsMap.map {
            Condition(
                name = it.key,
                value = it.value
            )
        }
        val tokens = ThemeResolver.gson.fromJson<Map<String, Any>>(json["tokens"], object : TypeToken<Map<String, Any>>() {}.type)

        return Rule(
            conditions = conditions,
            tokens = tokens
        )
    }
}