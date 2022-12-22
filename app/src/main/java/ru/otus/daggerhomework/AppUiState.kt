package ru.otus.daggerhomework

sealed class AppUiState {
    data class ColorChangeEvent(val color: Int): AppUiState()
}