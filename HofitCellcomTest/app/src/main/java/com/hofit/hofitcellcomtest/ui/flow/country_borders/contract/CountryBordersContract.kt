package com.hofit.hofitcellcomtest.ui.flow.country_borders.contract

import com.hofit.hofitcellcomtest.ui.base.BasePresenter
import com.hofit.hofitcellcomtest.ui.base.BaseView
import com.hofit.hofitcellcomtest.ui.flow.country_borders.presenter.CountryBordersPresenter

interface CountryBordersContract {

    interface View : BaseView {
    }

    interface Presenter : BasePresenter<CountryBordersPresenter> {
    }
}