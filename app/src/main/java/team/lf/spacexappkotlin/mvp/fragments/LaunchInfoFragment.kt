package team.lf.spacexappkotlin.mvp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fr_launch.*
import kotlinx.android.synthetic.main.fr_list.*
import team.lf.spacexappkotlin.R
import team.lf.spacexappkotlin.adapters.BaseAdapter
import team.lf.spacexappkotlin.adapters.LaunchImagesAdapter
import team.lf.spacexappkotlin.di.App
import team.lf.spacexappkotlin.mvp.contracts.LaunchInfoContract
import team.lf.spacexappkotlin.mvp.presenters.LaunchInfoPresenter
import team.lf.spacexappkotlin.rest.models.Launch
import team.lf.spacexappkotlin.utils.FLIGHT_NUMBER
import team.lf.spacexappkotlin.utils.calculateNoOfColumns
import team.lf.spacexappkotlin.utils.dateToString
import javax.inject.Inject

class LaunchInfoFragment : BaseFragment(), LaunchInfoContract.View {

    @Inject
    lateinit var presenter: LaunchInfoPresenter


    companion object {
        fun newInstance(fn: String): LaunchInfoFragment {
            val launchFragment = LaunchInfoFragment()
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

    override fun createAdapterInstance(): BaseAdapter<*> = LaunchImagesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        launch_info_flight_number.text = launch.mFlightNumber
        launch_info_mission_name.text = launch.mMissionName
        launch_info_date.text = launch.mLaunchDateUnix.dateToString()
        Glide.with(requireActivity()).load(launch.mLinks.mMissionPatch).into(launch_info_iv_mission_patch)
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

    override fun addImage(url: String) {
        viewAdapter.add(url)
    }

    override fun notifyAdapter() {
        viewAdapter.notifyDataSetChanged()
    }

    override fun refresh() {
        viewAdapter.items.clear()
        viewAdapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        presenter.attach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.detach()
    }

    override fun createManagerInstance(): RecyclerView.LayoutManager = GridLayoutManager(requireActivity(), calculateNoOfColumns(requireActivity()))
}