package com.kubra.koubitirme.design.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kubra.koubitirme.R
import com.kubra.koubitirme.common.ViewPagerAdapter
import com.kubra.koubitirme.design.main.list.AnimalImageFragment
import com.kubra.koubitirme.design.main.select.AnimalSelectFragment
import kotlinx.android.synthetic.main.activity_image_list.*

class ImageList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_list)
        setupUI()
    }


    private fun setupUI() {
        setSupportActionBar(list_toolbar)
        setupViewPager()
        list_tabLayout.setupWithViewPager(list_viewPager)
    }

    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.apply {
            addFragment(AnimalImageFragment(),"Animal")
            addFragment(AnimalSelectFragment(),"Select")
        }
        list_viewPager.adapter = adapter
        list_viewPager.offscreenPageLimit = 3


    }

}
