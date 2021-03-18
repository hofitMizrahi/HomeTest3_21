package com.hofit.hofitcellcomtest.ui.flow.dashboard.presenter

import android.util.Log
import com.google.gson.Gson
import com.hofit.hofitcellcomtest.di.scope.PerActivity
import com.hofit.hofitcellcomtest.repository.RepositoryController
import com.hofit.hofitcellcomtest.repository.RepositoryControllerImp
import com.hofit.hofitcellcomtest.repository.ResultWrapper
import com.hofit.hofitcellcomtest.ui.flow.dashboard.contract.DashboardContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@PerActivity
class DashboardPresenter @Inject constructor() : DashboardContract.Presenter {

    companion object{
        const val TAG = "DashboardPresenter"
    }

    @Inject
    lateinit var mRepositoryController: RepositoryController

    @Inject
    lateinit var mView: DashboardContract.View

    override fun onStart() {

        CoroutineScope(Dispatchers.Main).launch {

            val result = mRepositoryController.getAllCountries()


                result?.let { result ->

                    when (result) {
                        is ResultWrapper.Success -> {
                            mView.displayCitiesList(result.data)
                            Log.i(TAG, Gson().toJson(result))
                        }
                        is Error -> {
                            Log.i(TAG, result.message ?: "")
                        }
                        else -> {
                            Log.i(TAG, "")
                        }
                    }
                }
            }

    }
}