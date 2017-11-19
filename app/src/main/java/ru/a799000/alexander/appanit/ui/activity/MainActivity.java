package ru.a799000.alexander.appanit.ui.activity;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;

import ru.a799000.alexander.appanit.MyApplication;
import ru.a799000.alexander.appanit.R;
import ru.a799000.alexander.appanit.mvp.presenter.MainPresenter;
import ru.a799000.alexander.appanit.mvp.view.MainView;


public class MainActivity extends BaseActivity implements MainView {

    @InjectPresenter
    MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.activity_main;
    }
}
