package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        // Inform Activity that we have custom toolbar
        setSupportActionBar(binding.toolbar)

        // find nav host fragment manually as we are using FragmentContainerView
        // see https://developer.android.com/guide/navigation/navigation-getting-started
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        // setup multiple fragments as "root" fragments to hide back button from toolbar on
        // these fragments
        val appBarConfiguration = AppBarConfiguration
            .Builder(
                R.id.loginFragment,
                R.id.storeFragment
            )
            .build()

        // Setup navigation controller via toolbar so we don't need to override fun onSupportNavigateUp()
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }
}
