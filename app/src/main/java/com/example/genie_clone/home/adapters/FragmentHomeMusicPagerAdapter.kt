package com.example.genie_clone.home.adapters

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.genie_clone.home.fragments.fragmentMusic.FragmentHomeMusicAll
import com.example.genie_clone.home.fragments.fragmentMusic.FragmentHomeMusicKorea
import com.example.genie_clone.home.fragments.fragmentMusic.FragmentHomeMusicLike
import com.example.genie_clone.home.fragments.fragmentMusic.FragmentHomeMusicOverseas

private const val NUM_PAGES = 4
class FragmentHomeMusicPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentHomeMusicAll()
            1 -> FragmentHomeMusicKorea()
            2 -> FragmentHomeMusicOverseas()
            3 -> FragmentHomeMusicLike()
            else -> FragmentHomeMusicAll()
        }
    }
}
