package com.hofit.hofitcellcomtest.ui.flow.country_borders.presenter

import com.hofit.hofitcellcomtest.di.scope.PerActivity
import com.hofit.hofitcellcomtest.ui.flow.country_borders.contract.CountryBordersContract
import javax.inject.Inject

@PerActivity
class CountryBordersPresenter  @Inject constructor() : CountryBordersContract.Presenter {

    @Inject
    lateinit var mView: CountryBordersContract.View

    override fun onStart() {
    }
}