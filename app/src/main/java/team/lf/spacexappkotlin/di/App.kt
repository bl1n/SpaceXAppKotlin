package team.lf.spacexappkotlin.di

import android.app.Application

class App: Application() {
    companion object{
        lateinit var appComponent: AppComponent
    }
    override fun onCreate() {
        super.onCreate()
        initializeDagger()
//        MultiDex.install(this)
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .restModule(RestModule())
            .mvpModule(MvpModule())
            .chartModule(ChartModule())
            .build()
    }
}