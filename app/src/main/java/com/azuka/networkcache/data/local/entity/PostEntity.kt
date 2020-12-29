package com.azuka.networkcache.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by ivanaazuka on 29/12/20.
 * Android Engineer
 */

@Entity(tableName = "t_post")
data class PostEntity(
    @PrimaryKey val id: Long,
    val userId: Long,
    val title: String,
    val body: String
)