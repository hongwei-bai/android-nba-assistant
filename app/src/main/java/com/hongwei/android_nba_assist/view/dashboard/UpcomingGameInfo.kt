package com.hongwei.android_nba_assist.view.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.hongwei.android_nba_assist.R
import com.hongwei.android_nba_assist.datasource.room.Event
import com.hongwei.android_nba_assist.util.LocalDateTimeUtil.getLocalDateDisplay
import com.hongwei.android_nba_assist.util.LocalDateTimeUtil.getLocalTimeDisplay
import com.hongwei.android_nba_assist.view.component.TeamLogo

@Composable
fun UpcomingGameInfo(myTeam: String?, event: Event?) {
    if (myTeam != null && event != null) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(
                        bottomStart = 3.dp, bottomEnd = 3.dp,
                        topStart = 10.dp, topEnd = 10.dp
                    )
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 3.dp, bottomEnd = 3.dp,
                            topStart = 10.dp, topEnd = 10.dp
                        )
                    )
                    .background(MaterialTheme.colors.primary)
            ) {
                TeamLogo(event.guestTeam, Modifier.size(110.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = getLocalDateDisplay(event.unixTimeStamp),
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onPrimary
                    )
                    Text(
                        text = stringResource(R.string.game_vs_at),
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onPrimary
                    )
                    Text(
                        text = getLocalTimeDisplay(event.unixTimeStamp),
                        style = MaterialTheme.typography.h6,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
                TeamLogo(event.homeTeam, Modifier.size(110.dp))
            }
        }
    }
}