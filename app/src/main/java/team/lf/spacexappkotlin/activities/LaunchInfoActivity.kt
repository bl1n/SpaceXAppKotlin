package team.lf.spacexappkotlin.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import team.lf.spacexappkotlin.R
import team.lf.spacexappkotlin.mvp.fragments.LaunchFragment
import team.lf.spacexappkotlin.utils.FLIGHT_NUMBER
import team.lf.spacexappkotlin.utils.LAUNCH_BUNDLE

class LaunchInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val s = intent.getStringExtra(FLIGHT_NUMBER)


        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, LaunchFragment.newInstance(s))
            .commit()



//        val string = bundleExtra.getString(FLIGHT_NUMBER)

    }
}
