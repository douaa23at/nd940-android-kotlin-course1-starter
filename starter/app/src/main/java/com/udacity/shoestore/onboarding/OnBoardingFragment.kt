package com.udacity.shoestore.onboarding

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
import com.udacity.shoestore.databinding.FragmentOnBoardingBinding
import kotlinx.android.synthetic.main.fragment_on_boarding.*

class OnBoardingFragment : Fragment() {

    lateinit var binding: FragmentOnBoardingBinding
    lateinit var viewModel: OnBoardingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_on_boarding, container, false)
        viewModel = ViewModelProvider(this).get(OnBoardingViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.navigateToInstructions.observe(viewLifecycleOwner, Observer { navigate ->
            if (navigate) {
                findNavController().navigate(OnBoardingFragmentDirections.actionOnBoardingFragmentToInstructionFragment())
            }
        })
        return binding.root
    }

}