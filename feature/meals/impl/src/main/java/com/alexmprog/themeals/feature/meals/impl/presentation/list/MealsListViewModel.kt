package com.alexmprog.themeals.feature.meals.impl.presentation.list

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.core.ui.state.ErrorText
import com.alexmprog.themeals.core.ui.state.UiState
import com.alexmprog.themeals.feature.meals.api.MealsListScreenRoute
import com.alexmprog.themeals.feature.meals.api.domain.usecase.GetMealsUseCase
import com.alexmprog.themeals.feature.meals.api.domain.model.Meal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class MealsListViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getMealsUseCase: GetMealsUseCase
) : ViewModel() {

    private val route: MealsListScreenRoute = savedStateHandle.toRoute()

    val uiState: StateFlow<UiState<List<Meal>>> = getMealsUseCase(route.id, route.source)
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