package com.udacity.shoestore.viewModel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        _shoeList.value = mutableListOf()
    }

    fun addShoe(shoe: Shoe, view: View) {
        _shoeList.value?.add(shoe)
        view.findNavController().navigateUp()
    }

}