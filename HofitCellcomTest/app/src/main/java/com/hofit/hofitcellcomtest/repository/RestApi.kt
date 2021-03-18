package com.hofit.hofitcellcomtest.repository

import com.hofit.hofitcellcomtest.repository.models.Country
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RestApi {

    @GET("all")
    suspend fun getAllCities(): List<Country>?

    @GET("all")
    suspend fun getBordersCities(): List<Country>?
}