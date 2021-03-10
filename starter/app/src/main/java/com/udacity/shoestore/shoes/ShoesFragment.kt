package com.udacity.shoestore.shoes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoesBinding
import com.udacity.shoestore.databinding.ShoeElementBinding
import com.udacity.shoestore.main.MainActivityViewModel

class ShoesFragment : Fragment() {

    lateinit var binding: FragmentShoesBinding
    lateinit var viewModel: ShoesViewModel
    private val mainActivityViewModel: MainActivityViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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

        mainActivityViewModel.listOfShoes.observe(viewLifecycleOwner, Observer { list ->
            list.forEach {
                val elementBinding = ShoeElementBinding.inflate(inflater, container, false)
                elementBinding.entity = it
                binding.shoesList.addView(elementBinding.root)
            }

        })
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.logout_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, findNavController())
                || super.onOptionsItemSelected(item)
    }

}
