package com.example.itransition_project.ui.login.fragment.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.itransition_project.R
import com.example.itransition_project.databinding.LoginFragmentBinding
import com.example.itransition_project.ui.login.LoginViewModel

class LoginFragment : Fragment(R.layout.login_fragment) {

    lateinit var binding: LoginFragmentBinding
    private lateinit var vm: LoginViewModel

    private val emailLiveData = MutableLiveData<String>() //stateflow all
    private val passwordLiveData = MutableLiveData<String>()
    private val isValidLiveData = MediatorLiveData<Boolean>().apply {
        this.value = false

        addSource(emailLiveData) { email ->
            val password = passwordLiveData.value
            this.value = vm.validationForm(email, password)
        }
        addSource(passwordLiveData) { password ->
            val email = emailLiveData.value
            this.value = vm.validationForm(email, password)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = LoginFragmentBinding.inflate(inflater)

        vm = ViewModelProvider(this).get(LoginViewModel::class.java)

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
            findNavController().navigate(R.id.action_loginFragment_to_mainActivity)
        }

        return binding.root
    }
}