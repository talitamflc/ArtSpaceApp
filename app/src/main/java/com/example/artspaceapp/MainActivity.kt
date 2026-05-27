package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtSpaceApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
 ArtSpaceScreenStatic()
}

@Composable
fun ArtSpaceScreenStatic(){
    //logic here
    var artImage = R.drawable.dress_1943_8_2691
    var artImageArray = arrayOf(
        R.drawable.dress_1943_8_2691,
        R.drawable.isabella_clara_eugenie_of_austria_spain_and_countess_of_flanders_1950_14_697,
        R.drawable.elizabeth_1950_14_395,
        R.drawable.a_street_tunis_2021_34_6,
        R.drawable.basement_of_urban_house_1910_1947_1_14,
        R.drawable.bulto_of_santiago_1943_8_1641,
        R.drawable.buzz_aldrin_poses_with_flag_2018_177_26,
        R.drawable.cigar_store_indian_1943_8_10000,
        R.drawable.ferdinand_ii_roman_emperor_1950_14_463,
        R.drawable.john_calvin_1950_14_252)

    var artTitle = R.string.dress
    var artTitleArray = arrayOf(
        R.string.dress,
        R.string.isabella,
        R.string.elizabeth,
        R.string.street,
        R.string.basement,
        R.string.bulto,
        R.string.buzz,
        R.string.cigar,
        R.string.ferdinand,
        R.string.calvin)


    var artDescription = R.string.dress_description
    var artDescriptionArray = arrayOf(
        R.string.dress_description,
        R.string.isabella_description,
        R.string.elizabeth_description,
        R.string.street_description,
        R.string.basement_description,
        R.string.bulto_description,
        R.string.buzz_description,
        R.string.cigar_description,
        R.string.ferdinand_description,
        R.string.calvin_description)


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
        ) {
        Image(
            painter = painterResource(artImage),
            contentDescription = null,
            modifier = Modifier.border(
                width = 32.dp,
                color = Color.White
            )
        )
        Spacer(modifier = Modifier.height(72.dp))
        Column(
            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(start = 32.dp, end = 32.dp)
        ){
            Text(
                stringResource(artTitle),
                fontSize = 24.sp,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                stringResource(artDescription),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row (horizontalArrangement = Arrangement.Center) {
            Button(onClick = {/*ainda vou construir*/},
                modifier = Modifier.padding(end = 32.dp)){
                Text(text = "    Previous    ")
            }
            Button(onClick = {/*ainda vou construir*/}){
                Text(text = "        Next        ")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ArtSpaceScreePreview() {
    ArtSpaceAppTheme {
        ArtSpaceScreenStatic()

    }
}