package ru.otus.daggerhomework

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    @ApplicationContext
    lateinit var appContext: Context

    private val _uiState = MutableStateFlow<AppUiState>(AppUiState.ColorChangeEvent(0))
    val uiState: StateFlow<AppUiState> = _uiState

    lateinit var mainActivityComponent: MainActivityComponent
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityComponent = SingleApplicationComponent
            .getInstance()
            .mainActivityComponentFactory()
            .create(uiState, _uiState, this)
        mainActivityComponent.inject(this)
    }
}