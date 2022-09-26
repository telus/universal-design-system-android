package com.telus.udsnative

import com.google.gson.Gson
import com.telus.udsnative.configuration.PalletTokens
import com.telus.udsnative.configuration.ThemeTokens

object UDSLibrary {

    //configured pallet for library
    private lateinit var pallet: PalletTokens

    //configured theme for library
    private lateinit var theme: ThemeTokens

    //gson used for serialization
    private val gson = Gson()

    /**
     * Initial method that needs to be called in order to properly configure
     * the USD library. If this is not initialized, there will be no theme
     * nor pallet attached to the components
     */
    fun configure(themeJson: String, palletJson: String) {
        theme = gson.fromJson(themeJson, ThemeTokens::class.java)
        pallet = gson.fromJson(palletJson, PalletTokens::class.java)
    }
}