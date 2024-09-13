package com.alexmprog.themeals.feature.meals.impl.presentation.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.alexmprog.thecocktails.core.ui.components.LoadingView
import com.alexmprog.themeals.core.ui.components.ErrorView
import com.alexmprog.themeals.core.ui.state.UiState
import com.alexmprog.themeals.feature.meals.api.domain.Meal
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun MealsListScreen(
    viewModel: MealsListViewModel = koinViewModel(),
    modifier: Modifier = Modifier,
    onMealClick: (Meal) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    MealsListScreen(uiState, modifier, onMealClick)
}

@Composable
internal fun MealsListScreen(
    uiState: UiState<List<Meal>>,
    modifier: Modifier = Modifier,
    onMealClick: (Meal) -> Unit
) {
    Surface(modifier) {
        when (uiState) {
            is UiState.Loading -> LoadingView()
            is UiState.Error -> ErrorView(uiState.error, {})
            is UiState.Success -> MealsList(uiState.data, onMealClick)
        }
    }
}


@Composable
internal fun MealsList(items: List<Meal>, onMealClick: (Meal) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items, key = { it.id }) {
            OutlinedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize()
                    .animateItem()
                    .clickable { onMealClick(it) }
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(it.image)
                            .crossfade(true)
                            .build(),
                        contentDescription = it.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(50.dp)
                    )
                    Text(
                        it.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        textAlign = TextAlign.Start
                    )
                }
            }
        }
    }
}
