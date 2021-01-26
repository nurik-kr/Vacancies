package kg.nurik.vacancies.ui.today

import androidx.lifecycle.ViewModel
import kg.nurik.vacancies.data.model.ItemVacanciesModel
import kg.nurik.vacancies.di.inject

class TodayViewModel : ViewModel() {

    private val db by inject { db }

    init {
        generateDate()
    }

    fun update(item: ItemVacanciesModel) {
        db.getDao().update(item)
    }

    fun getAllList() = db.getDao().getAllVacancies() //live data

    private fun generateDate() {
        val list = arrayListOf<ItemVacanciesModel>()
        for (i in 0..100) {
            list.add(
                ItemVacanciesModel(
                    id = i,
                    title = "Job position $i",
                    data = "22.11.2021",
                    jobDesc = "Job desc $i",
                    salary = (i * 1000).toString(),
                    isChecked = false
                )
            )
        }
        db.getDao().insert(list)
    }
}