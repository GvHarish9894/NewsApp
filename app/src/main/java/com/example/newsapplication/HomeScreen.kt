package com.example.newsapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapplication.HomeScreen.profile
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager

@Composable
fun HomeScreen() {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                title = {},
                backgroundColor = colorResource(id = R.color.hue),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_menu),
                            contentDescription = "Menu Icon",
                            tint = Color.White
                        )

                    }
                },
                actions = {
                    Image(
                        painter = painterResource(id = profile.random()),
                        contentDescription = "Profile Icon",
                        modifier = Modifier.padding(10.dp)
                    )


                }

            )
        },
        drawerContent = {},
        content = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(color = colorResource(id = R.color.hue))
            ) {
                Search()
                Pager()
            }

        }
    )
}

@Composable
fun DrawerView() {

}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun Pager() {
    HorizontalPager(
        count = 10,
    ) { page ->
        HoverCard()
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HoverCard() {
    Box(
        modifier = Modifier
            .height(250.dp)
            .width(300.dp),
    ) {
        Card(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp)),
            elevation = 10.dp
        ) {
            Image(
                painter = painterResource(id = R.drawable.sample_image_1),
                contentDescription = "Sample",
                contentScale = ContentScale.FillBounds
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "5h Hours Ago",
                color = Color.White,
                textAlign = TextAlign.Left
            )

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .clip(RoundedCornerShape(5.dp))
                    .padding(horizontal = 10.dp)
                    .align(Alignment.CenterVertically)
                    .width(24.dp)
                    .height(24.dp),
            ) {
                Icon(Icons.Filled.Bookmark, contentDescription = "voice search", tint = Color.White)

            }

        }

    }


}

@Composable
fun Search() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Row(
        modifier = Modifier
            .padding(20.dp)
            .height(52.dp)
            .fillMaxWidth()
    ) {
        TextField(
            value = text,
            onValueChange = { TextFieldValue ->
                text = TextFieldValue
            },
            placeholder = { Text(text = "Search Your News Here") },
            keyboardOptions = KeyboardOptions(
                autoCorrect = true,
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Search, keyboardType = KeyboardType.Text
            ),
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Search, contentDescription = "Search Icon")

                }
            },
            singleLine = true,
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .fillMaxWidth()
                .weight(1f),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = colorResource(id = R.color.hue_lite),
                placeholderColor = colorResource(id = R.color.text_color),
                textColor = colorResource(id = R.color.text_color),
                focusedIndicatorColor = Color.Transparent,
                cursorColor = colorResource(id = R.color.text_color)
            )
        )
        IconButton(
            onClick = { /*TODO*/ }, modifier = Modifier
                .clip(RoundedCornerShape(35.dp))
                .padding(horizontal = 10.dp)
                .background(color = colorResource(id = R.color.hue_lite))
                .fillMaxHeight()
                .align(Alignment.CenterVertically)

        ) {
            Icon(Icons.Filled.Mic, contentDescription = "voice search", tint = Color.White)

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreviewHome() {
//    Pager()
    HomeScreen()
//    Search()
}

object HomeScreen {
    val profile: List<Int> = listOf(
        R.drawable.ic_asset_1, R.drawable.ic_asset_2,
        R.drawable.ic_asset_3, R.drawable.ic_asset_4,
        R.drawable.ic_asset_5, R.drawable.ic_asset_6
    )

}