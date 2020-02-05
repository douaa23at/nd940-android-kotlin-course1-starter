package com.udacity.shoestore.shoes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.main.MainActivityViewModel
import com.udacity.shoestore.utils.hideKeyboard

class ShoeDetailsFragment : Fragment() {

    lateinit var binding: FragmentShoeDetailsBinding
    lateinit var viewModel: ShoeDetailsEntity
    private val mainActivityViewModel: MainActivityViewModel by activityViewModels()

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
        binding.viewModel = viewModel
        viewModel.cancelShoesAdding.observe(viewLifecycleOwner, Observer {
            it.getContentIfNotHandled()?.let {
                hideKeyboard()
                findNavController().navigate(ShoeDetailsFragmentDirections.navigateToShoes())
            }
        })

        viewModel.addShoeToListOfShoes.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let {
                mainActivityViewModel.addShoe(it)
                hideKeyboard()
                findNavController().navigate(ShoeDetailsFragmentDirections.navigateToShoes())
            }
        })

        return binding.root
    }

}
