package hu.bme.aut.cheers.data.disk.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coctails")
data class RoomCoctail(
    @PrimaryKey
    val id: String,
    val name: String,
    val type: String,
    val thumbnailUrl: String,
    val alcoholic: Boolean,
    val ingredients: String,
    val instructions: String
)