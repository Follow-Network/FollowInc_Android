package com.eakurnikov.followinc.ui.start

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.eakurnikov.followinc.R
import com.eakurnikov.followinc.ui.auth.AuthActivity
import com.eakurnikov.followinc.ui.base.BaseActivity
import com.eakurnikov.followinc.vm.start.StartVm
import kotlinx.android.synthetic.main.activity_start.*

/**
 * Created by eakurnikov on 04.12.2018.
 */

class StartActivity : BaseActivity<StartVm>() {

    override lateinit var viewModel: StartVm

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(StartVm::class.java)
    }

    override fun initViews(isFirstTime: Boolean) {
    }

    override fun onStart() {
        super.onStart()

        signUpBtn.setOnClickListener {
            AuthActivity.startWithSignUp(
                this@StartActivity
            )
        }

        logInBtn.setOnClickListener {
            AuthActivity.startWithLogIn(
                this@StartActivity
            )
        }
    }


}