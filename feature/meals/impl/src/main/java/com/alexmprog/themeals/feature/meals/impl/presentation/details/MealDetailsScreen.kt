package com.alexmprog.themeals.feature.meals.impl.presentation.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alexmprog.thecocktails.core.ui.components.LoadingView
import com.alexmprog.themeals.core.ui.components.ErrorView
import com.alexmprog.themeals.core.ui.state.UiState
import com.alexmprog.themeals.feature.meals.api.domain.Meal
import com.alexmprog.themeals.feature.meals.api.domain.MealDetails
import com.alexmprog.themeals.feature.meals.impl.R
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun MealsDetailsScreen(
    viewModel: MealDetailsViewModel = koinViewModel(),
    modifier: Modifier = Modifier
) {
    val meal by viewModel.mealState.collectAsStateWithLifecycle()
    val detailsState by viewModel.detailsState.collectAsStateWithLifecycle()
    MealsDetailsScreen(meal, detailsState, modifier)
}

@Composable
internal fun MealsDetailsScreen(
    meal: Meal,
    detailsState: UiState<MealDetails>,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Surface(modifier) {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(meal.image)
                    .crossfade(true)
                    .build(),
                contentDescription = meal.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )
            when (detailsState) {
                is UiState.Loading -> LoadingView()
                is UiState.Error -> ErrorView(detailsState.error, {})
                is UiState.Success -> MealDetails(detailsState.data)
            }
        }
    }

}

@Composable
internal fun ColumnScope.MealDetails(details: MealDetails) {
    Text(
        stringResource(
            R.string.feature_meals_impl_category_template,
            details.category
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        textAlign = TextAlign.Start
    )
    Text(
        stringResource(
            R.string.feature_meals_impl_area_template,
            details.area
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        textAlign = TextAlign.Start
    )
    Text(
        stringResource(
            R.string.feature_meals_impl_instructions_template,
            details.description
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        textAlign = TextAlign.Start
    )
    Text(
        stringResource(R.string.feature_meals_impl_ingredients),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp,2.dp),
        textAlign = TextAlign.Start
    )
    details.measuredIngredients.forEach {
        Text(
            "${it.first} ${it.second}",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp,2.dp),
            textAlign = TextAlign.Start
        )
    }
}