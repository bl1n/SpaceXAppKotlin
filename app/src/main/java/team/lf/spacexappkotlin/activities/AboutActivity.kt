package team.lf.spacexappkotlin.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import team.lf.spacexappkotlin.R
import team.lf.spacexappkotlin.mvp.fragments.AboutFragment
import team.lf.spacexappkotlin.mvp.presenters.AboutPresenter
import team.lf.spacexappkotlin.utils.FLIGHT_NUMBER
import javax.inject.Inject

class AboutActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: AboutPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, AboutFragment())
            .commit()
    }


}
