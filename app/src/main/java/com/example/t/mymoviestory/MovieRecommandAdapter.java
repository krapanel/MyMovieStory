package com.example.t.mymoviestory;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by dongja94 on 2015-10-14.
 */
public class MovieRecommandAdapter extends FragmentPagerAdapter {
    public MovieRecommandAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return MovieRecommandFragment.newInstance("Item : " + position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Title " + position;
    }
}
