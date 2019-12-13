package com.plangrid.android.randomuuid

import com.plangrid.android.domain.MainComponent
import dagger.Component

@RandomUUIDScope
@Component(
    dependencies = [MainComponent::class],
    modules = [RandomUUIDModule::class]
)
interface RandomUUIDComponent {

    fun inject(fragment: RandomUUIDFragment)

    @Component.Factory
    interface Factory {
        fun create(mainComponent: MainComponent): RandomUUIDComponent
    }
}
