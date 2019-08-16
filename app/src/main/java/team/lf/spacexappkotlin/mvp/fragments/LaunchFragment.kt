package team.lf.spacexappkotlin.mvp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import team.lf.spacexappkotlin.R
import team.lf.spacexappkotlin.utils.FLIGHT_NUMBER
import team.lf.spacexappkotlin.utils.LAUNCH_BUNDLE

class LaunchFragment: Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_launch, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val args = arguments?.getBundle(LAUNCH_BUNDLE)
        val fn = args?.getString(FLIGHT_NUMBER)



        Log.d("DEBUG", "fn $fn")
        Toast.makeText(context, "flight number is $fn", Toast.LENGTH_SHORT).show()
    }
}