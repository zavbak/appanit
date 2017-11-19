package ru.a799000.alexander.appanit.ui.activity;

import ru.a799000.alexander.appanit.R;
import ru.a799000.alexander.appanit.ui.fragment.BaseFragment;

/**
 * Created by user on 19.11.2017.
 */

public class CustomerFragment extends BaseFragment {

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_about;
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_customer;
    }


}
