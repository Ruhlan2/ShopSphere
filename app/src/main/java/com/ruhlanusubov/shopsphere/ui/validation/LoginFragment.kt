package com.ruhlanusubov.shopsphere.ui.validation

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.ruhlanusubov.shopsphere.R
import com.ruhlanusubov.shopsphere.databinding.FragmentLoginBinding
import com.ruhlanusubov.shopsphere.utils.SpService
import com.shashank.sony.fancytoastlib.FancyToast

class LoginFragment : Fragment() {

    private var _binding:FragmentLoginBinding?=null
    private val binding get() = _binding!!
    private val auth=FirebaseAuth.getInstance()
    private lateinit var sp:SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setup()
    }


    private fun setup(){
        with(binding){
            loginBtn.setOnClickListener {
                signIn()
            }
            signUp.setOnClickListener {
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
            }
            forgot.setOnClickListener {

            }
            google.setOnClickListener {

            }
            facebook.setOnClickListener {

            }
        }
    }
    private fun signIn(){
        with(binding){
            val email=email.text.toString()
            val password=password.text.toString()

            if (email.isEmpty()||password.isEmpty()){
                FancyToast.makeText(requireContext(),"Successfully signed in",
                    FancyToast.LENGTH_SHORT,
                    FancyToast.WARNING,false).show()

                return@with

            }
            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                FancyToast.makeText(requireContext(),"Successfully signed in",
                    FancyToast.LENGTH_SHORT,
                    FancyToast.WARNING,false).show()
                sp=SpService.preference(requireContext())
                sp.edit().putString("UserId",it.user?.uid).apply()

                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
            }.addOnFailureListener {

            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}