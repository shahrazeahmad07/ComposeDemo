package com.example.composedemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfilePage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.phoenix),
            contentDescription = "Picture of Phoenix Character from Valorant Game.",
            modifier = Modifier
                .size(dimensionResource(com.intuit.sdp.R.dimen._200sdp))
                .clip(CircleShape)
                .border(width = dimensionResource(com.intuit.sdp.R.dimen._2sdp), color = Color.Red, shape = CircleShape)
                .padding(all = dimensionResource(com.intuit.sdp.R.dimen._10sdp)),
            contentScale = ContentScale.Fit
        )
        Text(text = "Phoenix")
        Text(text = "Valorant")

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(com.intuit.sdp.R.dimen._12sdp))
        ) {

            ProfileStats("150", "Followers")
            ProfileStats("100", "Following")
            ProfileStats("30", "Posts")

        }

    }

}

@Composable
fun ProfileStats(count: String, title: String) {

    Column {
        Text(
            text = count,
            fontWeight = FontWeight.Bold
        )
        Text(title)
    }

}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    ProfilePage()
}