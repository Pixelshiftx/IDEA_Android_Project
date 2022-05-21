package com.example.uxsession;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class AboutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_about, container, false);

    }
    private ViewPager2 mViewPager;
    @Override

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewPager = view.findViewById(R.id.viewPager);
        mViewPager.setAdapter(new AboutAdapter(getActivity()));//Attach adapter

        TabLayout tabLayout = view.findViewById(R.id.tabMenu);
        new TabLayoutMediator(tabLayout, mViewPager,
                (tab, position) -> tab.setText(((AboutAdapter)(mViewPager.getAdapter())).mFragmentNames[position])
        ).attach();
    }
}
