package team.lf.spacexappkotlin.di

import dagger.Module
import dagger.Provides
import team.lf.spacexappkotlin.mvp.presenters.AboutPresenter
import team.lf.spacexappkotlin.mvp.presenters.LaunchInfoPresenter
import team.lf.spacexappkotlin.mvp.presenters.LaunchesPresenter
import javax.inject.Singleton


@Module
class MvpModule {

    @Provides
    @Singleton
    fun provideAboutPresenter(): AboutPresenter = AboutPresenter()

    @Provides
    @Singleton
    fun provideLaunchesPresenter(): LaunchesPresenter = LaunchesPresenter()

    @Provides
    @Singleton
    fun provideLaunchInfoPresenter(): LaunchInfoPresenter = LaunchInfoPresenter()


}