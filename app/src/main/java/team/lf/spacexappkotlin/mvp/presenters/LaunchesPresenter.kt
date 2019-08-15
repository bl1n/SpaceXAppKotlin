package team.lf.spacexappkotlin.mvp.presenters

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import team.lf.spacexappkotlin.di.App
import team.lf.spacexappkotlin.mvp.contracts.LaunchesContract
import team.lf.spacexappkotlin.rest.SpaceApi
import javax.inject.Inject

class LaunchesPresenter : LaunchesContract.Presenter() {

    @Inject
    lateinit var spaceApi: SpaceApi

    init {
        App.appComponent.inject(this)
    }


    override fun makeList() {
        view.showProgress()
        subscribe(spaceApi.getLaunches()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap { Observable.fromIterable(it) }
            .doOnNext {
                view.addLaunch(it)
            }
            .doOnComplete {
                view.hideProgress()
            }
            .subscribe({
                view.hideProgress()
                view.notifyAdapter()
            }, {
                view.showErrorMessage(it.message)
                view.hideProgress()
                it.printStackTrace()
            })
        )
    }

    override fun refreshList() {
        view.refresh()
        makeList()
    }

}