package team.lf.spacexappkotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.li_launch_image.view.*
import team.lf.spacexappkotlin.R
import team.lf.spacexappkotlin.rest.models.Launch

class LaunchImagesAdapter: BaseAdapter<LaunchImagesAdapter.LaunchImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): LaunchImageViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.li_launch_image, parent, false)
        return LaunchImageViewHolder(v)
    }
    class LaunchImageViewHolder(view:View):BaseViewHolder(view){
        override fun bind(item: Any) {
            let {
                item as String
                Picasso.get().load(item).resize(550,550).placeholder(R.drawable.ic_spacex_vector_logo).into(view.li_launch_image)
//                Glide.with(view.context)
//                    .load(item)
//                    .placeHolder()
//                    .into(view.li_launch_image)


            }

        }

    }
}