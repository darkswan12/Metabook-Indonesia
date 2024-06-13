package com.example.metabook.view.main.ui.detailbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.metabook.view.main.ui.detailbook.fragment.ReviewFragment
import com.example.metabook.view.main.ui.home.HomeFragment

class SectionPageAdapter (fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter (fragmentManager,lifecycle) {

    private val fragments = ArrayList<Fragment>()
    private val fragmentTitles = ArrayList<String>()

    fun addFragment(fragment: Fragment, title: String) {
        fragments.add(fragment)
        fragmentTitles.add(title)
    }

    override fun getItemCount(): Int {

        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {

        return fragments [position]
    }
    fun getPageTitle(position: Int): String = fragmentTitles[position]
}