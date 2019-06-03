package com.sample.daggerworkmanagersample;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.ListenableWorker;
import androidx.work.WorkerFactory;
import androidx.work.WorkerParameters;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Map;
import java.util.Objects;

public class SimpleWorkerFactory extends WorkerFactory {
    private final Map<Class<? extends ListenableWorker>, Provider<ChildWorkerFactory>> workerFactories;

    @Inject
    public SimpleWorkerFactory(Map<Class<? extends ListenableWorker>, Provider<ChildWorkerFactory>> workerFactories) {
        this.workerFactories = workerFactories;
    }

    @Nullable
    @Override
    public ListenableWorker createWorker(@NonNull Context appContext, @NonNull String workerClassName, @NonNull WorkerParameters workerParameters) {
        Provider<ChildWorkerFactory> factoryProvider =  getWorkerFactoryProviderByKey(workerFactories, workerClassName);
        return factoryProvider.get().create(appContext, workerParameters);
    }

    /**
     *
     * @param map
     * @param key
     * @return
     */
    public static Provider<ChildWorkerFactory> getWorkerFactoryProviderByKey(Map<Class<? extends ListenableWorker>, Provider<ChildWorkerFactory>> map, String key) { // todo универсальный нужен ли?
        for (Map.Entry<Class<? extends ListenableWorker>, Provider<ChildWorkerFactory>> entry : map.entrySet()) {
            if (Objects.equals(key, entry.getKey().getName())) {
                return entry.getValue();
            }
        }
        return null;
    }
}
