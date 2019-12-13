package com.plangrid.android.randomuuid

import com.plangrid.android.domain.GetRandomUUID
import com.plangrid.android.domain.TimedEmitter
import dagger.Module
import dagger.Provides

@Module
object RandomUUIDModule {

    @RandomUUIDScope
    @Provides
    fun provideGetRandomUUID(): GetRandomUUID {
        return GetRandomUUID()
    }

    @RandomUUIDScope
    @Provides
    fun provideRandomUUIDRepo(
        timedEmitter: TimedEmitter,
        randomUUID: GetRandomUUID
    ): RandomUUIDRepo {
        return RandomUUIDRepo(timedEmitter, randomUUID)
    }
}
