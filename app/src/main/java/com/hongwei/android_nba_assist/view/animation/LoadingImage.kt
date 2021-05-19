package com.hongwei.android_nba_assist.view.animation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.airbnb.lottie.compose.LottieAnimationState
import com.hongwei.android_nba_assist.R

@Preview
@Composable
fun LoadingImage(modifier: Modifier = Modifier) {
    val animationSpec = remember { LottieAnimationSpec.RawRes(R.raw.loading_small) }
    val state = LottieAnimationState(isPlaying = true, repeatCount = Integer.MAX_VALUE)
    state.speed = 1f
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LottieAnimation(
            spec = animationSpec,
            modifier = modifier,
            animationState = state
        )
    }
}