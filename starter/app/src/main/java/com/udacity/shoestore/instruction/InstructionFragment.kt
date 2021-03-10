package com.udacity.shoestore.instruction

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
import com.udacity.shoestore.databinding.FragmentInstructionBinding
import com.udacity.shoestore.databinding.FragmentLoginBinding


class InstructionFragment : Fragment() {

    lateinit var binding: FragmentInstructionBinding
    lateinit var viewModel: InstructionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)
        viewModel = ViewModelProvider(this).get(InstructionViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.navigateToShoesList.observe(viewLifecycleOwner, Observer { navigate ->
            navigate.getContentIfNotHandled()?.let {
                findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoesFragment())
            }

        })
        return binding.root
    }

}
