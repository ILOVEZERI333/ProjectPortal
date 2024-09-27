package com.example.firstcomposeproject.composables

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcomposeproject.MainActivity
import com.example.firstcomposeproject.R
import kotlinx.coroutines.delay


@Composable
fun IntroButton(activity: ComponentActivity, homeActivity: Activity){

    var imageOpacity = remember {
        Animatable(0.0f)
    }



    LaunchedEffect(key1 = false) {


        imageOpacity.animateTo(
            targetValue = 1.0f,
            tween(durationMillis = 1500, easing = LinearOutSlowInEasing, delayMillis = 1000),

            )


    }


    Row(modifier = Modifier.fillMaxWidth().alpha(imageOpacity.value), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
        Button(onClick = {
            val intent = Intent(activity, homeActivity::class.java)
            activity.startActivity(intent)
        },
        shape = RoundedCornerShape(70f), colors = ButtonDefaults.buttonColors(Color(188, 230, 227), Color.Black)) { Text("Enter", fontSize = 43.sp) }
    }

}



@Composable
fun IntroText(){

    var imageOpacity = remember {
        Animatable(0.0f)
    }



    LaunchedEffect(key1 = false) {


        imageOpacity.animateTo(
            targetValue = 1.0f,
            tween(durationMillis = 1500, easing = LinearOutSlowInEasing, delayMillis = 500),

        )


    }

    Row(modifier = Modifier.fillMaxWidth().padding(top = 20.dp, bottom = 15.dp).alpha(imageOpacity.value), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
        Text("Welcome!", fontSize = 46.sp)
    }
}


@Composable
fun IntroImage(){

    val image = painterResource(id=R.drawable.intro)

    var imageOpacity = remember {
        Animatable(0.0f)
    }



    LaunchedEffect(key1 = false) {


        imageOpacity.animateTo(

            targetValue = 1.0f,
            tween(durationMillis = 1500, easing = LinearOutSlowInEasing)
        )


    }



    Row(modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        Image(
            painter = image,
            "intro to app",
            modifier = Modifier
                .alpha(imageOpacity.value)
                .size(250.dp)
            ,

            )
    }

}

