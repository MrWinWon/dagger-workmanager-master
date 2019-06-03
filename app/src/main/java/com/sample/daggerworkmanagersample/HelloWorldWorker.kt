package com.sample.daggerworkmanagersample

import android.content.Context
import android.util.Log
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerFactory
import androidx.work.WorkerParameters
//import com.squareup.inject.assisted.Assisted
//import com.squareup.inject.assisted.AssistedInject
import javax.inject.Inject
import javax.inject.Provider

class Foo @Inject constructor()

class HelloWorldWorker  constructor(
    appContext: Context,
    params: WorkerParameters,
    private val foo: Foo,
    private val loggerModel: LoggerModel
) : Worker(appContext, params) {
    private val TAG = "HelloWorldWorker"
    override fun doWork(): Result {
        Log.d(TAG, "Hello world!")
        Log.d(TAG, "Injected foo: $foo")
        Log.d(TAG, "Injected foo: $loggerModel")
        return Result.success()
    }

//    @AssistedInject.Factory
//    interface Factory : ChildWorkerFactory

    class Factory @Inject constructor(
        private val foo: Provider<Foo>,
        private val loggerModel: Provider<LoggerModel>
    ):ChildWorkerFactory {
        override fun create(appContext: Context, params: WorkerParameters): ListenableWorker {
            return HelloWorldWorker(
                appContext,
                params,
                foo.get(),
                loggerModel.get()
                )
        }
    }
}

public interface ChildWorkerFactory {
    fun create(appContext: Context, params: WorkerParameters): ListenableWorker
}

