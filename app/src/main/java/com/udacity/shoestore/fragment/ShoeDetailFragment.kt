package com.udacity.shoestore.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewModel.ShoeListViewModel


class ShoeDetailFragment : Fragment() {

    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentShoeDetailBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        binding.shoeListViewModel = shoeListViewModel
        binding.shoe = Shoe("", 0.0, "", "")

        binding.cancelButton.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        return binding.root
    }
}