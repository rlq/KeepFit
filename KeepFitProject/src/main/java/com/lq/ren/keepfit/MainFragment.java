package com.lq.ren.keepfit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lq.ren.keepfit.find.FriendFragment;
import com.lq.ren.keepfit.motion.FitnessFragment;
import com.lq.ren.keepfit.read.SubsFragment;
import com.lq.ren.keepfit.shop.AssetsFragment;
import com.lq.ren.keepfit.utils.IndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author lqren on 17/10/9.
 */

public class MainFragment extends Fragment {

    @BindView(R.id.main_viewpager)
    ViewPager mainViewPager;

    @BindView(R.id.main_indicator)
    IndicatorView mainIndicator;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        mainViewPager.setAdapter(new MainAdapter(getChildFragmentManager()));
        mainViewPager.setCurrentItem(0);
        mainIndicator.setIndicatorView();
        mainIndicator.setOnIndicatorClick(new IndicatorView.IndicatorClickListener() {
            @Override
            public void onIndicatorClick(int pageIndex) {
                mainViewPager.setCurrentItem(pageIndex);
            }
        });
    }


    private static class MainAdapter extends FragmentPagerAdapter {

        private final Fragment[] fragments;

        private MainAdapter(FragmentManager fm) {
            super(fm);
            fragments = new Fragment[]{
                    new FitnessFragment(),
                    new FriendFragment(),
                    new SubsFragment(),
                    new AssetsFragment()
            };
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }
    }
}
