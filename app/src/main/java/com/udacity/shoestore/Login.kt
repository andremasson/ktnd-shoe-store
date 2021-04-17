package com.udacity.shoestore

import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding
import timber.log.Timber

class Login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater, R.layout.fragment_login, container, false)

        binding.btnLogin.setOnClickListener {
            onLoginOrCreateNewAccount()
        }
        binding.btnCreateAccount.setOnClickListener {
            onLoginOrCreateNewAccount()
        }

        return binding.root
    }

    private fun onLoginOrCreateNewAccount() {
        findNavController().navigate(LoginDirections.actionLoginToWelcome())
    }
}