package com.ruhlanusubov.shopsphere.ui.splash

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ruhlanusubov.shopsphere.R
import com.ruhlanusubov.shopsphere.databinding.FragmentSplashBinding
import com.ruhlanusubov.shopsphere.utils.SpService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : Fragment() {
    private var _binding:FragmentSplashBinding?=null
    private val binding get() = _binding!!
    private lateinit var sp:SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding= FragmentSplashBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup(){
        lifecycleScope.launch {
            delay(4000L)
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToIntroFragment())
        }
        checkUser()
    }
    private fun checkUser(){
      sp=SpService.preference(requireContext())
        val token=sp.getString("UserId","")
        if(!token.isNullOrEmpty()){
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}