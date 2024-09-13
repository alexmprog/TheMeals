package com.alexmprog.themeals.feature.meals.impl.presentation.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
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
    modifier: Modifier = Modifier,
    onYoutubeClick: (String) -> Unit
) {
    val meal by viewModel.mealState.collectAsStateWithLifecycle()
    val detailsState by viewModel.detailsState.collectAsStateWithLifecycle()
    MealsDetailsScreen(meal, detailsState, modifier, onYoutubeClick)
}

@Composable
internal fun MealsDetailsScreen(
    meal: Meal,
    detailsState: UiState<MealDetails>,
    modifier: Modifier = Modifier,
    onYoutubeClick: (String) -> Unit
) {
    val scrollState = rememberScrollState()
    Surface(modifier) {
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
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
                is UiState.Success -> MealDetails(meal.name, detailsState.data, onYoutubeClick)
            }
        }
    }

}

@Composable
internal fun ColumnScope.MealDetails(
    name: String,
    details: MealDetails,
    onYoutubeClick: (String) -> Unit
) {
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append(stringResource(R.string.feature_meals_impl_name))
            }
            append(" $name")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 2.dp),
        textAlign = TextAlign.Start
    )
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append(stringResource(R.string.feature_meals_impl_category))
            }
            append(" ${details.category}")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 2.dp),
        textAlign = TextAlign.Start
    )
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append(stringResource(R.string.feature_meals_impl_area))
            }
            append(" ${details.area}")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 2.dp),
        textAlign = TextAlign.Start
    )
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append(stringResource(R.string.feature_meals_impl_instructions))
            }
            append(" ${details.description}")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 2.dp),
        textAlign = TextAlign.Start
    )
    if (!details.youtubeUrl.isNullOrEmpty()) {
        Button(modifier = Modifier.padding(8.dp, 2.dp),
            onClick = { onYoutubeClick(details.youtubeUrl!!) }) {
            Text(stringResource(R.string.feature_meals_impl_youtube))
        }
    }
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                append(stringResource(R.string.feature_meals_impl_ingredients))
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 2.dp),
        textAlign = TextAlign.Start
    )
    details.measuredIngredients.forEach {
        Text(
            it,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 2.dp),
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Start
        )
    }
}