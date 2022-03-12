package com.example.itransition_project.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.itransition_project.R
import com.example.itransition_project.databinding.ActivityHomeBinding
import com.example.itransition_project.ui.home.fragment.core.HomeFragment

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.homeLayout, HomeFragment())
            .commit()

    }
}