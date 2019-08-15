package team.lf.spacexappkotlin.mvp.presenters

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import team.lf.spacexappkotlin.di.App
import team.lf.spacexappkotlin.mvp.contracts.AboutContract
import team.lf.spacexappkotlin.rest.SpaceApi
import javax.inject.Inject

class AboutPresenter : AboutContract.Presenter() {
    @Inject
    lateinit var spaceApi: SpaceApi

    init {
        App.appComponent.inject(this)
    }

    override fun loadInfo() {
        view.showProgress()
        subscribe(spaceApi.getCompanyInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                view.showInfo(it)
            }
            .doOnComplete {
                view.hideProgress()
            }
            .subscribe({
                view.hideProgress()
            }, {
                view.showErrorMessage(it.message)
                view.hideProgress()
                it.printStackTrace()
            })
        )
    }

    override fun refreshInfo() {
        view.refresh()
        loadInfo()
    }

}