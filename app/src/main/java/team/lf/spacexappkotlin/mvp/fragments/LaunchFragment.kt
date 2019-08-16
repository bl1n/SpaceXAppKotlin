package team.lf.spacexappkotlin.mvp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fr_launch.*
import team.lf.spacexappkotlin.R
import team.lf.spacexappkotlin.di.App
import team.lf.spacexappkotlin.mvp.contracts.LaunchInfoContract
import team.lf.spacexappkotlin.mvp.contracts.LaunchesContract
import team.lf.spacexappkotlin.mvp.presenters.LaunchInfoPresenter
import team.lf.spacexappkotlin.rest.models.Launch
import team.lf.spacexappkotlin.utils.FLIGHT_NUMBER
import team.lf.spacexappkotlin.utils.LAUNCH_BUNDLE
import javax.inject.Inject

class LaunchFragment: Fragment(), LaunchInfoContract.View {

    @Inject
    lateinit var presenter: LaunchInfoPresenter


    companion object{
        fun newInstance(fn: String):LaunchFragment{
            val launchFragment = LaunchFragment()
            val bundle = Bundle().apply {
                putString(FLIGHT_NUMBER, fn)
            }
            launchFragment.arguments = bundle
            return launchFragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_launch, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        App.appComponent.inject(this)
        val fn = arguments?.getString(FLIGHT_NUMBER)
        Log.d("Debug", fn)
        presenter.attach(this)
        fn?.let { presenter.loadInfo(it) }
    }

    override fun showInfo(launch: Launch) {
        textView.text = launch.mMissionName
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress() {
        requireActivity().progress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        requireActivity().progress.visibility = View.INVISIBLE
    }

    override fun showErrorMessage(error: String?) {
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

}