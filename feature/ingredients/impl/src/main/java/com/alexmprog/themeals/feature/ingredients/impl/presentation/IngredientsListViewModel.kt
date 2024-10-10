package com.alexmprog.themeals.feature.ingredients.impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.core.ui.state.ErrorText
import com.alexmprog.themeals.core.ui.state.UiState
import com.alexmprog.themeals.feature.ingredients.api.domain.usecase.GetIngredientsUseCase
import com.alexmprog.themeals.feature.ingredients.api.domain.model.Ingredient
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class IngredientsListViewModel @Inject constructor(
    getIngredientsUseCase: GetIngredientsUseCase
) : ViewModel() {

    val uiState: StateFlow<UiState<List<Ingredient>>> = getIngredientsUseCase()
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