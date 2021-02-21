package com.udacity.shoestore.shoes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding

class ShoeDetailsFragment : Fragment() {

    lateinit var binding: FragmentShoeDetailsBinding
    lateinit var viewModel: ShoeDetailsEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        viewModel = ViewModelProvider(this).get(ShoeDetailsEntity::class.java)
        viewModel.init(binding)
        binding.viewModel = viewModel

        viewModel.cancelShoesAdding.observe(viewLifecycleOwner, Observer {
            if (it)
                findNavController().navigate(ShoeDetailsFragmentDirections.cancelAdding())
        })

        viewModel.addShoeToListOfShoes.observe(viewLifecycleOwner, Observer { shoe ->
            findNavController().navigate(ShoeDetailsFragmentDirections.addShoe(shoe))
        })

        return binding.root
    }

}
