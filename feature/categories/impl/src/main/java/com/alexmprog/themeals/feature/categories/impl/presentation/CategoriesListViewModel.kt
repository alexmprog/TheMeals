package com.alexmprog.themeals.feature.categories.impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.core.ui.state.ErrorText
import com.alexmprog.themeals.core.ui.state.UiState
import com.alexmprog.themeals.feature.categories.api.domain.model.Category
import com.alexmprog.themeals.feature.categories.api.domain.usecase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class CategoriesListViewModel @Inject constructor (
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