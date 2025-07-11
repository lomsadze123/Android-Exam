package com.example.android_exam.presentation.screen.profile

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.android_exam.databinding.FragmentProfileBinding
import com.example.android_exam.presentation.base.BaseFragment
import com.example.android_exam.presentation.event.ProfileEvent
import com.example.android_exam.presentation.extension.loadImage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val profileViewModel: ProfileViewModel by viewModels()

    override fun setUpListeners() {
        binding.btnSignOut.setOnClickListener {
            profileViewModel.onEvent(ProfileEvent.SignOutEvent)
        }
    }

    override fun setUpObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    profileViewModel.userStateFlow.collect {
                        with(binding) {
                            tvEmailUser.text = it?.email
                            tvFullNameUser.text = it?.displayName
                            it?.photoUrl?.let {
                                shapeableImageView.loadImage(it.toString())
                            }
                        }
                    }
                }

                launch {
                    profileViewModel.uiEvent.collect {
                        handleUiEvent(it)
                    }
                }
            }
        }
    }

    private fun handleUiEvent(event: ProfileViewModel.ProfileUiEvent) {
        when(event) {
            is ProfileViewModel.ProfileUiEvent.GoToSignInFragmentEvent ->
                findNavController().navigate(ProfileFragmentDirections.actionProfileFragmentToAuthContainerFragment())
        }
    }
}