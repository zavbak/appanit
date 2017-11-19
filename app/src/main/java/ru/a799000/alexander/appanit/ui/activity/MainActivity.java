package ru.a799000.alexander.appanit.ui.activity;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;

import ru.a799000.alexander.appanit.MyApplication;
import ru.a799000.alexander.appanit.R;
import ru.a799000.alexander.appanit.mvp.presenter.MainPresenter;
import ru.a799000.alexander.appanit.mvp.view.MainView;
import ru.a799000.alexander.appanit.ui.fragment.AboutFragment;
import ru.a799000.alexander.appanit.ui.fragment.BaseFragment;


public class MainActivity extends BaseActivity implements MainView {

    @InjectPresenter
    MainPresenter mPresenter;

    private Drawer mDrawer;

    private AccountHeader mAccountHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
        init();

    }

    void init() {
        setUpDrawer();
        if (mPresenter.getCurentScreen() == 0) {
            mDrawer.setSelection(1); //start screen
        } else {
            mDrawer.setSelectionAtPosition(mPresenter.getCurentScreen(), false);
        }
    }

    public void setUpDrawer() {

        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.screen_name_about)
                .withIcon(GoogleMaterial.Icon.gmd_home);

        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName(R.string.screen_name_customer)
                .withIcon(GoogleMaterial.Icon.gmd_list);

        mAccountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .build();

        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withTranslucentStatusBar(true)
                .withActionBarDrawerToggle(true)
                .withAccountHeader(mAccountHeader)
                .addDrawerItems(item1, item2)
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    mPresenter.drawerItemClick((int) drawerItem.getIdentifier());
                    return false;
                })
                .build();
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void showFragmentFromDrawer(BaseFragment baseFragment) {
        setContent(baseFragment);
    }
}
