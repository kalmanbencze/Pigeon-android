package com.android.messaging.presentation

import android.databinding.ViewDataBinding
import com.android.messaging.BR
import com.android.messaging.presentation.databinding.SingleLiveEvent

/**
 * Created by kalmanb on 9/6/17.
 */
class ClickableBindingAdapter<T> constructor(private val itemListener: SingleLiveEvent<T>) : me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter<T>() {
    override fun onBindBinding(binding: ViewDataBinding?, variableId: Int, layoutRes: Int, position: Int, item: T) {
        super.onBindBinding(binding, variableId, layoutRes, position, item)
        itemBinding.bindExtra(BR.listener, itemListener)
    }

    companion object {
        val TAG = "ClickableBindingAdapter"
    }
}
