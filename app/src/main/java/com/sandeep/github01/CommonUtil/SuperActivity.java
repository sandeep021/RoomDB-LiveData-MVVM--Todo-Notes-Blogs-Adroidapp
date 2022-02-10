package com.sandeep.github01.CommonUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.sandeep.github01.R;
import com.sandeep.github01.activity.MainActivity;

public class SuperActivity extends AppCompatActivity {

    public void gotoActivity(Class activityClass, Bundle bundle) {
        try {
            Intent intent = new Intent(this, activityClass);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

    }

    public void gotoActivityWithoutFinish(Class activityClass, Bundle bundle) {
        try {
            Intent intent = new Intent(this, activityClass);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            startActivity(intent);
            overridePendingTransition(0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void  gotoFragment(Fragment fragment, Bundle bundle, String backStackTag, Context activity) {
        try {
            if (bundle != null) {
                fragment.setArguments(bundle);
            }

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(0, 0);
            if (activity instanceof MainActivity) {
                fragmentTransaction.replace(R.id.frame_main, fragment);
            }

            if (CommonUtil.isValidString(backStackTag)) {
                fragmentTransaction.addToBackStack(backStackTag);
            }
            fragmentTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void  gotoFragmentByAdding(Fragment fragment, Bundle bundle, String backStackTag, Context activity) {
        try {
            if (bundle != null) {
                fragment.setArguments(bundle);
            }

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(0, 0);
            if (activity instanceof MainActivity) {
                fragmentTransaction.add(R.id.frame_main, fragment);
            }
            if (CommonUtil.isValidString(backStackTag)) {
                fragmentTransaction.addToBackStack(backStackTag);
            }
            fragmentTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
