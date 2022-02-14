package com.example.module5task1java;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class CustomPagerAdapter extends FragmentPagerAdapter {

    public CustomPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new Page1();
            case 1:
                return new Page2();
            default:
                return new Page3();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
