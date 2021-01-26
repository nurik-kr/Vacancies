package kg.nurik.vacancies.data.remote

import androidx.lifecycle.LiveData
import androidx.room.*
import kg.nurik.vacancies.data.model.ItemVacanciesModel

@Dao
interface VacanciesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(data: List<ItemVacanciesModel>)

    @Query("SELECT ALL * FROM ItemVacanciesModel")
    fun getAllVacancies(): LiveData<List<ItemVacanciesModel>>

    @Update
    fun update(item: ItemVacanciesModel)

    @Query("SELECT ALL * FROM ItemVacanciesModel WHERE isChecked")
    fun getFavorite(): LiveData<List<ItemVacanciesModel>>
}