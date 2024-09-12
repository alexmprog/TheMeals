package com.alexmprog.themeals.feature.categories.impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.core.ui.state.ErrorText
import com.alexmprog.themeals.core.ui.state.UiState
import com.alexmprog.themeals.feature.categories.api.domain.Category
import com.alexmprog.themeals.feature.categories.api.domain.GetCategoriesUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
internal class CategoriesListViewModel (
    getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    val uiState: StateFlow<UiState<List<Category>>> = getCategoriesUseCase()
        .map {
            when (it) {
                is Resource.Success -> UiState.Success(it.data)
                is Resource.Error -> UiState.Error(
                    ErrorText.StringResource(com.alexmprog.themeals.core.ui.R.string.core_ui_network_error)
                )
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UiState.Loading,
        )
}