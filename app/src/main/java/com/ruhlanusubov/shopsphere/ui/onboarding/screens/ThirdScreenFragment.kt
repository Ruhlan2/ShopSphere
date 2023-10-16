package com.ruhlanusubov.shopsphere.ui.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ruhlanusubov.shopsphere.R
import com.ruhlanusubov.shopsphere.databinding.FragmentSecondScreenBinding
import com.ruhlanusubov.shopsphere.databinding.FragmentThirdScreenBinding

class ThirdScreenFragment : Fragment() {
    private var _binding: FragmentThirdScreenBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentThirdScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup(){

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}