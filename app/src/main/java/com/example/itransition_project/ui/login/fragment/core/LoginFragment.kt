package com.example.itransition_project.ui.login.fragment.core

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.itransition_project.R
import com.example.itransition_project.databinding.LoginFragmentBinding
import com.example.itransition_project.extensions.repeatWithLifecycle
import dagger.android.support.DaggerFragment
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class LoginFragment : DaggerFragment(R.layout.login_fragment) {

    @Inject
    lateinit var viewModelFactory: LoginViewModelFactory

    lateinit var binding: LoginFragmentBinding

    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
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

        repeatWithLifecycle {
            viewModel.isFormValidStateFlow.collect { isValid ->
                binding.buttonLogin.isEnabled = isValid
            }
        }

        repeatWithLifecycle {
            viewModel.emailStateFlow
                .collect { email ->
                    if (binding.emailEditText.text.toString() != email) {
                        binding.emailEditText.setText(email)
                    }
                }
        }

        repeatWithLifecycle {
            viewModel.passwordStateFlow.collect { password ->
                if (binding.passwordEditText.text.toString() != password) {
                    binding.passwordEditText.setText(password)
                }
            }
        }
    }
}