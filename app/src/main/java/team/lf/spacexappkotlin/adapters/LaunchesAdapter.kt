package team.lf.spacexappkotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.li_launch.view.*
import team.lf.spacexappkotlin.R
import team.lf.spacexappkotlin.rest.models.Launch

class LaunchesAdapter : BaseAdapter<LaunchesAdapter.LaunchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.li_launch, parent, false)
        return LaunchViewHolder(v)
    }


    class LaunchViewHolder(view: View) : BaseViewHolder(view) {
        override fun bind(item: Any) {
            let {
                item as Launch
                Glide.with(view.context).load(item.mLinks.mMissionPatchSmall).into(view.li_mission_patch_small)
                view.li_mission_name.text = item.mMissionName
                view.li_flight_number.text = item.mFlightNumber
                view.li_launch_date.text = item.mLaunchDateUtc
            }
        }

    }
}