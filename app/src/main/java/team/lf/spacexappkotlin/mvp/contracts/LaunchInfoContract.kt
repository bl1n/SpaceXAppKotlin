package team.lf.spacexappkotlin.mvp.contracts

import team.lf.spacexappkotlin.rest.models.Launch

class LaunchInfoContract {
    interface View:BaseContract.View{
        fun showInfo(launch: Launch)
        fun showProgress()
        fun hideProgress()
        fun showErrorMessage(error: String?)
        fun addImage(url:String)
        fun notifyAdapter()
        fun refresh()
    }
    abstract class Presenter:BaseContract.Presenter<View>(){
        abstract fun loadInfo(flightNumber:String)
        abstract fun refreshList()

    }
}