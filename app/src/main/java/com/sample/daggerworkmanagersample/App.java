package com.sample.daggerworkmanagersample;

import android.app.Application;
import androidx.work.Configuration;
import androidx.work.WorkManager;

public class App extends Application {
    private static AppComponent appComponent;

    public static AppComponent getAppcomponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = buildComponent();
//        SampleWorkerFactory factory = appComponent.factory();
        SimpleWorkerFactory factory = appComponent.factory();
        Configuration config = new Configuration.Builder()
                .setWorkerFactory(factory)
                .build();

        WorkManager.initialize(this, config);
    }

    private AppComponent buildComponent() {
        return DaggerAppComponent.builder().appModule(new AppModule()).build();
    }
}
