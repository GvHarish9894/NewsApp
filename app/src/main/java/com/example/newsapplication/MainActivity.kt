package com.example.newsapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapplication.ui.theme.NewsApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Row {
        Text(text = "Hello $name!")
        Spacer(modifier = Modifier.width(5.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_asset_1),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .background(color = Color.Red)
                .border(2.dp, MaterialTheme.colors.secondary, CircleShape)
        )
    }
}

@Composable
fun messageCard(message: Message) {
    val profileIcon: List<Int> = listOf(
        R.drawable.ic_asset_1,
        R.drawable.ic_asset_2,
        R.drawable.ic_asset_3,
        R.drawable.ic_asset_4,
        R.drawable.ic_asset_5,
        R.drawable.ic_asset_6
    )
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(profileIcon.random()),
            contentDescription = "Profile Icon",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(color = Color.Red)
                .border(2.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column() {
            Text(text = message.head)
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = message.sub,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }

    }

}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn(modifier = Modifier.fillMaxSize(1F)) {
        items(items = messages) { item ->
            messageCard(message = item)
        }
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Light Mode")
@Composable
fun DefaultPreview() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.background
    ) {
//        Greeting("Android")
//        messageCard(Message("Lilly", "Hi There"))
        Conversation(listOf(
            Message("Jonson", "How are you man?"),
            Message("sona", "Good morning"),
            Message("Rojan", "Hello Everyone"),
            Message("Suja", "Did you know ??"),
        ))
    }

}

data class Message(val head: String, val sub: String)