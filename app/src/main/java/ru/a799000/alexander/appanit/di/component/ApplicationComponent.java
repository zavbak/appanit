package ru.a799000.alexander.appanit.di.component;

import javax.inject.Singleton;

import dagger.Component;
import ru.a799000.alexander.appanit.di.module.ApplicationModule;
import ru.a799000.alexander.appanit.di.module.ManagerModule;
import ru.a799000.alexander.appanit.mvp.presenter.MainPresenter;
import ru.a799000.alexander.appanit.ui.activity.BaseActivity;
import ru.a799000.alexander.appanit.ui.activity.MainActivity;

/**
 * Created by Alex on 18.08.2017.
 */

@Singleton
@Component(modules = {ApplicationModule.class, ManagerModule.class})
public interface ApplicationComponent {

    //activitie
    void inject(BaseActivity activity);

    void inject(MainActivity activity);

    void inject(MainPresenter presenter);

}
