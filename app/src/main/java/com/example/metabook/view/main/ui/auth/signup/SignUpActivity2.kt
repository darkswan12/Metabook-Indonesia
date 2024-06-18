package com.example.metabook.view.main.ui.auth.signup

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.metabook.R
import com.example.metabook.databinding.ActivitySignUp2Binding


class SignUpActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivitySignUp2Binding
    // private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySignUp2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.genre1.setOnClickListener {
            binding.genre2.setBackgroundResource(R.drawable.outline)
            binding.genre3.setBackgroundResource(R.drawable.outline)
            binding.genre4.setBackgroundResource(R.drawable.outline)
            binding.genre5.setBackgroundResource(R.drawable.outline)
            binding.genre6.setBackgroundResource(R.drawable.outline)
            binding.genre7.setBackgroundResource(R.drawable.outline)
            binding.genre8.setBackgroundResource(R.drawable.outline)
            binding.genre9.setBackgroundResource(R.drawable.outline)
            binding.genre10.setBackgroundResource(R.drawable.outline)
            binding.genre1.setBackgroundResource(R.drawable.reg_button)
        }
        binding.genre2.setOnClickListener {
            binding.genre1.setBackgroundResource(R.drawable.outline)
            binding.genre3.setBackgroundResource(R.drawable.outline)
            binding.genre4.setBackgroundResource(R.drawable.outline)
            binding.genre5.setBackgroundResource(R.drawable.outline)
            binding.genre6.setBackgroundResource(R.drawable.outline)
            binding.genre7.setBackgroundResource(R.drawable.outline)
            binding.genre8.setBackgroundResource(R.drawable.outline)
            binding.genre9.setBackgroundResource(R.drawable.outline)
            binding.genre10.setBackgroundResource(R.drawable.outline)
            binding.genre2.setBackgroundResource(R.drawable.reg_button)
        }
        binding.genre3.setOnClickListener {
            binding.genre2.setBackgroundResource(R.drawable.outline)
            binding.genre1.setBackgroundResource(R.drawable.outline)
            binding.genre4.setBackgroundResource(R.drawable.outline)
            binding.genre5.setBackgroundResource(R.drawable.outline)
            binding.genre6.setBackgroundResource(R.drawable.outline)
            binding.genre7.setBackgroundResource(R.drawable.outline)
            binding.genre8.setBackgroundResource(R.drawable.outline)
            binding.genre9.setBackgroundResource(R.drawable.outline)
            binding.genre10.setBackgroundResource(R.drawable.outline)
            binding.genre3.setBackgroundResource(R.drawable.reg_button)
        }
        binding.genre4.setOnClickListener {
            binding.genre2.setBackgroundResource(R.drawable.outline)
            binding.genre3.setBackgroundResource(R.drawable.outline)
            binding.genre1.setBackgroundResource(R.drawable.outline)
            binding.genre5.setBackgroundResource(R.drawable.outline)
            binding.genre6.setBackgroundResource(R.drawable.outline)
            binding.genre7.setBackgroundResource(R.drawable.outline)
            binding.genre8.setBackgroundResource(R.drawable.outline)
            binding.genre9.setBackgroundResource(R.drawable.outline)
            binding.genre10.setBackgroundResource(R.drawable.outline)
            binding.genre4.setBackgroundResource(R.drawable.reg_button)
        }
        binding.genre5.setOnClickListener {
            binding.genre2.setBackgroundResource(R.drawable.outline)
            binding.genre3.setBackgroundResource(R.drawable.outline)
            binding.genre4.setBackgroundResource(R.drawable.outline)
            binding.genre1.setBackgroundResource(R.drawable.outline)
            binding.genre6.setBackgroundResource(R.drawable.outline)
            binding.genre7.setBackgroundResource(R.drawable.outline)
            binding.genre8.setBackgroundResource(R.drawable.outline)
            binding.genre9.setBackgroundResource(R.drawable.outline)
            binding.genre10.setBackgroundResource(R.drawable.outline)
            binding.genre5.setBackgroundResource(R.drawable.reg_button)
        }
        binding.genre6.setOnClickListener {
            binding.genre2.setBackgroundResource(R.drawable.outline)
            binding.genre3.setBackgroundResource(R.drawable.outline)
            binding.genre4.setBackgroundResource(R.drawable.outline)
            binding.genre5.setBackgroundResource(R.drawable.outline)
            binding.genre1.setBackgroundResource(R.drawable.outline)
            binding.genre7.setBackgroundResource(R.drawable.outline)
            binding.genre8.setBackgroundResource(R.drawable.outline)
            binding.genre9.setBackgroundResource(R.drawable.outline)
            binding.genre10.setBackgroundResource(R.drawable.outline)
            binding.genre6.setBackgroundResource(R.drawable.reg_button)
        }
        binding.genre7.setOnClickListener {
            binding.genre2.setBackgroundResource(R.drawable.outline)
            binding.genre3.setBackgroundResource(R.drawable.outline)
            binding.genre4.setBackgroundResource(R.drawable.outline)
            binding.genre5.setBackgroundResource(R.drawable.outline)
            binding.genre6.setBackgroundResource(R.drawable.outline)
            binding.genre1.setBackgroundResource(R.drawable.outline)
            binding.genre8.setBackgroundResource(R.drawable.outline)
            binding.genre9.setBackgroundResource(R.drawable.outline)
            binding.genre10.setBackgroundResource(R.drawable.outline)
            binding.genre7.setBackgroundResource(R.drawable.reg_button)
        }
        binding.genre8.setOnClickListener {
            binding.genre2.setBackgroundResource(R.drawable.outline)
            binding.genre3.setBackgroundResource(R.drawable.outline)
            binding.genre4.setBackgroundResource(R.drawable.outline)
            binding.genre5.setBackgroundResource(R.drawable.outline)
            binding.genre6.setBackgroundResource(R.drawable.outline)
            binding.genre7.setBackgroundResource(R.drawable.outline)
            binding.genre1.setBackgroundResource(R.drawable.outline)
            binding.genre9.setBackgroundResource(R.drawable.outline)
            binding.genre10.setBackgroundResource(R.drawable.outline)
            binding.genre8.setBackgroundResource(R.drawable.reg_button)
        }
        binding.genre9.setOnClickListener {
            binding.genre2.setBackgroundResource(R.drawable.outline)
            binding.genre3.setBackgroundResource(R.drawable.outline)
            binding.genre4.setBackgroundResource(R.drawable.outline)
            binding.genre5.setBackgroundResource(R.drawable.outline)
            binding.genre6.setBackgroundResource(R.drawable.outline)
            binding.genre7.setBackgroundResource(R.drawable.outline)
            binding.genre8.setBackgroundResource(R.drawable.outline)
            binding.genre1.setBackgroundResource(R.drawable.outline)
            binding.genre10.setBackgroundResource(R.drawable.outline)
            binding.genre9.setBackgroundResource(R.drawable.reg_button)
        }
        binding.genre10.setOnClickListener {
            binding.genre2.setBackgroundResource(R.drawable.outline)
            binding.genre3.setBackgroundResource(R.drawable.outline)
            binding.genre4.setBackgroundResource(R.drawable.outline)
            binding.genre5.setBackgroundResource(R.drawable.outline)
            binding.genre6.setBackgroundResource(R.drawable.outline)
            binding.genre7.setBackgroundResource(R.drawable.outline)
            binding.genre8.setBackgroundResource(R.drawable.outline)
            binding.genre9.setBackgroundResource(R.drawable.outline)
            binding.genre1.setBackgroundResource(R.drawable.outline)
            binding.genre10.setBackgroundResource(R.drawable.reg_button)
        }
        binding.next2.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }


    }
}