package com.sample.daggerworkmanagersample;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public interface WorkingBindingModule {
    @Binds
    @IntoMap
    @WorkingKey(UIUpdaterWorker.class)
    ChildWorkerFactory bindUIUpdaterWorker(UIUpdaterWorker.Factory factory);
}
