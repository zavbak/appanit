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


public class MainActivity extends BaseActivity implements MainView {



    @InjectPresenter
    MainPresenter mPresenter;

    private Drawer mDrawer;

    private AccountHeader mAccountHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
        setUpDrawer();
        //mDrawer.setSelection(mDrawer.getCurrentSelectedPosition());
    }


    public void setUpDrawer() {

        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.screen_name_news)
                .withIcon(GoogleMaterial.Icon.gmd_home);

        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName(R.string.screen_name_my_posts)
                .withIcon(GoogleMaterial.Icon.gmd_list);

        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName(R.string.screen_name_settings)
                .withIcon(GoogleMaterial.Icon.gmd_settings);

        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName(R.string.screen_name_members)
                .withIcon(GoogleMaterial.Icon.gmd_people);

        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(5).withName(R.string.screen_name_topics)
                .withIcon(GoogleMaterial.Icon.gmd_record_voice_over);

        PrimaryDrawerItem item6 = new PrimaryDrawerItem().withIdentifier(6).withName(R.string.screen_name_info)
                .withIcon(GoogleMaterial.Icon.gmd_info);

        PrimaryDrawerItem item7 = new PrimaryDrawerItem().withIdentifier(7).withName(R.string.screen_name_rules)
                .withIcon(GoogleMaterial.Icon.gmd_assignment);

        mAccountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .build();

        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withTranslucentStatusBar(true)
                .withActionBarDrawerToggle(true)
                .withAccountHeader(mAccountHeader)
                .addDrawerItems(item1, item2, item3,
                        new SectionDrawerItem().withName("Группа"),
                        item4, item5, item6, item7)

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
}
