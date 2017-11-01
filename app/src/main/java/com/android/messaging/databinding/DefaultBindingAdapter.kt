package com.android.messaging.databinding

import android.databinding.BindingAdapter
import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import android.support.v7.widget.SwitchCompat
import android.text.Spannable
import android.text.SpannableString
import android.view.View
import android.widget.CompoundButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.signature.StringSignature

/**
 * Created by kalmanb on 8/29/17.
 */
class DefaultBindingAdapter {

    @BindingAdapter("android:text")
    fun setText(view: TextView, text: String?) {
        if (text == null) {
            return
        }
        view.text = text
    }

    @BindingAdapter("android:text")
    fun setText(view: TextView, @StringRes resId: Int) {
        if (resId == -1) {
            return
        }
        view.setText(resId)
    }

    @BindingAdapter("android:text")
    fun setText(view: TextView, text: Spannable?) {
        if (text == null) {
            return
        }
        view.text = text
    }

    @BindingAdapter("android:text")
    fun setText(view: TextView, text: SpannableString?) {
        if (text == null) {
            return
        }
        view.text = text
    }

    @BindingAdapter("android:textColor")
    fun setTextColor(view: TextView, @ColorRes color: Int) {
        if (color == -1) {
            view.visibility = View.GONE
        } else {
            view.visibility = View.VISIBLE
            view.setTextColor(view.context.resources.getColor(color))
        }
    }

    @BindingAdapter("profilePicture")
    fun loadImage(view: ImageView, url: String?) {
        if (url == null) {
            return
        }
        Glide.with(view.context)
                .load(url)
                .centerCrop()
                .priority(Priority.IMMEDIATE)
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .skipMemoryCache(false)
                .signature(StringSignature(url))
                //        .placeholder(R.drawable.vector_profile_placeholder)
                //        .error(R.drawable.vector_profile_placeholder)
                .into(view)
    }

    @BindingAdapter("onToggle")
    fun onToggleChecked(view: SwitchCompat, listener: CompoundButton.OnCheckedChangeListener) {
        view.setOnCheckedChangeListener(listener)
    }
}
