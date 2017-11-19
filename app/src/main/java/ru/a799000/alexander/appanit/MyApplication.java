package ru.a799000.alexander.appanit;

import android.app.Application;

import ru.a799000.alexander.appanit.di.component.ApplicationComponent;
import ru.a799000.alexander.appanit.di.component.DaggerApplicationComponent;
import ru.a799000.alexander.appanit.di.module.ApplicationModule;


/**
 * Created by Alex on 16.08.2017.
 */

public class MyApplication extends Application{

    private static ApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initComponent();



    }

    private void initComponent(){
        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }
}
