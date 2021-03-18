package com.hofit.hofitcellcomtest.repository

import com.hofit.hofitcellcomtest.repository.models.Country

interface RepositoryController{

    suspend fun getAllCountries() : ResultWrapper<List<Country>?>

   // suspend fun getBordersCities() : ResultWrapper<List<Country>?>
}