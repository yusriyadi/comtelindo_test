package tellabsxcomtelindo.android.klikcoaching.ui.courseplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_course_detail.*
import kotlinx.android.synthetic.main.activity_course_player.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.utils.ViewPagerAdapterTabs
import tellabsxcomtelindo.android.klikcoaching.utils.ViewPagerAdapterTabsContetnt

class CoursePlayerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_player)


        btnDownload.setOnClickListener {
            onBackPressed()
        }


        vp_Content.adapter = ViewPagerAdapterTabsContetnt(this)
        TabLayoutMediator(tabs_content, vp_Content) { tab, position ->
            when (position) {
                0 -> tab.text = "Kontent"
                else -> tab.text = "Diskusi"
            }
        }.attach()


    }
}