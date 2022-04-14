package com.example.genie_clone.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.genie_clone.R
import com.example.genie_clone.databinding.FragmentHomeBinding
import com.example.genie_clone.home.adapters.TabLayoutViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.romainpiel.shimmer.Shimmer
import com.romainpiel.shimmer.ShimmerTextView


class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewPagerAdapter: BannerListAdapter
    private lateinit var viewModel: FragmentHomeViewModel
    private var tv: ShimmerTextView? = null
    private var shimmer: Shimmer? = null



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(FragmentHomeViewModel::class.java)
        viewModel.setBannerItems(BannerItemList)
        tv = binding.shimmerTitleTextView



        binding.lottieViewDog.playAnimation()
        binding.lottieViewDog.loop(true)

        binding.lottieViewComputer.playAnimation()
        binding.lottieViewComputer.loop(true)

        binding.lottieViewBoy.playAnimation()
        binding.lottieViewBoy.loop(true)



        toggleAnimation()
        tabLayoutViewPage2()
        viewPage2side()
        initViewPager2()
        subscribeObservers()
        return binding.root
    }


    private fun initViewPager2() {
        binding.bannerViewPager2.apply {
            viewPagerAdapter = BannerListAdapter()
            adapter = viewPagerAdapter
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            })
        }
    }

    private fun subscribeObservers() {
        viewModel.bannerItemList.observe(viewLifecycleOwner) { bannerItemList ->
            viewPagerAdapter.submitList(bannerItemList)
        }

    }

    private fun viewPage2side() {
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

    }

    private fun tabLayoutViewPage2() {
        val adapter = TabLayoutViewPagerAdapter(this)
        binding.homeTabLayoutViewPager2.adapter = adapter

        val tabName = arrayOf("뮤직", "오디오", "TV", "DJ")


        TabLayoutMediator(binding.tabLayout, binding.homeTabLayoutViewPager2) { tab, position ->
            tab.text = tabName[position]
        }.attach()



        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.homeTabLayoutViewPager2.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })


    }

    private fun toggleAnimation() {
        if (shimmer?.isAnimating == true) {
            shimmer?.cancel()
        } else {
            shimmer = Shimmer()
            shimmer!!.start(tv)
        }
    }

}