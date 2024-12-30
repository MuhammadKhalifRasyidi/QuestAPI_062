package com.example.meet13

import android.app.Application
import com.example.meet13.dependencies.AppContainer
import com.example.meet13.dependencies.MahasiswaContainer

class MahasiswaApplications : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}
