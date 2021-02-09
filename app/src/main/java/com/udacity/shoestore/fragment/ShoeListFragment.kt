package com.udacity.shoestore.fragment

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.viewModel.ShoeListViewModel

class ShoeListFragment : Fragment() {

    private val shoeListViewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: FragmentShoeListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.lifecycleOwner = this

        binding.addShoeBtn.setOnClickListener { view ->
            view.findNavController()
                .navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        shoeListViewModel.shoeList.observe(viewLifecycleOwner, Observer { listShoe ->
            for (shoe in listShoe) {
                DataBindingUtil.inflate<ShoeItemBinding>(
                    inflater,
                    R.layout.shoe_item,
                    binding.shoesContainer,
                    true
                ).apply {
                    this.shoe = shoe
                }
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
        }
        return super.onOptionsItemSelected(item)
    }
}