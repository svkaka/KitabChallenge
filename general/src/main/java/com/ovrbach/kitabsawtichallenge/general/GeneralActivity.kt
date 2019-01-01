package com.ovrbach.kitabsawtichallenge.general

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ovrbach.kitabsawtichallenge.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class GeneralActivity : BaseActivity<GeneralViewModel>(GeneralViewModel::class.java) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(general_content)
        findViewById<BottomNavigationView>(R.id.general_bottom_nav)
                .setupWithNavController(navController)
    }
}
