package com.plangrid.android.daggerdemo.di

import com.plangrid.android.domain.TimedEmitter
import dagger.Module
import dagger.Provides
import io.reactivex.Flowable
import java.util.concurrent.TimeUnit

@Module
object AppModule {

    @AppScope
    @Provides
    fun provideTimedEmitter(
        period: Long,
        timeUnit: TimeUnit
    ): TimedEmitter {
        return object : TimedEmitter {
            override fun emissions(): Flowable<Unit> {
                return Flowable.interval(period, timeUnit).map { Unit }
            }
        }
    }
}
