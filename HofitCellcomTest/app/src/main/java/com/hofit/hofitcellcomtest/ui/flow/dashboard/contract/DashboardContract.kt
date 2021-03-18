package com.hofit.hofitcellcomtest.ui.flow.dashboard.contract

import com.hofit.hofitcellcomtest.repository.ResultWrapper
import com.hofit.hofitcellcomtest.repository.models.Country
import com.hofit.hofitcellcomtest.ui.base.BasePresenter
import com.hofit.hofitcellcomtest.ui.base.BaseView
import com.hofit.hofitcellcomtest.ui.flow.dashboard.presenter.DashboardPresenter

interface DashboardContract {

    interface View : BaseView{
        fun displayCitiesList(data: List<Country>?)
    }

    interface Presenter : BasePresenter<DashboardPresenter>{

    }
}