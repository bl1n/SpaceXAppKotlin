package team.lf.spacexappkotlin.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_launch.*
import team.lf.spacexappkotlin.R
import team.lf.spacexappkotlin.utils.FLIGHT_NUMBER
import team.lf.spacexappkotlin.utils.LAUNCH_BUNDLE

class LaunchInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        val bundleExtra = intent.getBundleExtra(LAUNCH_BUNDLE)
        val string = bundleExtra.getString(FLIGHT_NUMBER)
        textView.text = string

    }
}
