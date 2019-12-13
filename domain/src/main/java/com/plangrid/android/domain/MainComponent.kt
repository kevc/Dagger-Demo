package com.plangrid.android.domain

import dagger.Subcomponent

@Subcomponent
interface MainComponent {
    val timedEmitter: TimedEmitter
}
