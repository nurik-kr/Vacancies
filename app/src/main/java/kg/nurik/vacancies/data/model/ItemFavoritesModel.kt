package kg.nurik.vacancies.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemFavoritesModel(
    @PrimaryKey
    val id: Int,
    val title: String,
    val data: String,
    val jobDesc: String,
    val salary: String?,
    var isChecked: Boolean
)