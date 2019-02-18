package com.eakurnikov.followinc.di.modules.start

import com.eakurnikov.followinc.di.modules.auth.AuthModule
import dagger.Module

/**
 * Contains all start activity level dependencies
 *
 * Created by eakurnikov on 04.12.2018.
 */

@Module(includes = [AuthModule::class])
class StartActivityModule