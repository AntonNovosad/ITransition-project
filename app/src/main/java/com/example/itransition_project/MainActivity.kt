package com.example.itransition_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.itransition_project.databinding.ActivityMainBinding
import com.example.itransition_project.ui.login.fragment.core.LoginFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameLayout, LoginFragment())
            .commit()

    }
}