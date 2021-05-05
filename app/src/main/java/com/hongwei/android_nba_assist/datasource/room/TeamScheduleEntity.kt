package com.hongwei.android_nba_assist.datasource.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.hongwei.android_nba_assist.constant.AppConfigurations.Room.API_VERSION

@Entity(tableName = "team_schedule")
data class TeamScheduleEntity(
    @PrimaryKey
    @SerializedName("api_version")
    val apiVersion: Int = API_VERSION,
    @SerializedName("team")
    val team: String = "",
    @SerializedName("time_stamp")
    val timeStamp: Long,
    @SerializedName("data_version")
    val dataVersion: Long = -1,
    @SerializedName("data")
    val data: String = "{}"
)

