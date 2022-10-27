package com.telus.udsnative.utility

import android.R.drawable
import com.telus.udsnative.R
import java.lang.reflect.Field


fun getResourceId(_iconName: String?): Int? {
    _iconName ?: return null

    //ensure icon name uses android resource naming conventions(snake case)
    val iconName = _iconName.replace("-", "_")
    return try {
        val res: Class<*> = R.drawable::class.java
        val field: Field = res.getField(iconName)
        field.getInt(null)
    } catch (e: Exception) {
        null
    }
}