package com.telus.udssampleapp

import android.app.Application
import android.content.res.AssetManager
import com.telus.udsnative.ThemeResolver

class App: Application() {
    override fun onCreate() {
        val jsonString = assets.readAssetsFile("testData/${TestTheme.allium}")
        ThemeResolver.setup(jsonString = jsonString)

        super.onCreate()
    }
}

object TestTheme {
    val allium: String = "AlliumTheme.json"
    val koodo: String = "KoodoTheme.json"
}

fun AssetManager.readAssetsFile(fileName : String): String = open(fileName).bufferedReader().use { it.readText() }