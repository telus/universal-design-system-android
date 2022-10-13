package com.telus.udsnative.components.progressbar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.google.gson.*
import com.telus.udsnative.ThemeResolver
import com.telus.udsnative.models.Tokens
import com.telus.udsnative.models.PaletteGradient
import com.telus.udsnative.utility.ColorUtil
import java.lang.reflect.Type

data class ProgressBarTokens (
    var backgroundColor: Color,
    var borderRadius: Dp,
    var gradient: PaletteGradient? = null,
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

        val backgroundColor = ColorUtil.toColor(json["backgroundColor"].asString)
        val borderRadius = Dp(json["borderRadius"].asFloat)
        val gradient = if (json.has("gradient")) gradient(json.get("gradient")) else null
        val outlineColor = ColorUtil.toColor(json["outlineColor"].asString)
        val outlineWidth = Dp(json["outlineWidth"].asFloat)

        return ProgressBarTokens(
            backgroundColor = backgroundColor,
            borderRadius = borderRadius,
            gradient = gradient,
            outlineColor = outlineColor,
            outlineWidth = outlineWidth
        )
    }

    private fun gradient(json: JsonElement): PaletteGradient? {
        if (json is JsonNull) {
            return null
        }

        return ThemeResolver.gson.fromJson(json, PaletteGradient::class.java)
    }
}