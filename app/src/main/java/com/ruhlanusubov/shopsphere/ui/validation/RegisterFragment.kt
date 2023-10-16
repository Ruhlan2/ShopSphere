package com.ruhlanusubov.shopsphere.ui.validation

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.ruhlanusubov.shopsphere.R
import com.ruhlanusubov.shopsphere.databinding.FragmentRegisterBinding
import com.ruhlanusubov.shopsphere.utils.SpService
import com.shashank.sony.fancytoastlib.FancyToast

class RegisterFragment : Fragment() {
   private var _binding:FragmentRegisterBinding?=null
   private val binding get() = _binding!!
   private val auth=FirebaseAuth.getInstance()
   private lateinit var sp:SharedPreferences

   override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
   ): View? {
      _binding= FragmentRegisterBinding.inflate(inflater,container,false)
      return binding.root
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      super.onViewCreated(view, savedInstanceState)

      setup()
   }

   private fun setup(){
      with(binding){
         signUpBtn.setOnClickListener {
            create()
         }
         googleBtn.setOnClickListener {

         }
         facebookBtn.setOnClickListener {

         }
         login.setOnClickListener {
            findNavController().popBackStack()
         }
      }
   }

   private fun create(){
      with(binding){
         val name=name.text.toString()
         val email=email.text.toString()
         val password=password.text.toString()
         val confirm=confirm.text.toString()

         if(name.isEmpty()||email.isEmpty()||password.isEmpty()||confirm.isEmpty()){
            FancyToast.makeText(requireContext(),"Please fill the blanks",FancyToast.LENGTH_SHORT,FancyToast.WARNING,false).show()
            return@with
         }
         auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
            FancyToast.makeText(requireContext(),"User Created",FancyToast.LENGTH_SHORT,FancyToast.SUCCESS,false).show()
            sp=SpService.preference(requireContext())
            sp.edit().putString("UserId",it.user?.uid).apply()
            findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToHomeFragment())
         }.addOnFailureListener {
            FancyToast.makeText(requireContext(),it.localizedMessage,FancyToast.LENGTH_SHORT,FancyToast.ERROR,false).show()
         }
      }
   }
   override fun onDestroy() {
      super.onDestroy()
      _binding=null
   }
}