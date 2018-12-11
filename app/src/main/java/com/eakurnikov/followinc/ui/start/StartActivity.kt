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

//    private val onPosts = object : DisposableObserver<Resource<List<Post>>>() {
//        override fun onComplete() {
//        }
//
//        override fun onNext(resource: Resource<List<Post>>) {
//            when (resource.status) {
//                Resource.Status.SUCCESS -> {
//                    val posts = resource.data?.toString()
//                    tv.text = posts
//                }
//                Resource.Status.LOADING -> {
//                    tv.text = "Loading..."
//                }
//                Resource.Status.ERROR -> {
//                    tv.text = "ERROR :("
//                }
//            }
//        }
//
//        override fun onError(e: Throwable) {
//            Toast.makeText(this@StartActivity, e.message, Toast.LENGTH_LONG).show()
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(StartVm::class.java)
    }

    override fun onStart() {
        super.onStart()

        signUpBtn.setOnClickListener {
            AuthActivity.start(this@StartActivity)
        }

        logInBtn.setOnClickListener {
            AuthActivity.start(this@StartActivity)
        }
    }

//    override fun subscribe() {
//        disposables.add(
//            viewModel.postsSubject
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeWith(onPosts)
//        )
//    }
}