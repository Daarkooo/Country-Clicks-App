package com.example.artspaceapp

import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.splineBasedDecay
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
        Surface(
           shadowElevation = 8.dp,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable._023_mercedes_benz_glc_class_suv_forward_view_carbuzz_1138364_1600),
                contentDescription = "Mercedes",
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
                    text = "Dream Car",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(
                    modifier = Modifier.size(8.dp)
                )
                Text(
                    text = "Mercedes glc",
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