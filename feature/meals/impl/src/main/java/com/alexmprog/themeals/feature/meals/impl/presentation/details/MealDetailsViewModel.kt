package com.alexmprog.themeals.feature.meals.impl.presentation.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.alexmprog.themeals.core.common.model.Resource
import com.alexmprog.themeals.core.ui.state.ErrorText
import com.alexmprog.themeals.core.ui.state.UiState
import com.alexmprog.themeals.feature.meals.api.MealDetailsScreenRoute
import com.alexmprog.themeals.feature.meals.api.domain.usecase.GetMealDetailsUseCase
import com.alexmprog.themeals.feature.meals.api.domain.model.Meal
import com.alexmprog.themeals.feature.meals.api.domain.model.MealDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
internal class MealDetailsViewModel (
    savedStateHandle: SavedStateHandle,
    getMealDetailsUseCase: GetMealDetailsUseCase
) : ViewModel() {

    private val route: MealDetailsScreenRoute = savedStateHandle.toRoute()

    val mealState: StateFlow<Meal> = MutableStateFlow(Meal(route.id, route.name, route.image))

    val detailsState: StateFlow<UiState<MealDetails>> =
        getMealDetailsUseCase(route.id)
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
