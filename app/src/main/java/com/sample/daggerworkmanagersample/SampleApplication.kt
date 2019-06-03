package com.sample.daggerworkmanagersample

import android.app.Application
import androidx.work.Configuration
import androidx.work.WorkManager

//class SampleApplication(var appComponent: AppComponent) : Application() {
//
//    override fun onCreate() {
//        super.onCreate()
//        appComponent = buildComponent()
//        val factory: SampleWorkerFactory = DaggerSampleComponent.create().factory()
//        WorkManager.initialize(this, Configuration.Builder().setWorkerFactory(factory).build())
//    }
//
//    private fun buildComponent(): AppComponent {
//        return DaggerAppComponent.builder().appModule(AppModule()).build()
//    }
//}