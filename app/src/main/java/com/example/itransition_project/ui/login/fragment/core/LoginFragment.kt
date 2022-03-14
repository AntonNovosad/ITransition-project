package com.example.itransition_project.ui.login.fragment.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.itransition_project.R
import com.example.itransition_project.databinding.LoginFragmentBinding

class LoginFragment : Fragment(R.layout.login_fragment) {

    lateinit var binding: LoginFragmentBinding

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        observeFields()

        with(binding) {
            emailEditText.addTextChangedListener(
                onTextChanged = { text, start, before, count ->
                    viewModel.updateEmailText(text?.toString() ?: "")
                }
            )

            passwordEditText.addTextChangedListener(
                onTextChanged = { text, start, before, count ->
                    viewModel.updatePasswordText(text?.toString() ?: "")
                }
            )

            buttonLogin.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_mainActivity)
            }
        }
    }

    private fun observeFields() {
        viewModel.emailLiveData.observe(viewLifecycleOwner) { email ->
            if (binding.emailEditText.text.toString() != email) {
                binding.emailEditText.setText(email)
            }
        }

        viewModel.passwordLiveData.observe(viewLifecycleOwner) { password ->
            if (binding.passwordEditText.text.toString() != password) {
                binding.passwordEditText.setText(password)
            }
        }

        viewModel.isFormValidLiveData.observe(viewLifecycleOwner) { isValid ->
            binding.buttonLogin.isEnabled = isValid
        }
    }
}