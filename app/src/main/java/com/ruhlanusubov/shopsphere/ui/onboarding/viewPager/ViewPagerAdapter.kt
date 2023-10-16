package com.ruhlanusubov.shopsphere.ui.onboarding.viewPager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ruhlanusubov.shopsphere.ui.onboarding.screens.FirstScreenFragment
import com.ruhlanusubov.shopsphere.ui.onboarding.screens.SecondScreenFragment
import com.ruhlanusubov.shopsphere.ui.onboarding.screens.ThirdScreenFragment

class ViewPagerAdapter(
                        list: ArrayList<Fragment>,
                        fm:FragmentManager,
                        lifecycle: Lifecycle)
                        :FragmentStateAdapter(fm,lifecycle) {

    private val fragmentList = list
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
      // return fragmentList[position]

        return when(position){
                    0->{
                        FirstScreenFragment()
                    }
                    1->{
                        SecondScreenFragment()
                    }
                    2->{
                        ThirdScreenFragment()
                    }

            else -> {
                FirstScreenFragment()
            }
        }
    }

}


