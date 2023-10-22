package com.ruhlanusubov.shopsphere.ui.validation

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.ruhlanusubov.shopsphere.R
import com.ruhlanusubov.shopsphere.databinding.FragmentForgetBinding
import com.ruhlanusubov.shopsphere.utils.SpService
import com.shashank.sony.fancytoastlib.FancyToast

class ForgetFragment : Fragment() {

    private var _binding:FragmentForgetBinding?=null
    private val binding get() =_binding!!
    private val auth=FirebaseAuth.getInstance()
    private lateinit var sp:SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentForgetBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }
    private fun getEmail():String{
        sp=SpService.preference(requireContext())
        val email=sp.getString("email","")
        return email!!
    }

    private fun setup(){

        with(binding){
            val mail=getEmail()
            emailText.text=mail
            continueBtn.setOnClickListener {
                auth.sendPasswordResetEmail(mail)
                findNavController().popBackStack()
                    FancyToast.makeText(requireContext(),"Link was sent your email address.Please check your email",
                    FancyToast.LENGTH_LONG,FancyToast.SUCCESS,
                        false).show()
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}