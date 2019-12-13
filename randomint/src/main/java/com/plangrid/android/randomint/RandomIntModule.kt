package com.plangrid.android.randomint

import com.plangrid.android.domain.TimedEmitter
import dagger.Module
import dagger.Provides
import kotlin.random.Random

@Module
object RandomIntModule {

    @RandomIntScope
    @Provides
    fun provideRandom(): Random {
        return Random(100)
    }

    @RandomIntScope
    @Provides
    fun provideRandomIntRepo(
        timedEmitter: TimedEmitter,
        random: Random
    ): RandomIntRepo {
        return RandomIntRepo(timedEmitter, random)
    }
}
