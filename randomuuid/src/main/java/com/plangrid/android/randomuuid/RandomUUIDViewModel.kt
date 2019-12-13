package com.plangrid.android.randomuuid

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class RandomUUIDViewModel(private val repo: RandomUUIDRepo) : ViewModel() {

    fun observeUUIDs(): Flowable<String> {
        return repo
            .randomUUIDs()
            .map { it.toString() }
            .observeOn(AndroidSchedulers.mainThread())
    }

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val repo: RandomUUIDRepo
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RandomUUIDViewModel(repo) as T
        }
    }
}
