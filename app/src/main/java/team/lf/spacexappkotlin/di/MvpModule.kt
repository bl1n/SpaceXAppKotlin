package team.lf.spacexappkotlin.di

import dagger.Module
import dagger.Provides
import team.lf.spacexappkotlin.mvp.presenters.AboutPresenter
import javax.inject.Singleton


@Module
class MvpModule {

    @Provides
    @Singleton
    fun provideAboutPresenter(): AboutPresenter = AboutPresenter()



}