package com.telus.udsnative.components.progressbar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.core.graphics.toColorInt
import com.google.gson.*
import com.telus.udsnative.components.Tokens
import java.lang.reflect.Type

data class ProgressBarTokens (
    var backgroundColor: Color,
    var borderRadius: Dp,
    var gradient: Color? = null,
    var outlineColor: Color,
    var outlineWidth: Dp
): Tokens

class ProgressBarTokensDeserializer : JsonDeserializer<ProgressBarTokens> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement, typeOfT: Type,
        context: JsonDeserializationContext
    ): ProgressBarTokens {
        json as JsonObject

        val backgroundColor = toColor(json["backgroundColor"].asString)
        val borderRadius = Dp(json["borderRadius"].asFloat)
        val gradient = if (json.has("gradient")) gradient(json.get("gradient")) else null
        val outlineColor = toColor(json["outlineColor"].asString)
        val outlineWidth = Dp(json["outlineWidth"].asFloat)

        return ProgressBarTokens(
            backgroundColor = backgroundColor,
            borderRadius = borderRadius,
            gradient = gradient,
            outlineColor = outlineColor,
            outlineWidth = outlineWidth
        )
    }

    private fun gradient(json: JsonElement): Color? {
        if (json is JsonNull) {
            return null
        }

        return toColor(json.asString)
    }

    private fun toColor(colorString: String): Color {
        val pattern = """rgba?\((?<red>[0-9]{1,3}),\s?(?<green>[0-9]{1,3}),?\s?(?<blue>[0-9]{1,3}).\s?(?<alpha>[0-9]*)?\)?""".toRegex()

        val result = pattern.find(colorString)

        // convert hex string
        if (result == null) {
            return Color(colorString.toColorInt())
        }

        // convert rbga string
        val list = result.groups.toList()

        val red = list[1]?.value?.toIntOrNull() ?: 0
        val green = list[2]?.value?.toIntOrNull() ?: 0
        val blue = list[3]?.value?.toIntOrNull() ?: 0
        val alpha = list[4]?.value?.toIntOrNull() ?: 0

        return Color(red = red, green = green, blue = blue, alpha = alpha)
    }
}