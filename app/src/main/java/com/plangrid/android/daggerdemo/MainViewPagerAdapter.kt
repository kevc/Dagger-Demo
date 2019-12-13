package com.plangrid.android.daggerdemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.plangrid.android.randomint.RandomIntFragment
import com.plangrid.android.randomuuid.RandomUUIDFragment

class MainViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> RandomIntFragment.newInstance()
            1 -> RandomUUIDFragment.newInstance()
            else -> throw RuntimeException("NO!")
        }
    }

    override fun getCount(): Int = 2
}
