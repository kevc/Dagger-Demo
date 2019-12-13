package com.plangrid.android.domain

import androidx.fragment.app.Fragment

fun Fragment.getMainComponent(): MainComponent {
    return (requireActivity().application as RootComponent).appComponent.mainComponent
}

interface RootComponent {
    val appComponent: IAppComponent
}

interface IAppComponent {
    val mainComponent: MainComponent
}
