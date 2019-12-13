package com.plangrid.android.randomint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.plangrid.android.domain.getMainComponent
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class RandomIntFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: RandomIntViewModel.Factory

    private lateinit var viewModel: RandomIntViewModel

    private val disposables = CompositeDisposable()

    private lateinit var integerText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerRandomIntComponent.factory()
            .create(getMainComponent())
            .inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(RandomIntViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val content = inflater.inflate(R.layout.fragment_random_int, container, false)

        integerText = content.findViewById(R.id.integer_text)

        return content
    }


    override fun onResume() {
        super.onResume()
        disposables.add(
            viewModel.observeIntegers().subscribe {
                integerText.text = it
            }
        )
    }

    override fun onPause() {
        disposables.clear()
        super.onPause()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            RandomIntFragment()
    }
}
