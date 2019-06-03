package com.sample.daggerworkmanagersample;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class AppModule {

    @Provides
    @Singleton
    LoggerModel provideLoggerImplementation() {return new LoggerModelImpl();}
}
