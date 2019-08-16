package team.lf.spacexappkotlin.di

import dagger.Component
import team.lf.spacexappkotlin.activities.MainActivity
import team.lf.spacexappkotlin.mvp.fragments.AboutFragment
import team.lf.spacexappkotlin.mvp.fragments.LaunchInfoFragment
import team.lf.spacexappkotlin.mvp.fragments.LaunchesFragment
import team.lf.spacexappkotlin.mvp.presenters.AboutPresenter
import team.lf.spacexappkotlin.mvp.presenters.LaunchInfoPresenter
import team.lf.spacexappkotlin.mvp.presenters.LaunchesPresenter

import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class, RestModule::class, MvpModule::class, ChartModule::class))
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(aboutPresenter: AboutPresenter)
    fun inject(aboutFragment: AboutFragment)
    fun inject(launchesPresenter: LaunchesPresenter)
    fun inject(launchesFragment: LaunchesFragment)
    fun inject(launchInfoPresenter: LaunchInfoPresenter)
    fun inject(launchFragment: LaunchInfoFragment)

}