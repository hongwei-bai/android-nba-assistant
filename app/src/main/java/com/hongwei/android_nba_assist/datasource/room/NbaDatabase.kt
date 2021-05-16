package com.hongwei.android_nba_assist.datasource.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [TeamScheduleEntity::class, StandingEntity::class, PlayOffEntity::class, TeamThemeEntity::class], version = 1)
@TypeConverters(NbaTypeConverters::class)
abstract class NbaDatabase : RoomDatabase() {

    abstract fun teamScheduleDao(): TeamScheduleDao

    abstract fun standingDao(): StandingDao

    abstract fun playOff(): PlayOffDao

    abstract fun teamThemeDao(): TeamThemeDao
}