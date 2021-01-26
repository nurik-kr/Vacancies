package kg.nurik.vacancies.di

import dagger.Component
import kg.nurik.vacancies.di.module.RoomModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [RoomModule::class]
)
interface MainComponent {

    fun inject(injector: Injector)

}