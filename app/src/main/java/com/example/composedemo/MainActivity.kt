package com.example.composedemo

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    ComposeDemoTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

            InnerMyApp(innerPadding)

        }
    }
}

@Composable
fun InnerMyApp(innerPadding: PaddingValues) {

    ConstraintLayout(
        modifier = Modifier.padding(innerPadding)
    ) {
        val (box, button, text) = createRefs()

        Box(
            modifier = Modifier.constrainAs(box) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {

            Log.i("TAG", "box: called")

            Text(
                text = "Hello World"
            )

        }

        Log.i("TAG", "InnerMyApp: lambda called")

        val count = remember { mutableIntStateOf(0) }

        Button(
            onClick = {
                count.intValue++
            },
            modifier = Modifier.constrainAs(button) {

                top.linkTo(box.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)

            }
        ) {

            Text(
                text = "Increment"
            )

        }

        ShowCountText(
            modifier = Modifier.constrainAs(text) {
                top.linkTo(button.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            count = count.intValue
        )

    }

}

@Composable
fun ShowCountText(modifier: Modifier = Modifier, count: Int) {

    Log.i("TAG", "show text called")

    Text(
        text = "The count is: $count",
        modifier = modifier
    )

}