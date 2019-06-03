package com.sample.daggerworkmanagersample;

import androidx.work.ListenableWorker;
import dagger.MapKey;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MapKey
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WorkingKey {
    Class<? extends ListenableWorker> value();
}
