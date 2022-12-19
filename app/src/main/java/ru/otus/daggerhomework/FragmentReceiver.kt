package ru.otus.daggerhomework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.dagger.DaggerFragmentReceiverComponent
import ru.otus.daggerhomework.dagger.FragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {
    lateinit var fragmentComponent: FragmentReceiverComponent
    private lateinit var frame: View
    @Inject
    lateinit var recViewModel:ViewModelReceiver

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentComponent = DaggerFragmentReceiverComponent.builder()
            .activity((requireActivity() as MainActivity).mainComponent!!).fragment(this)
            .build()
        fragmentComponent.inject(this)
        return inflater.inflate(R.layout.fragment_b, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        frame = view.findViewById(R.id.frame)
        recViewModel.observeColors().observe(viewLifecycleOwner){
            populateColor(it)
        }
    }
    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}