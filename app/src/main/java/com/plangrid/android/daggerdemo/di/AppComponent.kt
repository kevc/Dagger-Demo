package com.plangrid.android.daggerdemo.di

import com.plangrid.android.domain.MainComponent
import dagger.BindsInstance
import dagger.Component
import java.util.concurrent.TimeUnit

@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {

    // MainComponent is the only Subcomponent for AppComponent
    // It is the bridge between the AppScope and individual feature scopes
    val mainComponent: MainComponent

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance period: Long,
            @BindsInstance timeUnit: TimeUnit
        )
    }
}
