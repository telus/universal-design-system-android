package com.telus.udsnative.components.progressbar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.core.graphics.toColorInt
import com.google.gson.*
import com.google.gson.annotations.SerializedName
import com.telus.udsnative.components.Tokens
import java.lang.reflect.Type

data class ProgressBarTokens (
    var backgroundColor: Color,
    var borderRadius: Dp,
    var gradient: Color,
    var outlineColor: Color,
    var outlineWidth: Dp
): Tokens

class ProgressBarTokensDeserializer : JsonDeserializer<ProgressBarTokens> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement, typeOfT: Type,
        context: JsonDeserializationContext
    ): ProgressBarTokens {
        val jsonObject = json as JsonObject

        val backgroundColor = Color(jsonObject["backgroundColor"].asString.toColorInt())
        val borderRadius = Dp(jsonObject["borderRadius"].asFloat)
        val gradient = Color(jsonObject["gradient"].asString.toColorInt())
        val outlineColor = Color(jsonObject["outlineColor"].asString.toColorInt())
        val outlineWidth = Dp(jsonObject["outlineWidth"].asFloat)

        return ProgressBarTokens(
            backgroundColor = backgroundColor,
            borderRadius = borderRadius,
            gradient = gradient,
            outlineColor = outlineColor,
            outlineWidth = outlineWidth
        )
    }
}