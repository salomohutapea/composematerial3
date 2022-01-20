package com.example.composematerial3.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.composematerial3.PuppyProvider

@Composable
fun PuppyLazyColumn() {
    val puppies = remember { PuppyProvider.puppyList }

//    https://developer.android.com/jetpack/compose/lists
    LazyColumn(
        Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            puppies.size,
            itemContent = {
                PuppyListItem(puppy = puppies[it], it + 1)
            }
        )
    }
}