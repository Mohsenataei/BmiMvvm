package com.mohsen.caculatebmi_mvvm.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.mohsen.caculatebmi_mvvm.R
import com.mohsen.caculatebmi_mvvm.ui.home.HomeActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        splashImageView.animation = AnimationUtils.loadAnimation(this, R.anim.slide_from_left_to_right)
        splashTextView.animation = AnimationUtils.loadAnimation(this, R.anim.slide_from_right_to_left)

        splashButton.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }

    }
}
