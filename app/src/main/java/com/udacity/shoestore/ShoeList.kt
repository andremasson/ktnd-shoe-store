package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import timber.log.Timber
import java.io.Serializable
import java.time.format.TextStyle

class ShoeList : Fragment() {

    lateinit var viewModel: ShoeListViewModel
    lateinit var shoeListContainer: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = DataBindingUtil.inflate<FragmentShoeListBinding>(inflater, R.layout.fragment_shoe_list, container, false)

        viewModel = ViewModelProvider(this.requireActivity()).get(ShoeListViewModel::class.java)

        binding.lifecycleOwner = this
        shoeListContainer = binding.shoelistContainer

        binding.fabAddShoe.setOnClickListener {
            newShoe()
        }

        viewModel.shoeList.observe(this, Observer {
            renderList()
        })

        setHasOptionsMenu(true)


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.app_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = requireView().findNavController()
        return NavigationUI.onNavDestinationSelected(item, navController) || super.onOptionsItemSelected(item)
    }

    private fun newShoe() {
        findNavController().navigate(ShoeListDirections.actionShoeListToShoeDetail())
    }

    private fun renderList() {
        shoeListContainer.removeAllViews()
        val list: MutableList<Shoe> = viewModel.shoeList.value!!.toMutableList()
        list.forEach {
            var shoeNameText = TextView(context)
            shoeNameText.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            shoeNameText.text = it.name
            shoeNameText.setLineSpacing(20F, 0F)
            shoeNameText.textSize = 24F
            shoeNameText.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
            shoeListContainer.addView(shoeNameText)

        }
    }
}