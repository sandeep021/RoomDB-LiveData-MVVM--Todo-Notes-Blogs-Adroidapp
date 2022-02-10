package com.sandeep.github01.CommonUtil;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.sandeep.github01.R;
import com.sandeep.github01.retrofit.CallBackInterface;

public class SuperFragment extends Fragment implements CallBackInterface {
    private static final String TAG = SuperFragment.class.getCanonicalName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void goToFragment(Fragment childFragment, Bundle bundle, String backStackTag, Fragment parentFragment) {
        try {
            if(getActivity() == null)
                return;
            if (bundle != null) {
                childFragment.setArguments(bundle);
            }
            FragmentTransaction fragmentTransaction =  getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(0, 0);
            fragmentTransaction.replace(R.id.frame_main,parentFragment);
            if (CommonUtil.isValidString(backStackTag)) {
                fragmentTransaction.addToBackStack(backStackTag);
            }
            fragmentTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
        }
    }

    @Override
    public void onSuccessResponse(Object o, String tag) {}

    @Override
    public void onErrorResponse(Object o, String key) {}


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
