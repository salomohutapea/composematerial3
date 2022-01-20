package com.example.composematerial3.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.composematerial3.Puppy

@Composable
fun PuppyListItem(puppy: Puppy) {
    val context = LocalContext.current

    Log.d("PUPPIES", "${puppy.id} Showed")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Toast
                    .makeText(context, "Hi ${puppy.title} !", Toast.LENGTH_SHORT)
                    .show()
            },
    ) {
        PuppyImage(puppy)
        Column(Modifier.align(Alignment.CenterVertically)) {
            Text(
                text = puppy.title,
                style = typography.headlineSmall,
                color = colorScheme.primary
            )
            Text(
                text = "Puppy ${puppy.id}", style = typography.bodyMedium,
                color = colorScheme.primary
            )
        }
    }
}

@Composable
private fun PuppyImage(puppy: Puppy) {
    Image(
        painter = painterResource(id = puppy.puppyImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}