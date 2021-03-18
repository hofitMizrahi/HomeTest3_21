package com.hofit.hofitcellcomtest.ui.flow.country_borders.view

import android.os.Bundle
import com.hofit.hofitcellcomtest.R
import com.hofit.hofitcellcomtest.application.ApplicationCellcom
import com.hofit.hofitcellcomtest.di.components.DaggerCountryBordersComponent
import com.hofit.hofitcellcomtest.di.modules.CountryBordersModule
import com.hofit.hofitcellcomtest.ui.base.BaseActivity
import com.hofit.hofitcellcomtest.ui.base.BasePresenter
import com.hofit.hofitcellcomtest.ui.flow.country_borders.contract.CountryBordersContract
import com.hofit.hofitcellcomtest.ui.flow.country_borders.presenter.CountryBordersPresenter
import javax.inject.Inject

class CountryBordersActivity : CountryBordersContract.View, BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contry_borders)
    }

    @Inject
    lateinit var mPresenter: CountryBordersPresenter

    override fun initDependencies() {
        DaggerCountryBordersComponent.builder().applicationComponent(ApplicationCellcom.applicationComponent)
            .countryBordersModule(CountryBordersModule(this))
            .build()
            .inject(this)
    }

    override fun getPresenter(): BasePresenter<*> {
        return mPresenter
    }

    override fun initViews() {
    }
}