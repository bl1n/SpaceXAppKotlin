package team.lf.spacexappkotlin.mvp.presenters

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import team.lf.spacexappkotlin.di.App
import team.lf.spacexappkotlin.mvp.contracts.LaunchInfoContract
import team.lf.spacexappkotlin.rest.SpaceApi
import javax.inject.Inject

class LaunchInfoPresenter : LaunchInfoContract.Presenter() {

    @Inject
    lateinit var spaceApi: SpaceApi


    init {
        App.appComponent.inject(this)

    }

    override fun loadInfo(flightNumber: String) {
        view.showProgress()
        subscribe(spaceApi.getLaunch(flightNumber)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                view.showInfo(it)
                val mFlickrImages = it.mLinks.mFlickrImages
                for(uri in mFlickrImages){
                    view.addImage(uri)
                }
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

    override fun refreshList() {
        view.refresh()
    }
}