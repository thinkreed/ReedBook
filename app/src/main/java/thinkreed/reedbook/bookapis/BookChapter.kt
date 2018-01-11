package thinkreed.reedbook.bookapis

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.POST
import thinkreed.reedbook.models.Chapter

/**
 * Created by thinkreed on 2018/1/10.
 */
interface book_chapter {

    @POST("book")
    fun getChapter(@Field("book_name") bookName: String, @Field("chapter_index") chapterIndex: String): Observable<Chapter>
}

data class Parameter(val bookName: String, val chapterIndex: String)