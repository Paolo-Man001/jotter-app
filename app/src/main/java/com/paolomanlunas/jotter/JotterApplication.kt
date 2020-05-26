package com.paolomanlunas.jotter

import android.app.Application
import timber.log.Timber

class JotterApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}