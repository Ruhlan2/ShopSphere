package com.ruhlanusubov.shopsphere.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.ruhlanusubov.shopsphere.R
import com.ruhlanusubov.shopsphere.databinding.ActivityMainBinding
import com.ruhlanusubov.shopsphere.ui.validation.LoginFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setup()
    }

    private fun setup(){
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController=navHostFragment.navController

        NavigationUI.setupWithNavController(binding.bottomNavigationView,navController)

        navController.addOnDestinationChangedListener{_,destination,_->

            when(destination.id){

                     R.id.loginFragment,
                     R.id.introFragment,
                     R.id.splashFragment,
                     R.id.registerFragment->{
                        binding.bottomNavigationView.visibility= View.GONE
                    }else->{
                        if(binding.bottomNavigationView.visibility==View.GONE){
                            binding.bottomNavigationView.visibility=View.VISIBLE
                        }
                    }

            }

        }
    }
}