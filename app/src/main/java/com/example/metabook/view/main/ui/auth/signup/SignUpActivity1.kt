package com.example.metabook.view.main.ui.auth.signup

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.findNavController
import com.example.metabook.R
import com.example.metabook.databinding.ActivityMainBinding
import com.example.metabook.databinding.ActivitySignUp1Binding
import com.example.metabook.view.main.ui.auth.login.LoginActivity

class SignUpActivity1 : AppCompatActivity() {
    private lateinit var binding: ActivitySignUp1Binding
    // private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySignUp1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.age1.setOnClickListener {
            binding.age2.setBackgroundResource(R.drawable.outline)
            binding.age3.setBackgroundResource(R.drawable.outline)
            binding.age4.setBackgroundResource(R.drawable.outline)
            binding.age5.setBackgroundResource(R.drawable.outline)
            binding.age6.setBackgroundResource(R.drawable.outline)
            binding.age7.setBackgroundResource(R.drawable.outline)
            binding.age8.setBackgroundResource(R.drawable.outline)
            binding.age1.setBackgroundResource(R.drawable.reg_button)
        }
        binding.age2.setOnClickListener {
            binding.age1.setBackgroundResource(R.drawable.outline)
            binding.age3.setBackgroundResource(R.drawable.outline)
            binding.age4.setBackgroundResource(R.drawable.outline)
            binding.age5.setBackgroundResource(R.drawable.outline)
            binding.age6.setBackgroundResource(R.drawable.outline)
            binding.age7.setBackgroundResource(R.drawable.outline)
            binding.age8.setBackgroundResource(R.drawable.outline)
            binding.age2.setBackgroundResource(R.drawable.reg_button)
        }
        binding.age3.setOnClickListener {
            binding.age1.setBackgroundResource(R.drawable.outline)
            binding.age2.setBackgroundResource(R.drawable.outline)
            binding.age4.setBackgroundResource(R.drawable.outline)
            binding.age5.setBackgroundResource(R.drawable.outline)
            binding.age6.setBackgroundResource(R.drawable.outline)
            binding.age7.setBackgroundResource(R.drawable.outline)
            binding.age8.setBackgroundResource(R.drawable.outline)
            binding.age3.setBackgroundResource(R.drawable.reg_button)
        }
        binding.age4.setOnClickListener {
            binding.age2.setBackgroundResource(R.drawable.outline)
            binding.age3.setBackgroundResource(R.drawable.outline)
            binding.age1.setBackgroundResource(R.drawable.outline)
            binding.age5.setBackgroundResource(R.drawable.outline)
            binding.age6.setBackgroundResource(R.drawable.outline)
            binding.age7.setBackgroundResource(R.drawable.outline)
            binding.age8.setBackgroundResource(R.drawable.outline)
            binding.age4.setBackgroundResource(R.drawable.reg_button)
        }
        binding.age5.setOnClickListener {
            binding.age2.setBackgroundResource(R.drawable.outline)
            binding.age3.setBackgroundResource(R.drawable.outline)
            binding.age4.setBackgroundResource(R.drawable.outline)
            binding.age1.setBackgroundResource(R.drawable.outline)
            binding.age6.setBackgroundResource(R.drawable.outline)
            binding.age7.setBackgroundResource(R.drawable.outline)
            binding.age8.setBackgroundResource(R.drawable.outline)
            binding.age5.setBackgroundResource(R.drawable.reg_button)
        }
        binding.age6.setOnClickListener {
            binding.age2.setBackgroundResource(R.drawable.outline)
            binding.age3.setBackgroundResource(R.drawable.outline)
            binding.age4.setBackgroundResource(R.drawable.outline)
            binding.age5.setBackgroundResource(R.drawable.outline)
            binding.age1.setBackgroundResource(R.drawable.outline)
            binding.age7.setBackgroundResource(R.drawable.outline)
            binding.age8.setBackgroundResource(R.drawable.outline)
            binding.age6.setBackgroundResource(R.drawable.reg_button)
        }
        binding.age7.setOnClickListener {
            binding.age2.setBackgroundResource(R.drawable.outline)
            binding.age3.setBackgroundResource(R.drawable.outline)
            binding.age4.setBackgroundResource(R.drawable.outline)
            binding.age5.setBackgroundResource(R.drawable.outline)
            binding.age6.setBackgroundResource(R.drawable.outline)
            binding.age1.setBackgroundResource(R.drawable.outline)
            binding.age8.setBackgroundResource(R.drawable.outline)
            binding.age7.setBackgroundResource(R.drawable.reg_button)
        }
        binding.age8.setOnClickListener {
            binding.age2.setBackgroundResource(R.drawable.outline)
            binding.age3.setBackgroundResource(R.drawable.outline)
            binding.age4.setBackgroundResource(R.drawable.outline)
            binding.age5.setBackgroundResource(R.drawable.outline)
            binding.age6.setBackgroundResource(R.drawable.outline)
            binding.age7.setBackgroundResource(R.drawable.outline)
            binding.age1.setBackgroundResource(R.drawable.outline)
            binding.age8.setBackgroundResource(R.drawable.reg_button)
        }

        binding.next1.setOnClickListener{
            val intent = Intent(this, SignUpActivity2::class.java)
            startActivity(intent)
        }

        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
    }
}