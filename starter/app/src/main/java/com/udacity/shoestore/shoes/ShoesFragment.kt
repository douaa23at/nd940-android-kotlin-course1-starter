package com.udacity.shoestore.shoes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesBinding

class ShoesFragment : Fragment() {

    lateinit var binding: FragmentShoesBinding
    lateinit var viewModel: ShoesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes, container, false)
        viewModel = ViewModelProvider(this).get(ShoesViewModel::class.java)
        viewModel.initialize()
        binding.viewModel = viewModel
        viewModel.navigateToDetailPage.observe(viewLifecycleOwner, Observer { navigate ->
            if (navigate) {
                findNavController().navigate(ShoesFragmentDirections.actionShoesFragmentToShoeDetailsFragment())
            }
        })
        viewModel.shoesList.observe(viewLifecycleOwner, Observer { list ->

        })

        return binding.root
    }
}