package com.plangrid.android.randomint

import com.plangrid.android.domain.TimedEmitter
import io.reactivex.Flowable
import javax.inject.Inject
import kotlin.random.Random

class RandomIntRepo @Inject constructor(
    private val timedEmitter: TimedEmitter,
    private val random: Random
) {

    fun randomIntegers(): Flowable<Int> {
        return timedEmitter.emissions()
            .map { random.nextInt() }
    }
}
