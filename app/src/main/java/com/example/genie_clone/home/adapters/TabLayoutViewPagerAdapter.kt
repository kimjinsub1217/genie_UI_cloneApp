package com.example.genie_clone.home.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.genie_clone.home.fragments.FragmentHomeMusic
import com.example.genie_clone.home.fragments.FragmentHomeDj
import com.example.genie_clone.home.fragments.FragmentHomeAudio
import com.example.genie_clone.home.fragments.FrgmentHomeTv

private const val NUM_PAGES = 4

class TabLayoutViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = NUM_PAGES


    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentHomeMusic()
            1 -> FragmentHomeAudio()
            2 -> FrgmentHomeTv()
            3 -> FragmentHomeDj()
            else -> FragmentHomeMusic()
        }
    }
}
