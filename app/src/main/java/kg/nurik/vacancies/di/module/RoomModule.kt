package kg.nurik.vacancies.di.module

import dagger.Module
import dagger.Provides
import kg.nurik.vacancies.VacanciesApp
import kg.nurik.vacancies.data.remote.VacanciesAppDatabase
import javax.inject.Singleton

@Module
class  RoomModule {

    @Provides
    @Singleton
    fun provideRoom(): VacanciesAppDatabase {
        return VacanciesAppDatabase.getInstanceDB(VacanciesApp.app.applicationContext)
    }


}