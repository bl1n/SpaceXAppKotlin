package team.lf.spacexappkotlin.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class RestModule {
    @Provides
    @Singleton
    fun providesGson():Gson=
        GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun provideOkHttpClient():OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    @Named("SPACEX_API")
    fun provideGeckoRetrofit(gson: Gson, okHttpClient: OkHttpClient):Retrofit=
        Retrofit.Builder()
            .baseUrl("https://api.spacexdata.com/v3/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

//    @Provides
//    @Singleton
//    fun provideGeckoApiService(@Named("SPACEX_API") retrofit: Retrofit):CoinGeckoApi =
//        retrofit.create(CoinGeckoApi::class.java)
}