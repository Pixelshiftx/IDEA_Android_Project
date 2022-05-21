package com.example.uxsession;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AboutAdapter extends FragmentStateAdapter {

    private final Fragment[] mFragments = new Fragment[] {
            //initialize the fragments
            new AboutUs(),//First fragment to be displayed
            new SocialMedia(),
    };
    public final String[] mFragmentNames = new String[] {
            //tab title
            "About Us",
            "Social Media"
    };

    public AboutAdapter(FragmentActivity fragmentActivity){
        super(fragmentActivity);
    }

    @Override
    public int getItemCount() {
        return mFragments.length;//Number of fragments displayed
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragments[position];
    }
}
