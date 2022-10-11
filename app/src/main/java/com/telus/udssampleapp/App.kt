package com.telus.udssampleapp

import android.app.Application
import android.content.res.AssetManager
import com.telus.udsnative.ThemeResolver

class App: Application() {
    override fun onCreate() {
        setupTheme(theme = TestTheme.allium.fileName)

        super.onCreate()
    }

    private fun setupTheme(theme: String) {
        val jsonString = assets.readAssetsFile("testData/${theme}")
        ThemeResolver.setup(jsonString = jsonString)
    }
}

enum class TestTheme(val fileName: String) {
    allium("AlliumTheme.json"),
    koodo("KoodoTheme.json")
}

fun AssetManager.readAssetsFile(fileName : String): String = open(fileName).bufferedReader().use { it.readText() }