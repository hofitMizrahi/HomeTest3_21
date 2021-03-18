package com.hofit.hofitcellcomtest.repository

import com.hofit.hofitcellcomtest.repository.models.Country
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RepositoryControllerImp @Inject constructor() : RepositoryController {

    @Inject
    lateinit var mRestApi: RestApi

    override suspend fun getAllCountries(): ResultWrapper<List<Country>?> {
//        return try {
//                ResultWrapper.Success( mRestApi.getAllCities())
//            }catch (ee : Throwable){
//                ResultWrapper.NetworkError
//            }


        return safeApiCall(Dispatchers.IO) { mRestApi.getAllCities() }
    }

//    override suspend fun getBordersCities(): ResultWrapper<List<Country>?> {
////        return safeApiCall(Dispatchers.IO) { mRestApi.getBordersCities() }
//        return try {
//            ResultWrapper.Success( mRestApi.getAllCities())
//        }catch (ee : Throwable){
//            ResultWrapper.NetworkError
//        }
//    }

    private suspend fun <T> safeApiCall(
        dispatcher: CoroutineDispatcher,
        apiCall: suspend () -> T
    ): ResultWrapper<T> {
        return withContext(dispatcher) {
            try {
                ResultWrapper.Success(apiCall.invoke())
            } catch (throwable: Throwable) {
                when (throwable) {
                    is IOException -> ResultWrapper.NetworkError
                    is HttpException -> {
                        val code = throwable.code()
//                        val errorResponse = convertErrorBody(throwable)
                        ResultWrapper.NetworkError
//                        ResultWrapper.GenericError(code, errorResponse)
                    }
                    else -> {
                        ResultWrapper.NetworkError
//                        ResultWrapper.GenericError(null, null)
                    }
                }
            }
        }
    }

//    private fun convertErrorBody(throwable: HttpException): ErrorResponse? {
//        return try {
//            throwable.response()?.errorBody()?.source()?.let {
//                val moshiAdapter = Moshi.Builder().build().adapter(ErrorResponse::class.java)
//                moshiAdapter.fromJson(it)
//            }
//        } catch (exception: Exception) {
//            null
//        }
//    }
}