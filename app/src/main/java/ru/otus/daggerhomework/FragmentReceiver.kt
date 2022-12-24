package ru.otus.daggerhomework

import android.os.Bundle
import android.view.View
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import javax.inject.Inject

class FragmentReceiver : Fragment(R.layout.fragment_b) {

    @Inject
    lateinit var viewModelReceiver: ViewModelReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerFragmentReceiverComponent.factory()
            .create((requireActivity() as MainActivity).mainActivityComponent)
            .inject(this)
    }

    private lateinit var frame: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)

        viewModelReceiver.observeColors().observe(viewLifecycleOwner) { color ->
            populateColor(color)
        }
    }

    private fun populateColor(@ColorInt color: Int) = frame.setBackgroundColor(color)
}