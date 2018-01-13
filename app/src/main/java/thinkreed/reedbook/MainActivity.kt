package thinkreed.reedbook

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*
import thinkreed.reedbook.bookapis.Parameter
import thinkreed.reedbook.models.Chapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        book_url.setOnClickListener {
            doSomeWork()
        }
    }

    private fun doSomeWork() {
        HttpUtil.getChapter(Parameter("殖民异位面", "1"), object : Observer<Chapter> {
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onError(e: Throwable) {
            }

            override fun onNext(t: Chapter) {
                Toast.makeText(this@MainActivity, "url is " + t.url, Toast.LENGTH_SHORT).show()
            }

        })
    }
}
