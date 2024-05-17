package com.example.traveloka.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.traveloka.R
import com.example.traveloka.ui.theme.ColorOrange
import com.example.traveloka.ui.theme.ColorPrimary
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator


@Destination
@Composable
fun PriceScreen(navigator: DestinationsNavigator) {
    Column(
        modifier = Modifier
            .background(ColorPrimary)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                contentDescription = "back",
                tint = Color.White,
                modifier = Modifier.size(24.dp).clickable {
                    navigator.navigateUp()
                }
            )

            Row(
                modifier = Modifier.weight(1F),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Surabaya (SUB)",
                    color = Color.White,
                    fontSize = 14.sp,
                )

                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_right_alt_24),
                    contentDescription = "to",
                    tint = Color.White,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )

                Text(
                    text = "Jakarta (JKAT)",
                    color = Color.White,
                    fontSize = 14.sp,
                )
            }

            Icon(
                painter = painterResource(id = R.drawable.baseline_more_horiz_24),
                contentDescription = "back",
                modifier = Modifier.size(24.dp),
                tint = Color.White
            )
        }

        Text(
            text = "Jum, 17 Mei • 1 Org • Ekonomi",
            color = Color.White,
            fontSize = 12.sp,
        )

        Text(
            text = "Jum'at, 17 Mei 2024",
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(top = 14.dp)
        )

        Text(
            text = "Harga Mulai dari\n   Rp.1.054.000",
            color = Color.Green,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(top = 4.dp)
        )

        LazyColumn(
            modifier = Modifier
                .padding(top = 16.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
                .fillMaxWidth()
                .weight(1F)
                .padding(top = 4.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(16.dp),
        ) {
            items(priceItems) { item ->
                PriceItem(item)
            }
        }
    }
}


@Composable
fun PriceItem(data: PriceData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .border(width = 1.dp, color = Color.Black.copy(alpha = 0.1f), shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = data.icon),
                    contentDescription = data.airline,
                    modifier = Modifier.size(24.dp)
                )

                Text(
                    text = data.airline,
                    color = Color.Black,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Row(
                modifier = Modifier.padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = data.departure,
                        color = Color.Black,
                        fontSize = 14.sp,
                    )

                    Text(
                        text = "SUB",
                        color = Color.Black.copy(alpha = 0.4f),
                        fontSize = 14.sp,
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = data.time,
                        color = Color.Black.copy(alpha = 0.4f),
                        fontSize = 12.sp,
                    )
                    HorizontalDivider(
                        color = Color.Black.copy(alpha = 0.4f),
                        thickness = 1.dp,
                        modifier = Modifier
                            .width(60.dp)
                            .padding(vertical = 4.dp)
                    )
                    Text(
                        text = "Langsung",
                        color = Color.Black.copy(alpha = 0.4f),
                        fontSize = 12.sp,
                    )
                }

                Column {
                    Text(
                        text = data.arrival,
                        color = Color.Black,
                        fontSize = 14.sp,
                    )

                    Text(
                        text = "JKAT",
                        color = Color.Black.copy(alpha = 0.4f),
                        fontSize = 14.sp,
                    )
                }
            }

            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .border(color = Color.DarkGray, width = 1.dp, shape = RoundedCornerShape(100))
                    .padding(vertical = 4.dp, horizontal = 6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_shopping_bag_24),
                    contentDescription = "baggage",
                    tint = Color.DarkGray,
                    modifier = Modifier.size(20.dp)
                )

                Text(
                    text = "20 kg",
                    color = Color.DarkGray,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 2.dp)
                )
            }
        }

        Column(
            modifier = Modifier.padding(top = 12.dp),
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = data.price,
                color = ColorOrange,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "Dapatkan 900 points",
                color = Color.Black.copy(alpha = 0.4f),
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }
}

val priceItems = listOf(
    PriceData(
        icon = R.drawable.lion,
        airline = "Lion Air",
        departure = "04:50",
        arrival = "16:20",
        time = "1j 30m",
        price = "Rp.1.054.000",
    ),
    PriceData(
        icon = R.drawable.lion,
        airline = "Lion Air",
        departure = "07:55",
        arrival = "09:20",
        time = "1j 25m",
        price = "Rp.1.054.000",
    ),
    PriceData(
        icon = R.drawable.lion,
        airline = "Lion Air",
        departure = "11:20",
        arrival = "12:50",
        time = "1j 30m",
        price = "Rp.1.054.000",
    ),
    PriceData(
        icon = R.drawable.lion,
        airline = "Lion Air",
        departure = "04:50",
        arrival = "16:20",
        time = "1j 30m",
        price = "Rp.1.054.000",
    ),
    PriceData(
        icon = R.drawable.lion,
        airline = "Lion Air",
        departure = "07:55",
        arrival = "09:20",
        time = "1j 25m",
        price = "Rp.1.054.000",
    ),
    PriceData(
        icon = R.drawable.lion,
        airline = "Lion Air",
        departure = "11:20",
        arrival = "12:50",
        time = "1j 30m",
        price = "Rp.1.054.000",
    ),
)

data class PriceData(
    val icon: Int,
    val airline: String,
    val departure: String,
    val arrival: String,
    val time: String,
    val price: String,
)

@Preview
@Composable
private fun PriceScreenPreview() {
    PriceScreen(EmptyDestinationsNavigator)
}