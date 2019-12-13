package com.plangrid.android.daggerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpager)
        viewPager.adapter = MainViewPagerAdapter(supportFragmentManager)

        tabLayout = findViewById(R.id.tab_layout)
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.getTabAt(0)?.text = "Integers"
        tabLayout.getTabAt(1)?.text = "UUIDs"
    }
}
