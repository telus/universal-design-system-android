package com.telus.udsnative.components.button

import androidx.compose.ui.text.style.TextDecoration
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.telus.udsnative.utility.TextLineUtils
import java.lang.reflect.Type

data class TextLine(
    val textLine: String,
    val textDecoration: TextDecoration = TextLineUtils.toTextDecoration(textLine)
)

class TextLineDeserializer : JsonDeserializer<TextLine> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): TextLine {
        return TextLine(json.asJsonPrimitive.asString)
    }
}