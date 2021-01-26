package kg.nurik.vacancies

import android.app.Application
import kg.nurik.vacancies.di.DaggerMainComponent
import kg.nurik.vacancies.di.MainComponent

class VacanciesApp : Application() {

    lateinit var mainComponent: MainComponent

    override fun onCreate() {
        super.onCreate()
        app = this
        mainComponent = DaggerMainComponent
            .builder()
            .build()
    }

    companion object {
        lateinit var app: VacanciesApp
    }
}