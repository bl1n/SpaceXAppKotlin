package team.lf.spacexappkotlin.utils

import android.os.Bundle
import team.lf.spacexappkotlin.mvp.fragments.LaunchFragment

fun getLaunchFragment(bundle: Bundle):LaunchFragment{
    val launchFragment = LaunchFragment()
    launchFragment.arguments = bundle
    return launchFragment
}