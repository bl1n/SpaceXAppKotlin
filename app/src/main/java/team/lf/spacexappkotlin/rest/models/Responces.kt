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
    val mLaunchDateUnix: Int,
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
    private var mName: String,
    @SerializedName("founder")
    private var mFounder: String,
    @SerializedName("founded")
    private var mFounded: Int,
    @SerializedName("employees")
    private var mEmployees: Int,
    @SerializedName("vehicles")
    private var mVehicles: Int,
    @SerializedName("launch_sites")
    private var mLaunchSites: Int,
    @SerializedName("test_sites")
    private var mTestSites: Int,
    @SerializedName("ceo")
    private var mCeo: String,
    @SerializedName("cto")
    private var mCto: String,
    @SerializedName("coo")
    private var mCoo: String,
    @SerializedName("cto_propulsion")
    private var mCtoPropulsion: String,
    @SerializedName("valuation")
    private var mValuation: Long,
    @SerializedName("summary")
    private var mSummary: String
)