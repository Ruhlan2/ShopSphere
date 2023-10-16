package com.ruhlanusubov.shopsphere.ui.onboarding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ruhlanusubov.shopsphere.databinding.FragmentIntroBinding
import com.ruhlanusubov.shopsphere.ui.onboarding.screens.FirstScreenFragment
import com.ruhlanusubov.shopsphere.ui.onboarding.screens.SecondScreenFragment
import com.ruhlanusubov.shopsphere.ui.onboarding.screens.ThirdScreenFragment
import com.ruhlanusubov.shopsphere.ui.onboarding.viewPager.ViewPagerAdapter
import kotlin.properties.Delegates

class IntroFragment : Fragment() {
    private var _binding:FragmentIntroBinding?=null
    private val binding get() = _binding!!
    private lateinit var fragmentList:ArrayList<Fragment>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentIntroBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        onBoarding()
    }

    private fun setup(){

            fragmentList= arrayListOf(
            FirstScreenFragment(),
            SecondScreenFragment(),
            ThirdScreenFragment()
        )
        val adapter= ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter=adapter

        binding.dotsIndicator.attachTo(binding.viewPager)
    }

    private fun onBoarding(){
        with(binding){
            skipBtn.setOnClickListener {
                findNavController().navigate(IntroFragmentDirections.actionIntroFragmentToLoginFragment())
            }
            nextBtn.setOnClickListener {
                viewPager.currentItem++

                Log.d("size",fragmentList.lastIndex.toString())
                if(viewPager.currentItem==fragmentList.lastIndex){
                    skipBtn.visibility=View.INVISIBLE
                    skipText.visibility=View.INVISIBLE
                    nextBtn.text="Get Started"
                    nextBtn.setOnClickListener {
                        findNavController().navigate(IntroFragmentDirections.actionIntroFragmentToLoginFragment())
                    }
                }
            }

        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}