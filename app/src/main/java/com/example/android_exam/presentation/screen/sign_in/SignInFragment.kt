package com.example.android_exam.presentation.screen.sign_in

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.android_exam.databinding.FragmentSignInBinding
import com.example.android_exam.presentation.base.BaseFragment
import com.example.android_exam.presentation.event.SignInEvent
import com.example.android_exam.presentation.state.sign_in.SignInState
import com.example.android_exam.presentation.screen.auth.AuthContainerFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignInFragment : BaseFragment<FragmentSignInBinding>(FragmentSignInBinding::inflate) {

    private val signInViewModel: SignInViewModel by viewModels()

    override fun setUpListeners() {
        binding.btnSignIn.setOnClickListener {
            signInViewModel.onEvent(
                SignInEvent.SignIn(
                    binding.etSignInEmail.text.toString(),
                    binding.etSignInPassword.text.toString()
                )
            )
        }
    }

    override fun setUpObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                signInViewModel.signInStateFlow.collect {
                    handleState(it)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                signInViewModel.uiEvent.collect {
                    handleUiEvent(it)
                }
            }
        }
    }

    private fun handleUiEvent(event: SignInViewModel.SignInUiEvent) {
        when (event) {
            is SignInViewModel.SignInUiEvent.NavigateToWallpapers ->
                findNavController().navigate(
                    AuthContainerFragmentDirections.actionAuthContainerFragmentToWallpaperFragment()
                )
        }
    }

    private fun handleState(state: SignInState) {
        binding.progressBarSignIn.visibility = if (state.isLoading) View.VISIBLE else View.INVISIBLE

        with(binding) {
            tvSignInError.visibility = View.VISIBLE
            if (state.errorMessage != "") {
                tvSignInError.text = state.errorMessage
                progressBarSignIn.visibility = View.INVISIBLE
            }
        }
    }
}