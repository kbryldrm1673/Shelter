package com.kubra.koubitirme.common

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

abstract  class BaseActivity<dataBinding : ViewDataBinding,viewModel : ViewModel> : AppCompatActivity() {

    lateinit var dataBinding : dataBinding
    lateinit var viewModel : viewModel

    @LayoutRes
    abstract fun getLayoutRes():Int
    abstract fun getViewModel() :Class<viewModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding=DataBindingUtil.setContentView(this,getLayoutRes())
        viewModel = ViewModelProviders.of(this).get(getViewModel())
    }

}