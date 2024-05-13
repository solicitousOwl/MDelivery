package com.example.fooddelivery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fooddelivery.databinding.ActivityDetails2Binding
import com.example.fooddelivery.databinding.ActivityDetailsBinding
import com.example.fooddelivery.fragments.SuccessPaymentFragment


class Details : AppCompatActivity() {

    private lateinit var binding: ActivityDetails2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetails2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backStack.setOnClickListener {
            onBackPressed()
        }

        binding.placeMyOrder.setOnClickListener {
            val bottomFragment = SuccessPaymentFragment()
            bottomFragment.show(supportFragmentManager, "Test")
        }

        val totalPrice = intent.getStringExtra("totalPrice")
        binding.price.text = totalPrice
    }
}