package com.example.pawsomepetcare.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pawsomepetcare.model.Featured
import com.example.pawsomepetcare.network.ProductInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FeaturedViewModel: ViewModel() {
    private val _products = MutableStateFlow<List<Featured>>(emptyList())
    val products: StateFlow<List<Featured>> get() = _products

    private val _error = MutableStateFlow<String?>(null)
    val error:StateFlow<String?> get() = _error

    init {
        fetchProducts()
    }

    private fun fetchProducts(){
        viewModelScope.launch {
            try {
                val response = ProductInstance.api.getProducts()
                _products.value = response.data
            }catch (e:Exception){
                _error.value = e.message
            }
        }
    }
}