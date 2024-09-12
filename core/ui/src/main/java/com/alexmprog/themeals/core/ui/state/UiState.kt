package com.alexmprog.themeals.core.ui.state

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class UiState<out T> {
    data object Loading : UiState<Nothing>()
    data class Error<T>(val error: ErrorText) : UiState<T>()
    data class Success<T>(val data: T) : UiState<T>()
}

sealed class ErrorText {
    class StringResource(@StringRes val id: Int): ErrorText()

    @Composable
    fun asString() = when(this) {
        is StringResource -> stringResource(id)
    }
}
