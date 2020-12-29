package com.azuka.networkcache.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.azuka.networkcache.data.local.entity.PostEntity


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

@Database(entities = [PostEntity::class], version = 1, exportSchema = false)
abstract class PostDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

}