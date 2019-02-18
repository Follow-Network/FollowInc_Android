package com.eakurnikov.followinc.ui.auth

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.eakurnikov.followinc.R
import com.eakurnikov.followinc.ui.base.BaseActivity
import com.eakurnikov.followinc.ui.base.BaseFragment
import com.eakurnikov.followinc.vm.auth.AuthVm
import com.eakurnikov.followinc.vm.base.BaseVm
import kotlinx.android.synthetic.main.activity_auth.*

/**
 * Created by eakurnikov on 10.12.2018.
 */

class AuthActivity : BaseActivity<AuthVm>() {

    companion object {

        private const val MODE_KEY = "MODE_KEY"

        private const val SIGN_UP_MODE = "SIGN_UP_MODE"
        private const val LOG_IN_MODE = "LOG_IN_MODE"
        private const val AUTH_ERROR_MODE = "AUTH_ERROR_MODE"

        fun <T : BaseActivity<out BaseVm>> startWithSignUp(from: T) {
            from.startActivity(
                Intent(from, AuthActivity::class.java)
                    .putExtra(MODE_KEY, SIGN_UP_MODE)
            )
        }

        fun <T : BaseActivity<out BaseVm>> startWithLogIn(from: T) {
            from.startActivity(
                Intent(from, AuthActivity::class.java)
                    .putExtra(MODE_KEY, LOG_IN_MODE)
            )
        }
    }

    override lateinit var viewModel: AuthVm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(AuthVm::class.java)

        initViews(
            savedInstanceState == null
        )

        authToolbar.setNavigationOnClickListener {
            if (!supportFragmentManager.popBackStackImmediate()) {
                finish()
            }
        }
    }

    override fun initViews(isFirstTime: Boolean) {
        if (!intent.hasExtra(MODE_KEY) ||
            intent.extras?.get(MODE_KEY) == null
        ) {
            attachFragment(
                AUTH_ERROR_MODE,
                AuthErrorFragment::class.java
            )

            return
        }

        when (intent.extras?.get(MODE_KEY)) {
            SIGN_UP_MODE -> {
                authAppbar.visibility = View.VISIBLE
                authToolbar.title = getString(R.string.sign_up)

                attachFragment(
                    SIGN_UP_MODE,
                    SignUpFragment::class.java
                )
            }
            LOG_IN_MODE -> {
                authAppbar.visibility = View.VISIBLE
                authToolbar.title = getString(R.string.log_in)

                attachFragment(
                    LOG_IN_MODE,
                    LogInFragment::class.java
                )
            }
            else -> {
                authAppbar.visibility = View.GONE

                attachFragment(
                    AUTH_ERROR_MODE,
                    AuthErrorFragment::class.java
                )
            }
        }
    }

    private fun attachFragment(
        mode: String,
        fragmentClass: Class<out BaseFragment>
    ) {
        var fragment = supportFragmentManager.findFragmentByTag(mode)

        if (fragment == null) {
            fragment = fragmentClass.newInstance() as BaseFragment
        }

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.container,
                fragment,
                mode
            )
            .commit()
    }
}