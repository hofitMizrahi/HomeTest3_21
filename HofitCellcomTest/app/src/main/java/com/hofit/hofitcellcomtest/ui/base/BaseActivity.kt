package com.hofit.hofitcellcomtest.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDependencies()

        getPresenter()?.apply {
            onStart()
        }
    }

    abstract fun initDependencies()

    abstract fun getPresenter() : BasePresenter<*>?
}
