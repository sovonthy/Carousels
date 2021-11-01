package com.sovonthy.tshop

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.plusAssign
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.sovonthy.tshop.databinding.ActivityMainBinding
import com.sovonthy.tshop.helper.KeepStateNavigator
import com.sovonthy.tshop.view.dashboard.DashboardViewModel

class MainActivity : AppCompatActivity() {
    private val statusViewModel: DashboardViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navigator = KeepStateNavigator(
            this,
            navHostFragment.childFragmentManager,
            R.id.navHostFragment
        )
        val navController = navHostFragment.navController
        navController.navigatorProvider += navigator
        navController.setGraph(R.navigation.nav_graph)

        binding.bottomNav.setupWithNavController(navController)
        binding.navView.setupWithNavController(navController)

//        binding.homeButton.setOnClickListener {
//            binding.bottomNav.selectedItemId = R.id.dashboardFragment
//
//            binding.homeButton.setImageDrawable(
//                ContextCompat.getDrawable(
//                    this, R.drawable.ic_dasboard_clicked
//                )
//            )
//            deselectOriginalMenu(isCheckable = false)
//            Navigation.findNavController(this, R.id.navHostFragment).navigate(
//                R.id.dashboardFragment
//            )
//        }
//        navControllerListener(navController)
//        onBottomNavListener()

    }

    private fun navControllerListener(navController: NavController) {
        navController.addOnDestinationChangedListener { _, _, _ ->
            deselectOriginalMenu(true)
            binding.homeButton.setImageDrawable(
                ContextCompat.getDrawable(
                    this, R.drawable.ic_add
                )
            )
        }
    }

    private fun onBottomNavListener() {
//        binding.bottomNav.setOnItemSelectedListener { item ->
//            NavigationUI.onNavDestinationSelected(
//                item,
//                Navigation.findNavController(this, R.id.navHostFragment)
//            )
//        }
    }

    private fun deselectOriginalMenu(isCheckable: Boolean) {
        binding.bottomNav.menu.apply {
            findItem(R.id.cardFragment).isCheckable = isCheckable
            findItem(R.id.messageFragment2).isCheckable = isCheckable
            findItem(R.id.notificationContainerFragment).isCheckable = isCheckable
            findItem(R.id.favouriteFragment).isCheckable = isCheckable
        }
    }


}