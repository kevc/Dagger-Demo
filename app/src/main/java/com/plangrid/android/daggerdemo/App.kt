package com.plangrid.android.daggerdemo

import android.app.Application
import com.plangrid.android.daggerdemo.di.AppComponent
import com.plangrid.android.daggerdemo.di.DaggerAppComponent
import com.plangrid.android.domain.RootComponent
import java.util.concurrent.TimeUnit

class App : Application(), RootComponent {

    override val appComponent: AppComponent =
        DaggerAppComponent
            .factory()
            .create(TimeUnit.SECONDS)
}
