package com.dao.practicedraw.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * FragmentPagerAdapter的公共适配器
 *
 * @author yangfei
 */
public class BaseFragmentAdapter extends FragmentPagerAdapter {

    private String[] mTitles = null;
    private List<Fragment> mFragments = null;

    public BaseFragmentAdapter(FragmentManager fm, @Nullable String[] mTitles,
                               List<Fragment> mFragments) {
        super(fm);
        this.mTitles = mTitles;
        this.mFragments = mFragments;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (null == mTitles) {
            return super.getPageTitle(position);
        } else {
            return mTitles[position];
        }
    }

    @Override
    public int getCount() {
        return mFragments.size() > 0 ? mFragments.size() : 0;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

}