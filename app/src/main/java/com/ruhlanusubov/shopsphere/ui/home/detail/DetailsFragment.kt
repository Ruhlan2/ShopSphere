package com.ruhlanusubov.shopsphere.ui.home.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.denzcoskun.imageslider.models.SlideModel
import com.ruhlanusubov.shopsphere.R
import com.ruhlanusubov.shopsphere.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private var _binding:FragmentDetailsBinding?=null
    private val binding get() = _binding!!
    private val args by navArgs<DetailsFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }
    private fun setup(){
        with(binding){
            val productData=args.data
            var number = 1
                with(productData){
                    productTitle.text=brand
                    appCompatRatingBar.rating=rating!!.toFloat()
                    ratingNumber.text="($rating)"
                    productBrand.text=title
                    productPrice.text="$${price}"
                    productDesc.text=description

                    increase.setOnClickListener {
                        number++
                        count.text = number.toString()
                        productPrice.text="$${number* price!!}"
                    }
                    decrease.setOnClickListener {
                        if (number > 1) {
                            number--
                            count.text = number.toString()
                            productPrice.text = "$${number * price!!}"

                        } else {
                            decrease.isEnabled = false
                        }
                    }

                }

                val imageList=ArrayList<SlideModel>()
                productData.images?.forEach {
                    imageList.add(SlideModel(it))
                }
                slider.setImageList(imageList)


        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}