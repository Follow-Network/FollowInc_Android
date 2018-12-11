package com.eakurnikov.followinc.di.modules.common

import com.eakurnikov.followinc.di.annotations.ActivityScope
import com.eakurnikov.followinc.di.modules.auth.AuthActivityModule
import com.eakurnikov.followinc.di.modules.auth.StartActivityModule
import com.eakurnikov.followinc.ui.start.StartActivity
import com.eakurnikov.followinc.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Contains all activities to be bound to application dependency graph
 *
 * Created by eakurnikov on 04.12.2018.
 */

@Module
interface ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [StartActivityModule::class])
    fun bindMainActivity(): StartActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [AuthActivityModule::class])
    fun bindAuthActivity(): AuthActivity
}