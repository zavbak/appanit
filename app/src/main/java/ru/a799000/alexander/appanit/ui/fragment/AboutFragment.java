package ru.a799000.alexander.appanit.ui.fragment;

import ru.a799000.alexander.appanit.R;

/**
 * Created by user on 19.11.2017.
 */

public class AboutFragment extends BaseFragment {

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_about;
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_about;
    }


}
