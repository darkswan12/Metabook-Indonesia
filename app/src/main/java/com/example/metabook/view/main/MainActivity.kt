package com.example.metabook.view.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.metabook.R
import com.example.metabook.databinding.ActivityMainBinding
import com.example.metabook.view.main.ui.auth.login.LoginActivity
import com.example.metabook.view.main.ui.welcome.WelcomeActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    //private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "token")
    private lateinit var binding: ActivityMainBinding
   // private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setupViewModel()
        setupToolbar()
        //setupView()
    }

    private fun setupToolbar() {
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_logout -> {
                    FirebaseAuth.getInstance().signOut()
                    startActivity(Intent(this, WelcomeActivity::class.java))
                    finishAffinity()
                    true
                }

                R.id.menu_setting_language -> {
                    startActivity(Intent(Settings.ACTION_LOCALE_SETTINGS))
                    finishAffinity()
                    true
                }

                else -> false
            }
        }
    }


    /*private fun setupViewModel() {
        val pref = UserPreference.getInstance(dataStore)
        val viewModelFactory = ViewModelFactory(pref)

        mainViewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private fun setupView() {

        storyAdapter = StoryAdapter()
        mainViewModel.getUserToken().observe(this) { token ->
            if (token.isNotEmpty()) {
                mainViewModel.stories.observe(this) {
                    when (it) {
                        is Result.Success -> {
                            it.data?.let { stories ->
                                storyAdapter.submitList(stories)
                            }
                            showLoad(false)
                            val layoutManager = LinearLayoutManager(this)
                            binding.listStory.layoutManager = layoutManager
                            binding.listStory.adapter = storyAdapter
                        }

                        is Result.Loading -> showLoad(true)
                        is Result.Error -> {
                            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                CoroutineScope(Dispatchers.IO).launch {
                    mainViewModel.getStories()
                }
            } else {
                startActivity(Intent(this, WelcomeActivity::class.java))
                finish()
            }
        }

        mainViewModel.logoutResult.observe(this) { result ->
            when (result) {
                is Result.Success -> {
                    startActivity(Intent(this, LoginActivity::class.java))
                    finishAffinity()
                }

                is Result.Loading -> {
                    showLoad(true)
                }

                is Result.Error -> {
                    Toast.makeText(this, result.message, Toast.LENGTH_SHORT).show()
                    showLoad(false)
                }
            }
        }

    }

    private fun showLoad(isLoad: Boolean) {
        if (isLoad) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }*/
}