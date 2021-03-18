package com.hofit.hofitcellcomtest.ui.flow.dashboard.view

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hofit.hofitcellcomtest.R
import com.hofit.hofitcellcomtest.application.ApplicationCellcom
import com.hofit.hofitcellcomtest.di.components.DaggerDashboardComponent
import com.hofit.hofitcellcomtest.di.modules.DashboardModule
import com.hofit.hofitcellcomtest.repository.RepositoryController
import com.hofit.hofitcellcomtest.repository.models.Country
import com.hofit.hofitcellcomtest.ui.base.BaseActivity
import com.hofit.hofitcellcomtest.ui.base.BasePresenter
import com.hofit.hofitcellcomtest.ui.flow.dashboard.contract.DashboardContract
import com.hofit.hofitcellcomtest.ui.flow.dashboard.presenter.DashboardPresenter
import com.hofit.hofitcellcomtest.ui.flow.dashboard.view.adapter.CountriesAdapter
import kotlinx.android.synthetic.main.activity_dashboard.*
import javax.inject.Inject

class DashboardActivity : BaseActivity(), DashboardContract.View {

    @Inject
    lateinit var mPresenter: DashboardPresenter

    @Inject
    lateinit var mAdapter: CountriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }

    override fun initDependencies() {
        DaggerDashboardComponent.builder().applicationComponent(ApplicationCellcom.applicationComponent)
            .dashboardModule(DashboardModule(this))
            .build()
            .inject(this)
    }

    override fun getPresenter(): BasePresenter<*> {
        return mPresenter
    }

    override fun displayCitiesList(data: List<Country>?) {
        countriesRecyclerView.layoutManager = LinearLayoutManager(this)
        mAdapter.setData(data)
        countriesRecyclerView.adapter = mAdapter
    }

    override fun initViews() {

    }
}