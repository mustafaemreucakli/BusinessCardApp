package com.mustafaemreucakli.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafaemreucakli.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
        NameAndTitle(name = stringResource(R.string.user_name), title = stringResource(R.string.user_title), photo = R.drawable.photo)
        InfoCard(phoneNumber = stringResource(R.string.user_phone_number), emailAddress = stringResource(
                    R.string.user_email_address), socialMediaAddress = stringResource(R.string.user_social_media_address)
                            )
    }
}

@Composable
fun NameAndTitle(name: String, title: String, photo: Int, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(photo), contentDescription = "Personal Photo",
            modifier
                .clip(
                    CircleShape
                )
                .size(256.dp)
                .border(2.dp, Color.Gray, CircleShape))
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = name, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = title, fontSize = 24.sp)
    }
}

@Composable
fun InfoCard(phoneNumber: String, emailAddress: String, socialMediaAddress: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row() {
            Image(painter = painterResource(id = R.drawable.phone), contentDescription = "Phone Logo", Modifier.size(24.dp))
            Text(text = phoneNumber)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row() {
            Image(painter = painterResource(id = R.drawable.email), contentDescription = "Email Logo", Modifier.size(24.dp))
            Text(text = emailAddress)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row() {
            Image(painter = painterResource(id = R.drawable.instagram), contentDescription = "Instagram Logo", Modifier.size(24.dp))
            Text(text = socialMediaAddress)
        }
    }
}

@Preview(showBackground = true,
showSystemUi = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardAppTheme {
        BusinessCard()
    }
}