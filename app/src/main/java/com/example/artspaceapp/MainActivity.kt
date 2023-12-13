package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                ArtSpaceUi()
            }
        }
    }
}

@Composable
fun ArtSpaceUi() {
    Column (modifier = Modifier
            .padding(horizontal = 15.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        var currentImage by remember { mutableStateOf(1) }
        var squeezeTapCount by remember { mutableStateOf(2) }

        val numImages = 9

        val step_title=when(currentImage){
            1->R.string.NYC
            2->R.string.burj_khalifa
            3->R.string.time_square
            4->R.string.big_ben
            5->R.string.holly_wood
            6->R.string.maqam_chahid
            7->R.string.tokyo
            8->R.string.nature
            else->R.string.toronto
        }
        val step_subtitle=when(currentImage){
            1->R.string.USA
            2->R.string.dubai
            3->R.string.USA
            4->R.string.UK
            5->R.string.USA
            6->R.string.dz
            7->R.string.japan
            8->R.string.switzerland
            else->R.string.canada
        }
        val step_image=when(currentImage){
            1->R.drawable.nyc
            2->R.drawable.burj_khalifa
            3->R.drawable.time_square
            4->R.drawable.big_ben
            5->R.drawable.hollywood
            6->R.drawable.maqam_chahid
            7->R.drawable.tokyo
            8->R.drawable.switzerland
            else->R.drawable.toronto
        }

        Surface(
           shadowElevation = 8.dp,
            color = Color.White,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(step_image),
                contentDescription = " ",
                contentScale= ContentScale.Crop,
                modifier = Modifier.size(300.dp)
                    .fillMaxSize()
                    .padding(24.dp),
            )
        }
        Spacer(
            modifier = Modifier.size(60.dp)
        )
        Surface(
            color = Color(0xFFcfd8ff)
        ) {
            Column(
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .fillMaxWidth()
            ){
                Text(
                    text = stringResource(step_title),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(
                    modifier = Modifier.size(8.dp)
                )
                Text(
                    text = stringResource(step_subtitle),
                    fontSize = 16.sp,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)

                )
            }
        }
        Spacer(
            modifier = Modifier.size(24.dp)
        )
        Row(
            modifier = Modifier.padding(bottom = 23.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = Color(0xff3254db),
            ) {
                Text(
                    text = "Previous",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .clickable {
                            when(currentImage){
                                in 1..<numImages ->{
                                    currentImage++
                                }
                                numImages->{
                                    currentImage=1
                                }
                            }
                        }
                        .padding(
                            vertical =8.dp,
                            horizontal = 34.dp
                        )

                )
            }
            Spacer(
                modifier = Modifier.size(30.dp)
            )
            Surface(
                shape = RoundedCornerShape(20.dp),
                color = Color(0xff3254db)
            ) {
                Text(

                    text = "Next",
                    fontSize = 16.sp,
                    modifier = Modifier
                        .clickable {
                            when(currentImage) {
                                1 -> {
                                    currentImage = numImages
                                }
                                in 2..numImages-> {
                                    currentImage--
                                }
                            }
                        }
                        .padding(
                            vertical = 8.dp,
                            horizontal = 46.dp
                        )
                )
            }
        }
    }
}

@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpaceUi()
    }
}