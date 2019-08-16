package team.lf.spacexappkotlin.mvp.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import team.lf.spacexappkotlin.R
import team.lf.spacexappkotlin.activities.LaunchInfoActivity
import team.lf.spacexappkotlin.adapters.BaseAdapter
import team.lf.spacexappkotlin.adapters.LaunchesAdapter
import team.lf.spacexappkotlin.di.App
import team.lf.spacexappkotlin.events.OpenLaunch
import team.lf.spacexappkotlin.mvp.contracts.LaunchesContract
import team.lf.spacexappkotlin.mvp.presenters.LaunchesPresenter
import team.lf.spacexappkotlin.rest.models.Launch
import team.lf.spacexappkotlin.utils.FLIGHT_NUMBER
import team.lf.spacexappkotlin.utils.LAUNCH_BUNDLE
import javax.inject.Inject

class LaunchesFragment : BaseFragment(), LaunchesContract.View {
    @Inject
    lateinit var presenter: LaunchesPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appComponent.inject(this)
        presenter.attach(this)
        presenter.makeList()
    }

    override fun createAdapterInstance(): BaseAdapter<*> = LaunchesAdapter()

    override fun addLaunch(launch: Launch) {
        viewAdapter.add(launch)
    }

    override fun notifyAdapter() {
        viewAdapter.notifyDataSetChanged()
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

    override fun refresh() {
        viewAdapter.items.clear()
        viewAdapter.notifyDataSetChanged()
    }
    override fun onResume() {
        super.onResume()
        EventBus.getDefault().register(this)
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun openLaunch(openLaunch: OpenLaunch){
        openLaunch(openLaunch.flightNumber)
//        Toast.makeText(context, "Flight number is " + openLaunch.flightNumber, Toast.LENGTH_SHORT).show()
    }

    override fun openLaunch(flightNumber: String) {
        val intent = Intent(context, LaunchInfoActivity::class.java)
        intent.putExtra(FLIGHT_NUMBER,flightNumber)
        startActivity(intent)
    }
}