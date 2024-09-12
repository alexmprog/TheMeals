package com.alexmprog.themeals

import android.app.Application
import com.alexmprog.themeals.inject.buildGraph

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        buildGraph(this)
    }
}