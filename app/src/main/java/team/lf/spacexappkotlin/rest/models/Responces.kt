package team.lf.spacexappkotlin.rest.models

import com.google.gson.annotations.SerializedName

data class Launch(
    @SerializedName("flight_number")
    val mFlightNumber: String,
    @SerializedName("mission_name")
    val mMissionName: String,
    @SerializedName("launch_year")
    val mLaunchYear: String,
    @SerializedName("launch_date_unix")
    val mLaunchDateUnix: Long,
    @SerializedName("launch_date_utc")
    val mLaunchDateUtc: String,
    @SerializedName("launch_date_local")
    val mLaunchDateLocal: String,
    @SerializedName("is_tentative")
    val mIsTentative: Boolean,
    @SerializedName("tentative_max_precision")
    val mTentativeMaxPrecision: String,
    @SerializedName("tbd")
    val mTbd: Boolean,
    @SerializedName("launch_window")
    val mLaunchWindow: Int,
    @SerializedName("launch_success")
    val mLaunchSuccess: Boolean,
    @SerializedName("links")
    val mLinks: Links,
    @SerializedName("details")
    val mDetails: String,
    @SerializedName("upcoming")
    val mUpcoming: Boolean,
    @SerializedName("static_fire_date_utc")
    val mStaticFireDateUtc: String,
    @SerializedName("static_fire_date_unix")
    val mStaticFireDateUnix: Int
)

data class Links(
    @SerializedName("mission_patch")
    val mMissionPatch: String,
    @SerializedName("mission_patch_small")
    val mMissionPatchSmall: String,
    @SerializedName("reddit_campaign")
    val mRedditCampaign: String,
    @SerializedName("reddit_launch")
    val mRedditLaunch: String,
    @SerializedName("reddit_media")
    val mRedditMedia: String,
    @SerializedName("presskit")
    private var mPresskit: String,
    @SerializedName("article_link")
    val mArticleLink: String,
    @SerializedName("wikipedia")
    private var mWikipedia: String,
    @SerializedName("video_link")
    val mVideoLink: String,
    @SerializedName("youtube_id")
    val mYoutubeId: String,
    @SerializedName("flickr_images")
    val mFlickrImages: List<String>
)

data class CompanyInfo(
    @SerializedName("name")
    val mName: String,
    @SerializedName("founder")
    val mFounder: String,
    @SerializedName("founded")
    val mFounded: Int,
    @SerializedName("employees")
    val mEmployees: Int,
    @SerializedName("vehicles")
    val mVehicles: Int,
    @SerializedName("launch_sites")
    val mLaunchSites: Int,
    @SerializedName("test_sites")
    val mTestSites: Int,
    @SerializedName("ceo")
    val mCeo: String,
    @SerializedName("cto")
    val mCto: String,
    @SerializedName("coo")
    val mCoo: String,
    @SerializedName("cto_propulsion")
    val mCtoPropulsion: String,
    @SerializedName("valuation")
    val mValuation: Long,
    @SerializedName("summary")
    val mSummary: String
)