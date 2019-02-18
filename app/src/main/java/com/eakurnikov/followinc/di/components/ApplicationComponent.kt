package com.eakurnikov.followinc.di.components

import com.eakurnikov.followinc.app.FollowIncApp
import com.eakurnikov.followinc.di.annotations.ApplicationScope
import com.eakurnikov.followinc.di.modules.common.*
import dagger.Component
import dagger.android.AndroidInjector

/**
 * Main application component that connects all the dependency providers(modules) to application
 *
 * Created by eakurnikov on 04.12.2018.
 */

@ApplicationScope
@Component(
    modules = [
        ApplicationModule::class,
        RepositoriesModule::class,
        ViewModelModule::class,
        ActivityBuilderModule::class,
        FragmentBuilderModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<FollowIncApp> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<FollowIncApp>()
}