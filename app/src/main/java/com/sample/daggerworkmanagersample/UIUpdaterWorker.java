package com.sample.daggerworkmanagersample;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;
import javax.inject.Provider;

public class UIUpdaterWorker extends Worker {
    private final LoggerModel loggerModel;
    private final Foo foo;
    private final String TAG = getClass().getSimpleName();

    public UIUpdaterWorker(@NonNull Context context, @NonNull WorkerParameters workerParams, LoggerModel loggerModel, Foo foo) {
        super(context, workerParams);
        this.loggerModel = loggerModel;
        this.foo = foo;
    }

    @NonNull
    @Override
    public Result doWork() {
        Log.d(TAG, "Hello world!");
        Log.d(TAG, "Injected foo: " + foo);
        Log.d(TAG, "Injected foo: " + loggerModel);
        return Result.success();
    }

    public static class Factory implements ChildWorkerFactory {
        private final Provider<Foo> fooProvider;
        private final Provider<LoggerModel> loggerModelProvider;

        @Inject
        public Factory(Provider<Foo> fooProvider, Provider<LoggerModel> loggerModelProvider) {
            this.fooProvider = fooProvider;
            this.loggerModelProvider = loggerModelProvider;
        }

        @NotNull
        @Override
        public ListenableWorker create(@NotNull Context appContext, @NotNull WorkerParameters params) {
            return new UIUpdaterWorker(
                    appContext,
                    params,
                    loggerModelProvider.get(),
                    fooProvider.get()
            );
        }
    }
}
