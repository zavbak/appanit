package ru.a799000.alexander.appanit.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import ru.a799000.alexander.appanit.ui.fragment.BaseFragment;


/**
 * Created by Alex on 16.08.2017.
 */

public interface MainView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showFragmentFromDrawer(BaseFragment baseFragment);
}
