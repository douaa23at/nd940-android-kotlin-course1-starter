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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesBinding
import com.udacity.shoestore.main.MainActivityViewModel

class ShoesFragment : Fragment() {

    lateinit var binding: FragmentShoesBinding
    lateinit var viewModel: ShoesViewModel
    private val mainActivityViewModel: MainActivityViewModel by activityViewModels()
    lateinit var adapter: ShoesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes, container, false)
        viewModel = ViewModelProvider(this).get(ShoesViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.navigateToDetailPage.observe(viewLifecycleOwner, Observer { navigate ->
            navigate.getContentIfNotHandled()?.let {
                findNavController().navigate(ShoesFragmentDirections.navigateToDetail())
            }
        })
        adapter = ShoesAdapter()
        binding.shoesList.adapter = adapter
        binding.shoesList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        mainActivityViewModel.listOfShoes.observe(viewLifecycleOwner, Observer { list ->
            adapter.items = list
        })
        return binding.root
    }
}
