package ru.a799000.alexander.appanit.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.a799000.alexander.appanit.MyApplication;
import ru.a799000.alexander.appanit.R;
import ru.a799000.alexander.appanit.common.MyFragmentManager;
import ru.a799000.alexander.appanit.ui.fragment.BaseFragment;


/**
 * Created by Alex on 16.08.2017.
 */

public abstract class BaseActivity extends MvpAppCompatActivity {

   @Inject
   MyFragmentManager myFragmentManager;

   @BindView(R.id.toolbar)
   Toolbar toolbar;

   @BindView(R.id.progress)
   protected ProgressBar mProgressBar;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      setContentView(R.layout.activity_base);
      ButterKnife.bind(this);

      MyApplication.getApplicationComponent().inject(this);

      setSupportActionBar(toolbar);

      FrameLayout parent = (FrameLayout) findViewById(R.id.main_wrapper);
      getLayoutInflater().inflate(getMainContentLayout(), parent);
   }


   @LayoutRes
   protected abstract int getMainContentLayout();


   public void fragmentOnScreen(BaseFragment baseFragment) {
      setToolbarTitle(baseFragment.createToolbarTitle(this));
   }


   private void setToolbarTitle(String title) {
      if (getSupportActionBar() != null) {
         getSupportActionBar().setTitle(title);
      }
   }


   public void setContent(BaseFragment fragment) {
      myFragmentManager.setFragment(this, fragment, R.id.main_wrapper);
   }

   public void addContent(BaseFragment fragment) {
      myFragmentManager.addFragment(this, fragment, R.id.main_wrapper);
   }

   public boolean removeCurrentFragment() {
      return myFragmentManager.removeCurrentFragment(this);
   }

   public boolean removeFragment(BaseFragment fragment) {
      return myFragmentManager.removeFragment(this, fragment);
   }

   public ProgressBar getProgressBar() {
      return mProgressBar;
   }

   @Override
   public void onBackPressed() {
      removeCurrentFragment();
   }

}
