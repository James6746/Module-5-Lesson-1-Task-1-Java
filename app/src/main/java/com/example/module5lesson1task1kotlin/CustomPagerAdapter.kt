package com.example.module5lesson1task1kotlin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CustomPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> Page1()
            1 -> Page2()
            else -> Page3()
        }
    }

    override fun getCount(): Int {
        return 3
    }
}
