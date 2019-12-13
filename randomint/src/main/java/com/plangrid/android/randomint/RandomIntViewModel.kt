package com.plangrid.android.randomint

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class RandomIntViewModel(private val repo: RandomIntRepo) : ViewModel() {

    fun observeIntegers(): Flowable<String> {
        return repo
            .randomIntegers()
            .map { it.toString() }
            .observeOn(AndroidSchedulers.mainThread())
    }

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val repo: RandomIntRepo
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RandomIntViewModel(repo) as T
        }
    }
}
