package com.telus.udsnative.components.progressbar

import androidx.compose.ui.unit.Dp
import com.google.gson.*
import com.telus.udsnative.models.Tokens
import com.telus.udsnative.models.PaletteGradient
import com.telus.udsnative.models.UDSColor
import java.lang.reflect.Type

data class ProgressBarTokens (
    var backgroundColor: UDSColor,
    var borderRadius: Dp,
    var gradient: PaletteGradient? = null,
    var outlineColor: UDSColor,
    var outlineWidth: Dp
): Tokens

class UDSColorDeserializer: JsonDeserializer<UDSColor> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): UDSColor {
        return UDSColor(json.asJsonPrimitive.asString)
    }
}
