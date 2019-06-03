package com.sample.daggerworkmanagersample;


import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class, WorkerBindingModule.class})
public interface AppComponent {
    void inject(LoggerModelImpl loggerModel);
    SampleWorkerFactory factory();

}
