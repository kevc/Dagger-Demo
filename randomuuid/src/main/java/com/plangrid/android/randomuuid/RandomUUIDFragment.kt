package com.plangrid.android.randomuuid

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

class RandomUUIDFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: RandomUUIDViewModel.Factory

    lateinit var viewModel: RandomUUIDViewModel
    private val disposables = CompositeDisposable()

    private lateinit var uuidText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerRandomUUIDComponent.factory()
            .create(getMainComponent())
            .inject(this)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(RandomUUIDViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val content = inflater.inflate(R.layout.fragment_random_uuid, container, false)
        uuidText = content.findViewById(R.id.random_uuid)
        return content
    }

    override fun onResume() {
        super.onResume()
        disposables.add(
            viewModel.observeUUIDs().subscribe { uuidText.text = it }
        )
    }

    override fun onPause() {
        disposables.clear()
        super.onPause()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            RandomUUIDFragment()
    }
}
