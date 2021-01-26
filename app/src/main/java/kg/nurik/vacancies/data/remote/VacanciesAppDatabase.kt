package kg.nurik.vacancies.data.remote

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kg.nurik.vacancies.data.model.ItemFavoritesModel
import kg.nurik.vacancies.data.model.ItemVacanciesModel

@Database(entities = [ItemVacanciesModel::class, ItemFavoritesModel::class], version = 1)
abstract class VacanciesAppDatabase : RoomDatabase() {

    abstract fun getDao(): VacanciesDao

    companion object {
        fun getInstanceDB(context: Context): VacanciesAppDatabase {
            return Room.databaseBuilder(context, VacanciesAppDatabase::class.java, "myDb")
                .allowMainThreadQueries()
                .build()
        }
    }

}