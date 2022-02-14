package com.sandeep.github01.activity;

import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.sandeep.github01.CommonUtil.SuperActivity;
import com.sandeep.github01.fragments.HomeFragment;
import com.sandeep.github01.R;
import com.sandeep.github01.databinding.ActivityMainBinding;
import com.sandeep.github01.fragments.NewsFragment;
import com.sandeep.github01.fragments.NotesFragment;
import com.sandeep.github01.fragments.ProfileFragment;
import com.sandeep.github01.fragments.TodoFragment;

public class MainActivity extends SuperActivity {
    ActivityMainBinding activityMainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setBottomNavigation();
        gotoFragment(new HomeFragment(), null, null, MainActivity.this);
    }

    private void setBottomNavigation() {
        activityMainBinding.navigation.setItemIconTintList(null);
        activityMainBinding.navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_todo:
                    if (!(getSupportFragmentManager().findFragmentById(R.id.frame_main) instanceof TodoFragment)) {
                        gotoFragment(new TodoFragment(), null, null, MainActivity.this);
                    }
                    return true;
                case R.id.navigation_notes:
                    if (!(getSupportFragmentManager().findFragmentById(R.id.frame_main) instanceof NotesFragment)) {
                        gotoFragment(new NotesFragment(), null, null, MainActivity.this);
                    }
                    return true;
                case R.id.navigation_news:
                    if (!(getSupportFragmentManager().findFragmentById(R.id.frame_main) instanceof NewsFragment)) {
                        gotoFragment(new NewsFragment(), null, null, MainActivity.this);
                    }
                    return true;
                case R.id.navigation_profile:
                    if (!(getSupportFragmentManager().findFragmentById(R.id.frame_main) instanceof ProfileFragment)) {
                        gotoFragment(new ProfileFragment(), null, null, MainActivity.this);
                    }
                    return true;
                case R.id.navigation_home:
                default:
                    if (!(getSupportFragmentManager().findFragmentById(R.id.frame_main) instanceof HomeFragment)) {
                        gotoFragment(new HomeFragment(), null, null, MainActivity.this);
                    }
                    return true;
            }
        });
    }
}