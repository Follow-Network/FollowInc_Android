package com.eakurnikov.followinc.di.modules.common

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.eakurnikov.followinc.di.annotations.ViewModelKey
import com.eakurnikov.followinc.vm.start.StartVm
import com.eakurnikov.followinc.vm.auth.AuthVm
import com.eakurnikov.followinc.vm.base.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Provides map of all ViewModels and a ViewModelFactory for dependencies
 *
 * Created by eakurnikov on 04.12.2018.
 */

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(StartVm::class)
    fun bindMainViewModel(startVm: StartVm): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AuthVm::class)
    fun bindAuthViewModel(mainVm: AuthVm): ViewModel

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}