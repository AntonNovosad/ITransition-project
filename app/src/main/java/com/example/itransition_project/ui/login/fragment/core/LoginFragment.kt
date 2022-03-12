package com.example.itransition_project.ui.login.fragment.core

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.example.itransition_project.ui.home.HomeActivity
import com.example.itransition_project.R
import com.example.itransition_project.databinding.LoginFragmentBinding

class LoginFragment : Fragment(R.layout.login_fragment) {

    lateinit var binding: LoginFragmentBinding

    private val emailLiveData = MutableLiveData<String>() //stateflow
    private val passwordLiveData = MutableLiveData<String>()
    private val isValidLiveData = MediatorLiveData<Boolean>().apply {
        this.value = false

        addSource(emailLiveData) { email ->
            val password = passwordLiveData.value
            this.value = validateForm(email, password)
        }
        addSource(passwordLiveData) { password ->
            val email = emailLiveData.value
            this.value = validateForm(email, password)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater)

        val emailEdit = binding.emailEditText
        val passwordEdit = binding.passwordEditText
        val loginButton = binding.buttonLogin

        emailEdit.addTextChangedListener { text ->
            emailLiveData.value = text.toString()
        }
        passwordEdit.addTextChangedListener { text ->
            passwordLiveData.value = text.toString()
        }
        isValidLiveData.observe(viewLifecycleOwner) { isValid ->
            loginButton.isEnabled = isValid
        }

        binding.buttonLogin.setOnClickListener {
            val intent = Intent(this@LoginFragment.requireContext(), HomeActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    private fun validateForm(email: String?, password: String?): Boolean {
        val isValidEmail = email != null && email.isNotBlank() && email.contains("@")
        val isValidPassword = password != null && password.isNotBlank() && password.length >= 2 && password.length <= 10
        return isValidEmail && isValidPassword
    }
}