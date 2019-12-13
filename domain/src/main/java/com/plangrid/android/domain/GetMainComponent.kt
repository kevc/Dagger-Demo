package com.plangrid.android.domain

import androidx.fragment.app.Fragment

fun Fragment.getMainComponent(): MainComponent {
    return (requireActivity().application as IAppComponent).mainComponent
}

interface IAppComponent {
    val mainComponent: MainComponent
}
