package com.example.itransition_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.itransition_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}