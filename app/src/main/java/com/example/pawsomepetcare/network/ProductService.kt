package com.example.pawsomepetcare.network

import com.example.pawsomepetcare.data.ApiResponse
import retrofit2.http.GET

interface ProductService {
    @GET("api/products")
    suspend fun getProducts(): ApiResponse
}