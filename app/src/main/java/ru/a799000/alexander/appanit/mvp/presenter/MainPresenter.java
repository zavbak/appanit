package ru.a799000.alexander.appanit.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import ru.a799000.alexander.appanit.MyApplication;
import ru.a799000.alexander.appanit.common.MyFragmentManager;
import ru.a799000.alexander.appanit.mvp.view.MainView;
import ru.a799000.alexander.appanit.ui.fragment.AboutFragment;
import ru.a799000.alexander.appanit.ui.fragment.BaseFragment;
import ru.a799000.alexander.appanit.ui.fragment.CustomersFragment;


@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private int curentScreen = 0;


    @Inject
    MyFragmentManager myFragmentManager;

    public MainPresenter() {
        MyApplication.getApplicationComponent().inject(this);
    }

    public int getCurentScreen() {
        return curentScreen;
    }


    public void drawerItemClick(int id) {
        BaseFragment fragment = null;

        switch (id) {
            case 1:
                fragment = new AboutFragment();
                curentScreen = 1;
                break;
            case 2:
                fragment = new CustomersFragment();
                curentScreen = 2;
                break;
        }

        if (fragment != null && !myFragmentManager.isAlreadyContains(fragment)) {
            getViewState().showFragmentFromDrawer(fragment);
        }
    }
}
