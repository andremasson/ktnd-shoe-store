package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeDetail : Fragment() {

    private lateinit var viewModel: ShoeDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = DataBindingUtil.inflate<FragmentShoeDetailBinding>(inflater, R.layout.fragment_shoe_detail, container, false)

        binding.btnCancel.setOnClickListener {
            goBack()
        }
        binding.btnAddShoe.setOnClickListener {
            save()
        }

        viewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)
        binding.shoeDetailViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.eventSave.observe(this, Observer { shouldSave ->
            if (shouldSave) {
                save()
            }
        })

        return binding.root
    }

    private fun save() {
        val shoe: Shoe = viewModel.returnShoe()
        val shoeListViewModel: ShoeListViewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)
        shoeListViewModel.addShoe(shoe)
        findNavController().popBackStack()
    }

    private fun goBack() {
        findNavController().popBackStack()
    }
}