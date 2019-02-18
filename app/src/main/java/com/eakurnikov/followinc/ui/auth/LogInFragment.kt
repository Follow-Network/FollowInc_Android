package com.eakurnikov.followinc.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eakurnikov.followinc.R
import com.eakurnikov.followinc.ui.base.BaseFragment

/**
 * Created by eakurnikov on 12.12.2018.
 */

class LogInFragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_log_in,
            container,
            false
        )
    }
}