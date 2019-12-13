package com.plangrid.android.randomint

import com.plangrid.android.domain.MainComponent
import dagger.Component

@RandomIntScope
@Component(
    dependencies = [MainComponent::class],
    modules = [RandomIntModule::class]

)
interface RandomIntComponent {

    fun inject(fragment: RandomIntFragment)

    @Component.Factory
    interface Factory {
        fun create(mainComponent: MainComponent): RandomIntComponent
    }
}
