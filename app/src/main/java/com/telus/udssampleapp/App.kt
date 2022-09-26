package com.telus.udssampleapp

import android.app.Application
import com.telus.udsnative.UDSLibrary

class App: Application() {


    override fun onCreate() {
        super.onCreate()

        //configure UDS Library with them and pallet tokens
        UDSLibrary.configure("", "")
    }

}