package kg.nurik.vacancies.di

import kg.nurik.vacancies.VacanciesApp
import kg.nurik.vacancies.data.remote.VacanciesAppDatabase
import javax.inject.Inject

inline fun <T> inject(crossinline block: Injector.() -> T): Lazy<T> = lazy { Injector().block() }

class Injector {

    @Inject
    lateinit var db: VacanciesAppDatabase

    init {
        VacanciesApp.app.mainComponent.inject(this)
    }

}