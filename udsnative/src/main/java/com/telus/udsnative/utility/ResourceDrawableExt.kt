package com.telus.udsnative.utility

import android.R.drawable
import java.lang.reflect.Field


fun getResourceId(iconName: String?): Int? {
    iconName ?: return null

    return try {
        val res: Class<*> = drawable::class.java
        val field: Field = res.getField("drawableName")
        field.getInt(null)
    } catch (e: Exception) {
        null
    }
}