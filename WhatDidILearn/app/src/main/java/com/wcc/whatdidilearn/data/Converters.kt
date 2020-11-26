package com.wcc.whatdidilearn.data

import androidx.room.TypeConverter
import com.wcc.whatdidilearn.R
import com.wcc.whatdidilearn.entities.Level

class Converters {
    @TypeConverter
    fun levelToInt(Level: Level): Int{
        return Level.color
    }

    @TypeConverter
    fun intToLevel (color: Int): Level {
        return when(color) {
            R.color.purple_100 -> Level.HIGH
            R.color.pink_500 -> Level.MEDIUM
            else -> Level.LOW
        }
    }
}