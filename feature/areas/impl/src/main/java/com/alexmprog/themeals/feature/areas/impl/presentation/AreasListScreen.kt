package com.alexmprog.themeals.feature.areas.impl.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alexmprog.thecocktails.core.ui.components.LoadingView
import com.alexmprog.themeals.core.ui.components.ErrorView
import com.alexmprog.themeals.core.ui.components.OutlinedTextItem
import com.alexmprog.themeals.core.ui.state.UiState
import com.alexmprog.themeals.feature.area.api.domain.model.Area
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun AreasListScreen(
    viewModel: AreasListViewModel = koinViewModel(),
    modifier: Modifier = Modifier,
    onAreaClick: (Area) -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    AreasListScreen(uiState, modifier, onAreaClick)
}

@Composable
internal fun AreasListScreen(
    uiState: UiState<List<Area>>,
    modifier: Modifier = Modifier,
    onAreaClick: (Area) -> Unit
) {
    Surface(modifier) {
        when (uiState) {
            is UiState.Loading -> LoadingView()
            is UiState.Error -> ErrorView(uiState.error, {})
            is UiState.Success -> AreasList(uiState.data, onAreaClick)
        }
    }
}

@Composable
internal fun AreasList(
    items: List<Area>, onAreaClick: (Area) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items, key = { it.name }) {
            OutlinedTextItem(modifier = Modifier.animateItem(), title = it.name) {
                onAreaClick(it)
            }
        }
    }
}


@Preview
@Composable
private fun AreasListScreenPreview() {
    AreasListScreen(
        UiState.Success(listOf(Area("Russian"), Area("Canadian"))),
        Modifier.fillMaxWidth(), {})
}


