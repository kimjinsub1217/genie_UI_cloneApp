package com.example.genie_clone.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.genie_clone.*
import com.example.genie_clone.databinding.FragmentHomeBinding

class HomeFragment:Fragment(R.layout.fragment_home) {
    private var _binding : FragmentHomeBinding? =null
    private val binding get() = _binding!!
    private lateinit var viewPagerAdapter: BannerListAdapter
    private lateinit var viewModel: FragmentHomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(FragmentHomeViewModel::class.java)
        viewModel.setBannerItems(BannerItemList)

        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin)
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pageWidth)
        val screenWidth = resources.displayMetrics.widthPixels
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        binding.bannerViewPager2.setPageTransformer { page, position ->
            page.translationX = position * -offsetPx
        }

        binding.bannerViewPager2.offscreenPageLimit = 1
        binding.bannerViewPager2.adapter = BannerListAdapter()
        binding.bannerViewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        initViewPager2()
        subscribeObservers()

        return binding.root
    }


    private fun initViewPager2() {
        binding.bannerViewPager2.apply {
            viewPagerAdapter = BannerListAdapter()
            adapter = viewPagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }

    }

    private fun subscribeObservers() {
        viewModel.bannerItemList.observe(viewLifecycleOwner, Observer { bannerItemList ->
            viewPagerAdapter.submitList(bannerItemList)
        })

    }



}