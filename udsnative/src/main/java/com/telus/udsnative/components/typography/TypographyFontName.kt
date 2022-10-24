package com.telus.udsnative.components.typography

import androidx.compose.ui.text.font.FontWeight
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.telus.udsnative.utility.TypographyUtils
import java.lang.reflect.Type


//Temporary data class to imitate text font weight.  When we receive the proper .ttf files, we'll be using that intead
data class TypographyFontName(
    val fontName: String,
    val fontWeight: FontWeight = TypographyUtils.toFontWeight(fontName)
)

class TypographyFontNameDeserializer : JsonDeserializer<TypographyFontName> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): TypographyFontName {
        return TypographyFontName(json.asJsonPrimitive.asString)
    }
}