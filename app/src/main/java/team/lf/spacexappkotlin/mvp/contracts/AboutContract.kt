package team.lf.spacexappkotlin.mvp.contracts

import team.lf.spacexappkotlin.rest.models.CompanyInfo

class AboutContract {
    interface View: BaseContract.View{
        fun showInfo(companyInfo: CompanyInfo)
        fun showProgress()
        fun hideProgress()
        fun showErrorMessage(error: String?)
        fun refresh()
    }
    abstract class Presenter:BaseContract.Presenter<View>(){
        abstract fun loadInfo()
        abstract fun refreshInfo()
    }
}