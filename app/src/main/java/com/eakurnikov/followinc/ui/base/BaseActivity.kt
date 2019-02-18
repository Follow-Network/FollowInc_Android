package com.eakurnikov.followinc.ui.base

import android.arch.lifecycle.ViewModelProvider
import android.content.Intent
import com.eakurnikov.followinc.vm.base.BaseVm
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by eakurnikov on 10.12.2018.
 */

abstract class BaseActivity<T: BaseVm>: DaggerAppCompatActivity() {

    protected var disposables = CompositeDisposable()

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    protected abstract var viewModel: T

    protected abstract fun initViews(isFirstTime: Boolean)

    override fun onStart() {
        super.onStart()

        viewModel.onStart()
        subscribe()
    }

    override fun onStop() {
        super.onStop()

        viewModel.onStop()
        disposables.dispose()
    }

    open fun subscribe() {}
}