package com.alexmprog.themeals.core.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun OutlinedTextItem(modifier: Modifier, title: String, onClick: () -> Unit) {
    OutlinedCard(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentSize()
            .clickable { onClick() }
    ) {
        Text(
            text = title,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            textAlign = TextAlign.Start,
        )
    }
}