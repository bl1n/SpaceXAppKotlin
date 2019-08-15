package team.lf.spacexappkotlin.rest

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import team.lf.spacexappkotlin.rest.models.Launch

interface SpaceApi {

    @GET("launches")
    fun getLaunches(): Observable<List<Launch>>

    @GET("launches/{id}")
    fun getLaunch(@Path("id")id:String):Observable<Launch>

//    @GET("history")
//    abstract fun getHistoryEvents(): Single<List<HistoryEvent>>
//
//    @GET("history/{id}")
//    abstract fun getHistoryEvent(@Path("id") id: Int): Single<HistoryEvent>
//
//    @GET("launches/{id}")
//    abstract fun getLaunch(@Path("id") id: Int): Single<Launch>
//
//    @GET("info")
//    abstract fun getCompanyInfo(): Single<CompanyInfo>
//
//    @GET("launches")
//    abstract fun getLaunches(): Single<List<Launch>>
}