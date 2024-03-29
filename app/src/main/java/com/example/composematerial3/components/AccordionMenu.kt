package com.example.composematerial3.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composematerial3.R
import com.example.composematerial3.ui.theme.ShapesABC

@ExperimentalMaterialApi
@Composable
fun AccordionMenu(
    header: String,
    content: String,
    bgColor: Color = MaterialTheme.colorScheme.primaryContainer,
    headerColor: Color = MaterialTheme.colorScheme.inverseSurface,
    contentColor: Color = MaterialTheme.colorScheme.inverseSurface,
    arrowColor: Color = Color.Black,
    firstExpanded: Boolean = false
) {

    var expanded by remember { mutableStateOf(firstExpanded) }

    // Card is still experimental
    Card(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .padding(16.dp)
        .animateContentSize(),
        backgroundColor = bgColor,
        shape = ShapesABC.medium,
        onClick = {
            expanded = !expanded
        }) {
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {
            val (outerText, insideText, arrow) = createRefs()

            if (expanded) Text(text = content,
                color = contentColor,
                modifier = Modifier.constrainAs(insideText) {
                    top.linkTo(outerText.bottom, margin = 12.dp)
                    start.linkTo(outerText.start)
                })

            Icon(
//                 Not Recommended
//                Icons.Filled.KeyboardArrowDown,
                painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                contentDescription = "Arrow icon",
                modifier = Modifier.constrainAs(arrow) {
                    end.linkTo(parent.end)
                    centerVerticallyTo(outerText)
                },
                tint = arrowColor
            )

            Text(
                text = header, color = headerColor, modifier = Modifier.constrainAs(outerText) {
                    top.linkTo(parent.top)
                }, style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun AccordionPreview() {
    Column {
        AccordionMenu(
            header = "Header",
            content = "Content \nContent \nContent \nContent",
            firstExpanded = true
        )
        AccordionMenu(
            header = "Header",
            content = "Content \nContent \nContent \nContent",
            firstExpanded = false
        )
    }
}