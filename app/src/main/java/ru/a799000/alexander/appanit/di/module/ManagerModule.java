package ru.a799000.alexander.appanit.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.a799000.alexander.appanit.common.MyFragmentManager;


/**
 * Created by Alex on 18.08.2017.
 */

@Module
public class ManagerModule {

    @Singleton
    @Provides
    MyFragmentManager provideMyFragmentManager(){
        return new MyFragmentManager();
    }
}
