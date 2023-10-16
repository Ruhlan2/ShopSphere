package com.ruhlanusubov.shopsphere.ui.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruhlanusubov.shopsphere.databinding.FragmentFirstScreenBinding
import com.ruhlanusubov.shopsphere.ui.onboarding.IntroFragment
import com.ruhlanusubov.shopsphere.ui.onboarding.viewPager.ViewPagerAdapter

class FirstScreenFragment : Fragment() {
    private var _binding: FragmentFirstScreenBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentFirstScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}