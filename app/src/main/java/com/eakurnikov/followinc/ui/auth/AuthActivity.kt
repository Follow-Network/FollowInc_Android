package com.eakurnikov.followinc.ui.auth

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import com.eakurnikov.followinc.R
import com.eakurnikov.followinc.ui.base.BaseActivity
import com.eakurnikov.followinc.vm.auth.AuthVm
import com.eakurnikov.followinc.vm.base.BaseVm
import kotlinx.android.synthetic.main.activity_auth.*

/**
 * Created by eakurnikov on 10.12.2018.
 */

class AuthActivity: BaseActivity<AuthVm>() {

    companion object {
        fun <T: BaseActivity<out BaseVm>> start(from: T) {
            from.startActivity(
                Intent(from, AuthActivity::class.java)
            )
        }
    }

    override lateinit var viewModel: AuthVm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AuthVm::class.java)

        authToolbar.setNavigationOnClickListener { finish() }
    }

}