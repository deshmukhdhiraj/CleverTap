package com.example.clevertapapp

import android.app.Application
import com.example.clevertabsdk.LibCleverTap
import com.example.clevertabsdk.LibCleverTapFactory.Companion.instance

class HostApplication : Application() {


    lateinit var libCleverTap: LibCleverTap


    override fun onCreate() {
        super.onCreate()


        libCleverTap = instance


    }
}