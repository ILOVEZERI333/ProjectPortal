package com.example.firstcomposeproject


import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Slider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.example.firstcomposeproject.ui.theme.FirstComposeProjectTheme
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.firstcomposeproject.R.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.Shapes
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import com.example.firstcomposeproject.composables.IntroButton
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import com.example.firstcomposeproject.composables.IntroImage
import com.example.firstcomposeproject.composables.IntroText
import com.example.firstcomposeproject.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstComposeProjectTheme {
                Row (modifier = Modifier.fillMaxSize()){
                    Box(modifier = Modifier.fillMaxSize().paint(
                        painter = painterResource(id=R.drawable.newjeans_bubble_gum_kpop_members_phone_wallpaper_hd_uhdpaper_com_645_3_a),
                        contentScale = ContentScale.FillBounds

                    )){
                        Column(modifier = Modifier.padding(top = 100.dp)){
                            IntroImage()
                            IntroText()
                            IntroButton(this@MainActivity, HomeScreen() )
                        }


                    }

                }

            }
        }
    }
}


@Composable
fun DemoText(message: String, fontSize: Int){
    Text(
        text = message,
        fontSize = fontSize.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}







@Composable
fun DemoTextPreview(){
    FirstComposeProjectTheme {
        DemoText("hello world", 13)
    }
}




