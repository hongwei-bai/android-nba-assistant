package com.hongwei.android_nba_assist.view.dashboard

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.hongwei.android_nba_assist.R
import com.hongwei.android_nba_assist.util.LocalDateTimeUtil.getInDays
import com.hongwei.android_nba_assist.util.LocalDateTimeUtil.getInHours
import com.hongwei.android_nba_assist.viewmodel.UpcomingHelper.getUpcomingRange
import com.hongwei.android_nba_assist.viewmodel.UpcomingRange
import java.util.*

@Composable
fun UpcomingGameForecast(
    @PreviewParameter(UrlProvider::class)
    eventTime: Long?,
    countdown: String?
) {
    eventTime?.let {
        val calendar = Calendar.getInstance().apply { timeInMillis = it }
        when (val inDays = getInDays(calendar)) {
            0 -> {
                when (getUpcomingRange(it)) {
                    UpcomingRange.InHours -> ForecastContent(
                        stringResource(id = R.string.upcoming_game_in),
                        stringResource(id = R.string.upcoming_game_in_hours, getInHours(calendar))
                    )
                    UpcomingRange.CountingDown, UpcomingRange.Now -> ForecastContent(
                        stringResource(id = R.string.upcoming_game_in),
                        countdown ?: ""
                    )
                    UpcomingRange.Started, UpcomingRange.CountingUp -> ForecastContent(
                        stringResource(id = R.string.upcoming_game_started),
                        countdown ?: "", false
                    )
                    else -> ForecastContent(
                        stringResource(id = R.string.upcoming_game_on),
                        stringResource(id = R.string.upcoming_game_today)
                    )
                }
            }
            1 -> ForecastContent(
                stringResource(id = R.string.upcoming_game_on),
                stringResource(id = R.string.upcoming_game_tomorrow)
            )
            in 2..Int.MAX_VALUE -> ForecastContent(
                stringResource(id = R.string.upcoming_game_in),
                stringResource(id = R.string.upcoming_game_in_days, inDays)
            )
            else -> Placeholder()
        }
    } ?: Placeholder()
}

@Composable
private fun Placeholder() {
    ForecastContent("", "")
}

@Composable
private fun ForecastContent(caption: String, value: String, isHighlight: Boolean = true) {
    Text(
        text = caption,
        style = MaterialTheme.typography.h6
    )
    Spacer(modifier = Modifier.size(6.dp))
    Text(
        text = value,
        style = MaterialTheme.typography.h4,
        color = if (isHighlight) MaterialTheme.colors.secondary else MaterialTheme.colors.primary
    )
}