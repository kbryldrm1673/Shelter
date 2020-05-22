package com.kubra.koubitirme.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

abstract class BaseFragment<dataBinding: ViewDataBinding,viewModel :ViewModel>: Fragment() {

    lateinit var dataBinding : dataBinding
    lateinit var viewModel : viewModel



    @LayoutRes
    abstract fun getLayoutRes():Int

    abstract fun getViewModel():Class<viewModel>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(getViewModel())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding=DataBindingUtil.inflate(inflater,getLayoutRes(),container,false)
        return dataBinding.root
    }


}