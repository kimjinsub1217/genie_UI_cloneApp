package com.example.genie_clone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.genie_clone.forYou.ForYouFragment
import com.example.genie_clone.home.HomeFragment
import com.example.genie_clone.home.adapters.TabLayoutViewPagerAdapter
import com.example.genie_clone.menu.MenuFragment
import com.example.genie_clone.myMusic.MyMusicFragment
import com.example.genie_clone.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        setTheme(R.style.Theme_Genie_clone)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val foryou = ForYouFragment()
        val search = SearchFragment()
        val mymusic = MyMusicFragment()
        val menu = MenuFragment()
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        replaceFragment(homeFragment)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(homeFragment)
                R.id.forYou -> replaceFragment(foryou)
                R.id.search -> replaceFragment(search)
                R.id.myMusic -> replaceFragment(mymusic)
                R.id.menu -> replaceFragment(menu)
            }
            true
        }
    }

    //bottomNavigationView한테 호출 되었을 시 FrameLayout에 붙이는 함수
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .apply {
                replace(R.id.fragmentContainer, fragment)
                commit()
            }
    }
}