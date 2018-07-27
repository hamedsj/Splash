package com.phelat.splash.utils

import android.content.Context
import android.support.annotation.LayoutRes
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by MAHDi on 6/11/18.
 * Contact me m4hdi.pdroid at gmail.com
 */

fun ViewGroup.inflate(@LayoutRes layoutId: Int, attachToParent: Boolean = false): View {
    return LayoutInflater.from(this.context).inflate(layoutId, this, attachToParent)
}

fun Context.displayMetrics(): DisplayMetrics {
    return this.resources.displayMetrics
}

fun View.displayMetrics(): DisplayMetrics {
    return this.context.displayMetrics()
}