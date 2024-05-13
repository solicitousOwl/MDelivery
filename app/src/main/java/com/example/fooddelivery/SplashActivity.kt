package com.example.fooddelivery

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Handler класс который используем для выполнения задач в основном потоке (UI потоке)
        // с помощью postDelayed код выполнится через определенное время
        Handler().postDelayed({
            // преход с splashActivity на StartActivity
          val intent = Intent(this@SplashActivity, StartActivity ::class.java)
            startActivity(intent)
            finish()
        }, 2000)
    }
}