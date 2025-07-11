package com.example.android_exam.presentation.screen.auth

import com.example.android_exam.databinding.FragmentAuthContainerBinding
import com.example.android_exam.presentation.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator

class AuthContainerFragment :
    BaseFragment<FragmentAuthContainerBinding>(FragmentAuthContainerBinding::inflate) {

    override fun setUp() {
        val adapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Sign In"
                1 -> "Sign Up"
                else -> throw IllegalStateException("Invalid position")
            }
        }.attach()
    }

}