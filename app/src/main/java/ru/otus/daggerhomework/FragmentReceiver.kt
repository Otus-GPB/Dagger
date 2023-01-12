package ru.otus.daggerhomework

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorInt
import androidx.fragment.app.Fragment
import ru.otus.daggerhomework.dagger.DaggerFragmentReceiverComponent
import javax.inject.Inject

class FragmentReceiver : Fragment() {
    private lateinit var frame: View
    @Inject
    lateinit var recViewModel: InterfaceVMReceiver
    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerFragmentReceiverComponent.builder()
            .activity((requireActivity() as MainActivity).mainComponent!!).fragment(this)
            .build()
            .inject(this)
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
        recViewModel.observeColors().observe(viewLifecycleOwner){
            populateColor(it)
        }
    }
    fun populateColor(@ColorInt color: Int) {
        frame.setBackgroundColor(color)
    }
}