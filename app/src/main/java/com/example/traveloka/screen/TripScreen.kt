package com.example.traveloka.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.traveloka.R
import com.example.traveloka.screen.destinations.PriceScreenDestination
import com.example.traveloka.ui.theme.ColorPrimary
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator

@Destination
@Composable
fun TripScreen(navigator: DestinationsNavigator) {

    var departure by remember { mutableStateOf("") }
    var arrival by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(ColorPrimary)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner_plane),
            contentDescription = "banner_plane",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp)
        )

        Text(
            text = "Book your flight",
            color = Color.White,
            fontWeight = FontWeight.Medium,
            fontSize = 28.sp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 42.dp)
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
                .background(Color.White, shape = RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp))
                .weight(1F)
                .fillMaxWidth()
        ) {
            Text(
                text = "From",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .padding(top = 22.dp)
            )

            BasicTextField(
                value = departure,
                onValueChange = { departure = it },
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    color = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 8.dp)
                    .background(ColorPrimary, shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                decorationBox = {
                    if (departure.isEmpty()) {
                        Text(
                            text = "Keberangkatan",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = Color.White.copy(
                                    alpha = 0.6F
                                )
                            ),
                            modifier = Modifier.weight(1F)
                        )
                    }
                    it.invoke()
                }
            )

            Text(
                text = "To",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .padding(top = 12.dp)
            )

            BasicTextField(
                value = arrival,
                onValueChange = { arrival = it },
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    color = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 8.dp)
                    .background(ColorPrimary, shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                decorationBox = {
                    if (arrival.isEmpty()) {
                        Text(
                            text = "Kedatangan",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = Color.White.copy(
                                    alpha = 0.6F
                                )
                            ),
                            modifier = Modifier.weight(1F)
                        )
                    }
                    it.invoke()
                }
            )

            Text(
                text = "Date",
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(horizontal = 22.dp)
                    .padding(top = 12.dp)
            )

            BasicTextField(
                value = date,
                onValueChange = { date = it },
                textStyle = MaterialTheme.typography.bodyMedium.copy(
                    fontSize = 14.sp,
                    color = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 8.dp)
                    .background(ColorPrimary, shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                decorationBox = {
                    if (date.isEmpty()) {
                        Text(
                            text = "17 Mei 2024",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = Color.White.copy(
                                    alpha = 0.6F
                                )
                            ),
                            modifier = Modifier.weight(1F)
                        )
                    }
                    it.invoke()
                }
            )

            FilledTonalButton(
                onClick = {
                    navigator.navigate(PriceScreenDestination)
                },
                modifier = Modifier
                    .padding(top = 32.dp)
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = ColorPrimary,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Get Started")
            }
        }
    }
}

@Preview
@Composable
private fun TripScreenPreview() {
    TripScreen(EmptyDestinationsNavigator)
}