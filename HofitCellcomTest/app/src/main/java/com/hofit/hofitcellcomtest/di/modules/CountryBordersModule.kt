package com.hofit.hofitcellcomtest.di.modules

import com.hofit.hofitcellcomtest.di.scope.PerActivity
import com.hofit.hofitcellcomtest.ui.flow.country_borders.contract.CountryBordersContract
import dagger.Module
import dagger.Provides

@Module
class CountryBordersModule (var mView : CountryBordersContract.View) {

    @PerActivity
    @Provides
    fun provideView() : CountryBordersContract.View{
        return mView
    }
}