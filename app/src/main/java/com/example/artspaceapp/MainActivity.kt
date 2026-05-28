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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    var artImageIndex by remember { mutableIntStateOf(0) }
    val artImageArray = remember {  mutableListOf<Int>(
        R.drawable.dress_1943_8_2691,
        R.drawable.isabella_clara_eugenie_of_austria_spain_and_countess_of_flanders_1950_14_697,
        R.drawable.elizabeth_1950_14_395,
        R.drawable.a_street_tunis_2021_34_6,
        R.drawable.basement_of_urban_house_1910_1947_1_14,
        R.drawable.bulto_of_santiago_1943_8_1641,
        R.drawable.buzz_aldrin_poses_with_flag_2018_177_26,
        R.drawable.cigar_store_indian_1943_8_10000,
        R.drawable.ferdinand_ii_roman_emperor_1950_14_463,
        R.drawable.john_calvin_1950_14_252) }

    val artTitleArray = arrayOf(
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

    val artDescriptionArray = arrayOf(
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

 //val teste : List<List<Int>> = listOf(listOf(R.drawable.dress_1943_8_2691, R.string.dress, R.string.dress_description),
  //   listOf())
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
        Image(
            painter = painterResource(artImageArray[artImageIndex]),
            contentDescription = null,
            modifier = Modifier.border(
                width = 32.dp,
                color = Color.White
            )
        )
        Spacer(modifier = Modifier.height(72.dp))
        Column(modifier = Modifier
                .background(color = Color.LightGray)
                .padding(start = 32.dp, end = 32.dp)
        ){
            Text(
                stringResource(artTitleArray[artImageIndex]),
                fontSize = 24.sp,
                fontStyle = FontStyle.Normal,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                stringResource(artDescriptionArray[artImageIndex]),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row (horizontalArrangement = Arrangement.spacedBy(16.dp)) {

            Button(onClick = {

                if (artImageIndex in 9 downTo 0 && artImageIndex > 0) {
                    artImageIndex--
                }
                else {
                    artImageIndex = 9 // se quiser que trave, tira esse

                    //ideia plus master - popup indicando para avancar
                }
            },
                modifier = Modifier.weight(1f)
                    .padding(16.dp)){
                Text(text = stringResource(R.string.previous))
            }

            Button(onClick = {
                if (artImageIndex >= 0 && artImageIndex <= artImageArray.size-2) {
                    artImageIndex++ }
                else {
                    artImageIndex = 0 //se quiser que trave, tira esse

                // ideia plus master - popup indicando para retornar
                }
            },
                modifier = Modifier.weight(1f)
                    .padding(16.dp)

            ){
                Text(text = stringResource(R.string.next))
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