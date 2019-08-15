package team.lf.spacexappkotlin.di

import dagger.Component
import team.lf.spacexappkotlin.activities.MainActivity
import team.lf.spacexappkotlin.mvp.fragments.AboutFragment
import team.lf.spacexappkotlin.mvp.presenters.AboutPresenter

import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class, RestModule::class, MvpModule::class, ChartModule::class))
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(aboutPresenter: AboutPresenter)
    fun inject(aboutFragment: AboutFragment)

}