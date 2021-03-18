package com.hofit.hofitcellcomtest.repository

sealed class ResultWrapper<out T>{
    data class Success<out T>(val data: T) : ResultWrapper<T>()
    data class Error(val code : Int) : ResultWrapper<Nothing>()
    object NetworkError: ResultWrapper<Nothing>()
}