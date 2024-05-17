package com.example.traveloka.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.traveloka.R
import com.example.traveloka.screen.destinations.TripScreenDestination
import com.example.traveloka.ui.theme.ColorPrimary
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.EmptyDestinationsNavigator


@Destination
@Composable
fun HomeScreen(navigator: DestinationsNavigator) {

    val state = rememberLazyGridState()

    LazyVerticalGrid(
        state = state,
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        items(
            count = 1,
            span = { GridItemSpan(maxLineSpan) }
        ) {
            HomeHeader()
        }

        items(menuItems) { item ->
            MenuItem(data = item) {
                navigator.navigate(TripScreenDestination)
            }
        }

        items(
            count = 1,
            span = { GridItemSpan(maxLineSpan) }
        ) {
            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = "banner",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun MenuItem(data: MenuHomeItem, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(id = data.icon),
            contentDescription = data.title,
            modifier = Modifier.size(36.dp)
        )

        Text(
            text = data.title,
            fontSize = 14.sp,
            color = Color.Black,
        )
    }
}

@Composable
fun HomeHeader() {

    var search by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(ColorPrimary)
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.traveloka),
                    contentDescription = "image",
                    modifier = Modifier
                        .width(46.dp)
                        .height(64.dp)
                )

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "Hi El",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }

            Box(
                modifier = Modifier
                    .size(52.dp)
                    .background(Color.White, shape = RoundedCornerShape(100))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.outline_notifications_24),
                    contentDescription = "image",
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center)
                )
            }
        }

        Text(
            text = "Where you want to go?",
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(top = 54.dp)
                .padding(bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )

        BasicTextField(
            value = search,
            onValueChange = { search = it },
            textStyle = MaterialTheme.typography.bodyMedium.copy(
                fontSize = 14.sp,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .padding(horizontal = 16.dp, vertical = 10.dp),
            decorationBox = {
                if (search.isEmpty()) {
                    Text(
                        text = "Search a flight",
                        color = Color.Gray,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
                it.invoke()
            }
        )
    }
}

val menuItems = listOf(
    MenuHomeItem(
        icon = R.drawable.outline_airplane_ticket_24,
        title = "Tiket Pesawat",
    ),
    MenuHomeItem(
        icon = R.drawable.outline_local_hotel_24,
        title = "Hotel",
    ),
    MenuHomeItem(
        icon = R.drawable.outline_movie_24,
        title = "Bioskop",
    ),
    MenuHomeItem(
        icon = R.drawable.outline_directions_railway_24,
        title = "Kereta Api",
    ),
    MenuHomeItem(
        icon = R.drawable.baseline_beach_access_24,
        title = "Liburan",
    ),
    MenuHomeItem(
        icon = R.drawable.outline_assignment_24,
        title = "Tagihan"
    ),
    MenuHomeItem(
        icon = R.drawable.outline_directions_bus_24,
        title = "Bus"
    ),
    MenuHomeItem(
        icon = R.drawable.outline_delivery_dining_24,
        title = "Eat Delivery"
    ),
    MenuHomeItem(
        icon = R.drawable.baseline_attach_money_24,
        title = "Asuransi"
    ),
)

data class MenuHomeItem(
    val icon: Int,
    val title: String
)

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(navigator = EmptyDestinationsNavigator)
}