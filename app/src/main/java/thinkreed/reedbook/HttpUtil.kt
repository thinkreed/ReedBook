package thinkreed.reedbook

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import thinkreed.reedbook.bookapis.BookApi
import thinkreed.reedbook.bookapis.Parameter
import thinkreed.reedbook.models.Chapter

/**
 * Created by thinkreed on 2018/1/10.
 */
object HttpUtil {

    private val BASE_URL = "http://113.91.215.113:5000/"
    private val okHttpClient by lazy {
        OkHttpClient.Builder()
                .build()
    }
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }

    private val bookApi by lazy {
        retrofit.create(BookApi::class.java)
    }

    fun getChapter(parameter: Parameter, observer: Observer<Chapter>) {
        bookApi.getChapter(parameter.bookName, parameter.chapterIndex)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer)
    }
}