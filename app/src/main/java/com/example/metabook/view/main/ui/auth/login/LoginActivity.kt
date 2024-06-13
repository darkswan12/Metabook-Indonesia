package com.example.metabook.view.main.ui.auth.login

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.metabook.databinding.ActivityLoginBinding
import com.example.metabook.view.main.MainActivity
import com.example.metabook.view.main.MainActivity2
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
   //private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token")
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
   // private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        //setupViewModel()
        //setupView()
        //setupAction()
        playAnimation()
        firebaseAuth = FirebaseAuth.getInstance()


        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val pass = binding.passwordEditText.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity2::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun onStart() {
        super.onStart()

        if(firebaseAuth.currentUser != null){
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }


   /* private fun setupViewModel() {
        val pref = UserPreference.getInstance(dataStore)
        loginViewModel = ViewModelProvider(this, ViewModelFactory(pref))[LoginViewModel::class.java]
    }

    private fun setupView() {
        loginViewModel.loginResult.observe(this) { resource ->
            when (resource) {
                is Result.Success -> {
                    showLoad(false)
                    AlertDialog.Builder(this).apply {
                        setTitle(resources.getString(R.string.title_msg))
                        setMessage(resources.getString(R.string.success_msg))
                        setPositiveButton(resources.getString(R.string.next_msg)) { _, _ ->
                            val intent = Intent(context, MainActivity::class.java)
                            intent.flags =
                                Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intent)
                            finish()
                        }
                        create()
                        show()
                    }
                }

                is Result.Loading -> showLoad(true)
                is Result.Error -> {
                    AlertDialog.Builder(this).apply {
                        setTitle(resources.getString(R.string.title_error_msg))
                        setMessage(resources.getString(R.string.error_msg))
                        setNegativeButton(resources.getString(R.string.create_account_msg)) { _, _ ->
                            val intent = Intent(context, SignUpActivity::class.java)
                            intent.flags =
                                Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intent)
                            finish()
                        }
                        setPositiveButton(resources.getString(R.string.repeat_msg)) { _, _ ->
                            val intent = Intent(context, LoginActivity::class.java)
                            intent.flags =
                                Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intent)
                            finish()
                        }
                        create()
                        show()
                    }
                }
            }
        }
    }
    */
    private fun showLoad(isLoad: Boolean) {
        if (isLoad) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

   /* private fun setupAction() {
        binding.loginButton.setOnClickListener {
            if (valid()) {
                val email = binding.emailEditText.text.toString()
                val password = binding.passwordEditText.text.toString()
                loginViewModel.login(email, password)
            } else {
                Toast.makeText(
                    this,
                    resources.getString(R.string.check_email),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }*/

    private fun valid() =
        binding.emailEditText.error == null && binding.passwordEditText.error == null &&
                !binding.emailEditText.text.isNullOrEmpty() && !binding.passwordEditText.text.isNullOrEmpty()


    private fun playAnimation() {
        ObjectAnimator.ofFloat(binding.imageView, View.TRANSLATION_X, -30f, 30f).apply {
            duration = 6000
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }.start()

        val title = ObjectAnimator.ofFloat(binding.titleTextView, View.ALPHA, 1f).setDuration(100)
        val message =
            ObjectAnimator.ofFloat(binding.messageTextView, View.ALPHA, 1f).setDuration(100)
        val emailTextView =
            ObjectAnimator.ofFloat(binding.emailTextView, View.ALPHA, 1f).setDuration(100)
        val emailEditTextLayout =
            ObjectAnimator.ofFloat(binding.emailEditTextLayout, View.ALPHA, 1f).setDuration(100)
        val passwordTextView =
            ObjectAnimator.ofFloat(binding.passwordTextView, View.ALPHA, 1f).setDuration(100)
        val passwordEditTextLayout =
            ObjectAnimator.ofFloat(binding.passwordEditTextLayout, View.ALPHA, 1f).setDuration(100)
        val login = ObjectAnimator.ofFloat(binding.loginButton, View.ALPHA, 1f).setDuration(100)


        AnimatorSet().apply {
            playSequentially(
                title,
                message,
                emailTextView,
                emailEditTextLayout,
                passwordTextView,
                passwordEditTextLayout,
                login
            )
            startDelay = 100
        }.start()

    }
}