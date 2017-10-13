package com.lq.ren.keepfit.find;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lq.ren.base.ui.BaseFragment;
import com.lq.ren.base.ui.BaseView;
import com.lq.ren.base.ui.BaseViewModel;
import com.lq.ren.keepfit.R;
import com.lq.ren.keepfit.model.FriendModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author lqren on 17/10/9.
 */

public class FriendFragment extends BaseFragment implements BaseView<FriendModel> {

    private View rootView;
    private int[] friendTexts = new int[]{R.id.friend_refer, R.id.friend_active, R.id.friend_event};

    @BindView(R.id.friend_viewpager)
    ViewPager friendPager;

    @NonNull
    @Override
    protected BaseViewModel createViewModel() {
        return new FriendModel();
    }

    @NonNull
    @Override
    protected BaseView createView() {
        return this;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_friend, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        rootView = view;
        friendPager.setAdapter(new FriendAdapter(getChildFragmentManager()));

        setSelectedTextColor(R.id.friend_refer, true);
    }


    @Override
    public void setViewModel(FriendModel viewModel) {
        if (viewModel == null) {
            return;
        }
    }

    private View.OnClickListener friendListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            setSelectedTextColor(view.getId(), false);
        }
    };

    private void setSelectedTextColor(int selectedTextId, boolean init) {
        for (int i = 0; i < friendTexts.length; i++) {
            TextView textView = rootView.findViewById(friendTexts[i]);
            if (init) {
                textView.setOnClickListener(friendListener);
            }

            if (friendTexts[i] == selectedTextId) {
                friendPager.setCurrentItem(i);
                textView.setTextColor(getResources().getColor(R.color.fit_selected_color));
            } else {
                textView.setTextColor(getResources().getColor(R.color.fit_unselected_color));
            }
        }
    }


    private static class FriendAdapter extends FragmentPagerAdapter {

        private final Fragment[] fragments;

        private FriendAdapter(FragmentManager fm) {
            super(fm);
            fragments = new Fragment[]{
                    new ReferFragment(),
                    new ActiveFragment(),
                    new EventFragment(),
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
