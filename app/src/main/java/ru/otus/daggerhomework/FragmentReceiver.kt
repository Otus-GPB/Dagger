package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import javax.inject.Inject

class FragmentReceiver : Fragment() {

    private lateinit var frame: View
    lateinit var fragmentReceiverComponent: FragmentReceiverComponent

    @Inject
    lateinit var viewModelReceiver: ViewModelReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentReceiverComponent = DaggerFragmentReceiverComponent
            .factory()
            .create(activityComponent = (requireActivity() as MainActivity).mainActivityComponent)
        fragmentReceiverComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)

        viewModelReceiver.observeColors().observe(viewLifecycleOwner) { color ->
            populateColor(color)
        }
    }

    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}
