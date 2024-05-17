package com.example.traveloka.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.traveloka.R
import com.example.traveloka.screen.destinations.HomeScreenDestination
import com.example.traveloka.ui.theme.ColorPrimary
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator


/**
 * Created by wahid on 5/16/2024.
 * Github github.com/wahidabd.
 */

@RootNavGraph(start = true)
@Destination
@Composable
fun LoginScreen(navigator: DestinationsNavigator) {

    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ColorPrimary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.traveloka),
            contentDescription = "logo",
            modifier = Modifier
                .size(300.dp)
                .padding(top = 40.dp)
        )

        Text(
            text = "Let’s Enjoy A New World",
            fontSize = 32.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(horizontal = 54.dp)
                .padding(top = 32.dp),
        )

        TextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .padding(top = 34.dp)
                .padding(horizontal = 26.dp)
                .fillMaxWidth()
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text(text = "Password") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .padding(top = 12.dp)
                .padding(horizontal = 26.dp)
                .fillMaxWidth()
        )

        FilledTonalButton(
            onClick = {
                navigator.navigate(HomeScreenDestination)
            },
            modifier = Modifier
                .padding(top = 12.dp)
                .padding(horizontal = 26.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(6.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = ColorPrimary
            )
        ) {
            Text(text = "Login")
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(navigator = EmptyDestinationsNavigator)
}