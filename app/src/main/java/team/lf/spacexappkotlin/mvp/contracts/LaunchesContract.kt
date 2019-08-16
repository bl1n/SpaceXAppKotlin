package team.lf.spacexappkotlin.mvp.contracts

import team.lf.spacexappkotlin.rest.models.Launch

class LaunchesContract {
    interface View: BaseContract.View{
        fun addLaunch(launch: Launch)
        fun notifyAdapter()
        fun showProgress()
        fun hideProgress()
        fun showErrorMessage(error:String?)
        fun refresh()
        fun openLaunch(flightNumber: String)
    }
    abstract class Presenter: BaseContract.Presenter<View>(){
        abstract fun makeList()
        abstract fun refreshList()
    }
}