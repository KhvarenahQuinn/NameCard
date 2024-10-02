package com.example.NameCard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.namecard.R
import com.example.namecard.ui.theme.NameCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NameCardTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF16203C) //warna background
                ){
                    NameCard() //memanggil namecard untuk ditampilkan
                }

            }
        }
    }
}
//untuk menampilkan informasi
@Composable
fun NameCard() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(16.dp)){
        val image = painterResource(R.drawable.android_logo)
        Image(
            painter = image, contentDescription = null,
            Modifier.fillMaxWidth(0.3F)
        )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Text(
            text = stringResource(R.string.name),
            fontSize = 35.sp, color = Color.Green,
            modifier = Modifier.padding(bottom = 20.dp)
        )
        Text(
        text = stringResource(R.string.status),
            fontSize = 20.sp, color = Color.White
        )

        Spacer(
            modifier = Modifier.height(100.dp)
        )
        KRow(
            text = stringResource(R.string.phone),
            textBlur = 5.dp,
            icon = Icons.Rounded.Phone
        )
        KRow(
            text = stringResource(R.string.share),
            icon = Icons.Rounded.Share
        )
        KRow(
            text = stringResource(R.string.mail),
            icon = Icons.Rounded.Email
        )



    }
}
//KRow untuk menampilkan icon dan detail kontak
@Composable
fun KRow(
    text:String, icon:ImageVector, textBlur: Dp = 0.dp
){
    Row(
        horizontalArrangement = Arrangement.Center, modifier = Modifier.padding(16.dp)
    ){
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Green,
            modifier = Modifier.weight(1F)
        )
        Text(
            text = text, color = Color.White, modifier = Modifier
                .weight(3f)
                .blur(textBlur)
        )
    }
}
//untuk menampilkan NameCard pada fitur preview
@Preview(showBackground = true)
@Composable
fun NameCardPreview() {
    NameCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF16203C)
        ){
            NameCard()
        }

    }
}

