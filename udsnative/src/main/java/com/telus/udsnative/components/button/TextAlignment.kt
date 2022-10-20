package com.telus.udsnative.components.button

import androidx.compose.ui.Alignment
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.telus.udsnative.utility.TextAlignmentUtils
import java.lang.reflect.Type

data class TextAlignment(
    val textAlign: String,
    val alignment: Alignment.Horizontal = TextAlignmentUtils.toArrangement(textAlign)
)

class TextAlignmentDeserializer : JsonDeserializer<TextAlignment> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): TextAlignment {
        return TextAlignment(json.asJsonPrimitive.asString)
    }
}