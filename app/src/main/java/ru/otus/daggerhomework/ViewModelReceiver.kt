package ru.otus.daggerhomework

import android.app.Application
import android.content.Context
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ViewModelReceiver @Inject constructor(
    @UiState private val uiState: StateFlow<AppUiState>,
    @ApplicationContext private val context: Context
) {
    suspend fun observeColors(collector: FlowCollector<AppUiState>) {
        if (context !is Application) throw RuntimeException("Здесь нужен контекст апликейшена")
        uiState.collect(collector)
    }
}