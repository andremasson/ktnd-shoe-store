package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class Welcome : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentWelcomeBinding>(inflater, R.layout.fragment_welcome, container, false)

        binding.btnContinue.setOnClickListener {
            findNavController().navigate(WelcomeDirections.actionWelcomeToInstruction())
        }

        return binding.root
    }

}