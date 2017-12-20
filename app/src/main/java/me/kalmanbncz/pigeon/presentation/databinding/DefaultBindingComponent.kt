package me.kalmanbncz.pigeon.presentation.databinding

import android.databinding.DataBindingComponent

/**
 * Created by kalman.bencze on 01/11/2017.
 */
class DefaultBindingComponent : DataBindingComponent {
    private var bindingAdapter = DefaultBindingAdapter()
    override fun getDefaultBindingAdapter(): DefaultBindingAdapter {
        return bindingAdapter
    }

}