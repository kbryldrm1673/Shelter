package com.kubra.koubitirme.common

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

abstract class BaseViewModelFragment<viewModel: ViewModel>:Fragment() {

    lateinit var viewModel : viewModel

    abstract fun getViewModel():Class<viewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(getViewModel())
    }
}