package com.sevgiaykir.e_commerceandroidapp

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.sevgiaykir.e_commerceandroidapp.databinding.ActivitySplashScreenBinding
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var design: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        design= DataBindingUtil.setContentView(this,R.layout.activity_splash_screen)

        smokeAnim()
        //textAnim()

        Handler().postDelayed({
            val intent = Intent(this, LoginRegisterActivity::class.java)
            startActivity(intent)
            finish()
        }, 3500)
    }

    fun smokeAnim() {
        val anim1=ObjectAnimator.ofFloat(imageViewSmoke,"translationY",0.0f,-120.0f)
        val anim2=ObjectAnimator.ofFloat(imageViewSmoke,"alpha",1.0f,0.0f)

        val anim=AnimatorSet().apply {
            duration=2500
            playSequentially(anim1,anim2)
        }

        anim.start()
    }
/*
    fun textAnim() {
        val anim1=ObjectAnimator.ofFloat(textViewTrendCup,"translationX",-500.0f,0.0f)
        val anim2=ObjectAnimator.ofFloat(textViewTrendCup,"translationY",500.0f,0.0f)
        val anim3=ObjectAnimator.ofFloat(textViewWelcome,"translationX",-500.0f,0.0f)
        val anim4=ObjectAnimator.ofFloat(textViewWelcome,"translationY",500.0f,0.0f)

        val animSet=AnimatorSet().apply {
            duration=2000
            playTogether(anim1,anim2)
        }
        val animSet2=AnimatorSet().apply {
            duration = 2000
            playTogether(anim3, anim4)
        }

        animSet.start()
        animSet2.start()
    }  */

}