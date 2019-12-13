package com.plangrid.android.randomuuid

import com.plangrid.android.domain.GetRandomUUID
import com.plangrid.android.domain.TimedEmitter
import io.reactivex.Flowable
import javax.inject.Inject

class RandomUUIDRepo @Inject constructor(
    private val timedEmitter: TimedEmitter,
    private val getRandomUUID: GetRandomUUID
) {

    fun randomIntegers(): Flowable<String> {
        return timedEmitter.emissions()
            .map { getRandomUUID.getRandomUUID().toString() }
    }
}
