package com.example.pawsomepetcare.ui.screens.servicesscreen

import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pawsomepetcare.model.Service
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun serviceCarousel(services: List<Service>, navController: NavController){
    val pagerState = rememberPagerState()
    val config = LocalConfiguration.current

    val cardPadding = if(config.orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE){
        180.dp
    }
    else{
        0.dp
    }

    LaunchedEffect(Unit) {
        while(true){
            delay(3000)
            val nextPage = (pagerState.currentPage + 1) % services.size
            pagerState.animateScrollToPage(nextPage, animationSpec = tween(durationMillis = 1000, easing = EaseIn))
        }
    }

    HorizontalPager(count = services.size, state = pagerState, contentPadding = PaddingValues(), modifier = Modifier.height(230.dp)) { page ->
        val services = services[page]
        Card(
            modifier = Modifier
                .padding(horizontal = cardPadding)
                .fillMaxSize()
                .height(230.dp)
                .width(350.dp),
            onClick = {

            }
        ) {
            Image(painter = painterResource(id = services.imageResourceId), contentDescription = stringResource(
                id = services.desc
            ), modifier = Modifier.fillMaxWidth(), contentScale = ContentScale.FillBounds)
        }
    }
}

