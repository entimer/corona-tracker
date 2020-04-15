package io.github.entimer.coronatracker.room.entity

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(tableName = "cases",
    primaryKeys = ["country", "date"],
    foreignKeys = [
        ForeignKey(
            entity = CountryEntity::class,
            parentColumns = ["name"],
            childColumns = ["country"],
            onDelete = CASCADE
        )
    ])
data class CaseEntity (
    val country: String,

    val date: String,

    val confirmed: Int?,

    val recovered: Int?,

    val death: Int?
)