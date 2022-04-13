package com.example.genie_clone.home.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.genie_clone.databinding.FragmentHomeMusicBinding
import com.example.genie_clone.home.adapters.FragmentHomeMusicPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class FragmentHomeMusic : Fragment() {
    private var _binding: FragmentHomeMusicBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeMusicBinding.inflate(inflater, container, false)






        tabLayoutViewPage2()
        return binding.root
    }

    private fun tabLayoutViewPage2() {
        val adapter = FragmentHomeMusicPagerAdapter(this)
        binding.musicTabLayoutViewPager2.adapter = adapter

        val tabName = arrayOf<String>("전체", "국내", "해외", "좋아요")

        TabLayoutMediator(
            binding.todayMusicListTabLayout,
            binding.musicTabLayoutViewPager2
        ) { tab, position ->
            tab.text = tabName[position].toString()
        }.attach()

        binding.todayMusicListTabLayout.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.musicTabLayoutViewPager2.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }


}