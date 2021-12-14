package ru.kulagin.lab9_10.common

import android.app.Application
import ru.kulagin.lab9_10.MainRouter

class App : Application() {
    lateinit var mainRouter: MainRouter
    override fun onCreate() {
        super.onCreate()
    }
}