package com.miharu.planetphoto.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "apod_table")
data class ApodResponse(
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null,
    val title: String,
    val explanation: String,
    val date: String,
    val copyright: String?,
    val url: String,
) : Parcelable