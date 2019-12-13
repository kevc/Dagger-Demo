package com.plangrid.android.domain

import io.reactivex.Flowable

interface TimedEmitter {
    fun emissions(): Flowable<Unit>
}
