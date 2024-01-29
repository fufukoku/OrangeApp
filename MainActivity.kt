package com.example.orangejuice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.orangejuice.ui.theme.OrangeJuiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrangeJuiceTheme {
            }
        }
    }
}

@Composable
fun OrangeJuiceMake(modifier: Modifier =
                        Modifier
                            .fillMaxSize()
                            .wrapContentSize(align = Alignment.Center))
{
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally)
    {var squeezeTime by remember{ mutableStateOf(1) }
        squeezeTime = 0
        var orangeTime = 0



        Spacer(modifier = Modifier.height(60.dp))

        Button(onClick = {
            squeezeTime--;
            if (orangeTime % 4 == 2)
                squeezeTime = (5..10).random()
            if(squeezeTime == 0)
                orangeTime++
        }) {
            Text(text = "Orange")
        }
        var orangeImageID = when(orangeTime % 4){
            1 -> R.drawable.orange_tree
            2 -> R.drawable.orange_fruit
            3 -> R.drawable.orange_drink_full
            0 -> R.drawable.orange_drink_empty
            else
            -> R.drawable.orange_tree
        }
        Image(painter = painterResource(orangeImageID), contentDescription = "orange")
        when(orangeTime % 4){
            1 -> Text(text = "Pick an orange")
            2 -> Text(text = "Squeeze the orange")
            3 -> Text(text = "Drink it")
            0 -> Text(text = "Tap to start again")
        }

        Text(text = "Games count: " + orangeTime)
    }
}

@Preview(showBackground = true)
@Composable
fun OrangeJuiceMakePreview(){
    OrangeJuiceMake()
}