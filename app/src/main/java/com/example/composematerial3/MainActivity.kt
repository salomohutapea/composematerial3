package com.example.composematerial3

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composematerial3.components.AccordionMenu
import com.example.composematerial3.components.AnimateBoxColor
import com.example.composematerial3.components.PuppyLazyColumn
import com.example.composematerial3.ui.theme.AppTheme

@ExperimentalMaterialApi
@RequiresApi(Build.VERSION_CODES.S)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent()
        }
    }
}

@ExperimentalMaterialApi
@RequiresApi(Build.VERSION_CODES.S)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MainActivityContent() {
    AppTheme {
        Greeting("Everyone")
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .padding(top = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimateBoxColor(
                MaterialTheme.colorScheme.primary,
                MaterialTheme.colorScheme.inversePrimary
            )

            Spacer(Modifier.height(32.dp))

            AccordionMenu(
                header = stringResource(id = R.string.lorem_header),
                content = generateLoremIpsum(20)
            )
            PuppyLazyColumn()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        style = MaterialTheme.typography.headlineMedium,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun PaddingExample() {
    Text(
        text = "Hello World!",
        color = Color.Black,
        modifier = Modifier
            .padding(8.dp) // space between the borders
            .border(2.dp, Color.Green) // inner border
            .padding(8.dp) // padding
            .border(2.dp, Color.Black) // outer border
            .padding(8.dp) // margin
    )
}