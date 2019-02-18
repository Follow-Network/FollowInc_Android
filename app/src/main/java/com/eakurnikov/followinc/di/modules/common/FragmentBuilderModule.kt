package com.eakurnikov.followinc.di.modules.common

import com.eakurnikov.followinc.di.annotations.FragmentScope
import com.eakurnikov.followinc.ui.auth.AuthErrorFragment
import com.eakurnikov.followinc.ui.auth.LogInFragment
import com.eakurnikov.followinc.ui.auth.SignUpFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Contains all activities to be bound to application dependency graph
 *
 * Created by eakurnikov on 09.02.2019.
 */

@Module(includes = [AndroidSupportInjectionModule::class])
interface FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun bindLogInFragment(): LogInFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun bindSignUpFragment(): SignUpFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun bindAuthErrorFragment(): AuthErrorFragment
}