package team.lf.spacexappkotlin.mvp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_with_container.*
import kotlinx.android.synthetic.main.activity_with_container.progress
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fr_about.*
import team.lf.spacexappkotlin.R
import team.lf.spacexappkotlin.di.App
import team.lf.spacexappkotlin.mvp.contracts.AboutContract
import team.lf.spacexappkotlin.mvp.presenters.AboutPresenter
import team.lf.spacexappkotlin.rest.models.CompanyInfo
import javax.inject.Inject

class AboutFragment : Fragment(), AboutContract.View {

    @Inject
    lateinit var presenter: AboutPresenter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        App.appComponent.inject(this)
        presenter.attach(this)
        presenter.loadInfo()
    }

    override fun showInfo(companyInfo: CompanyInfo) {
        about_ceo.text = companyInfo.mCeo
        about_founded.text = companyInfo.mFounded.toString()
        about_summary.text = companyInfo.mSummary
        context?.let {
            Glide.with(it)
                .load("https://www.pngkit.com/png/full/198-1987112_elon-musk-elon-musk-the-greatest-lessons-through.png")
                .into(about_mask_photo)
        }
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
        TODO("SwipeRefreshLayout???") //To change body of created functions use File | Settings | File Templates.
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