package com.osedhelu.creditbanco

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class creditbanco : Application() {

    override fun onCreate() {
        super.onCreate()
        try {

        } catch (err: Exception) {
            println("xxoxxxxxxxxxxxxxxxxxxxxxxxxxxxxx Exception $err")
        } catch (err: Throwable) {
            println("xxoxxxxxxxxxxxxxxxxxxxxxxxxxxxxx android Throwable ${err}")
        }

    }
}