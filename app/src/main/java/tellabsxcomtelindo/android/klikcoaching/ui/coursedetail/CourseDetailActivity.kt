package tellabsxcomtelindo.android.klikcoaching.ui.coursedetail

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_course_detail.*
import kotlinx.android.synthetic.main.activity_course_detail.btnBack
import kotlinx.android.synthetic.main.activity_detail_category.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.data.Courses
import tellabsxcomtelindo.android.klikcoaching.ui.detailcategory.ItemMenu
import tellabsxcomtelindo.android.klikcoaching.ui.paymentsuccess.PaymentSuccessfullyActivity
import tellabsxcomtelindo.android.klikcoaching.ui.pilihpembayaran.ChoosePaymentActivity
import tellabsxcomtelindo.android.klikcoaching.utils.DUmmyData
import tellabsxcomtelindo.android.klikcoaching.utils.ViewPagerAdapterTabs
import tellabsxcomtelindo.android.klikcoaching.utils.loadImageFromDrawable

class CourseDetailActivity : AppCompatActivity() {
    lateinit var idCourse: String
    var isWebBinar: Boolean=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)
        setFullscreen()
        val course =
            Gson().fromJson(intent.getStringExtra("course"), Courses::class.java)

        idCourse = course.id.toString()
        isWebBinar =course.isWebBinar
        tvAuthorCourse.text = DUmmyData.author[course.id].name
        tvCourseTitle.text = course.title
        tvRate.text = (2..5).random().toString()
        ivCourse.loadImageFromDrawable(course.imageBanner)

        if(isWebBinar){
            fabPlayWebbinar.loadImageFromDrawable(R.drawable.ic_video)
            tvPrakerjaLabel.visibility = View.GONE
        }

        btnBack.setOnClickListener {
            onBackPressed()
        }


        btnBeli.setOnClickListener {
            Intent(this,ChoosePaymentActivity::class.java).apply {
                startActivity(this)
            }
        }

        vp_course.adapter = ViewPagerAdapterTabs(this)
        TabLayoutMediator(tabLayout2, vp_course) { tab, position ->
            when (position) {
                0 -> tab.text = "Deskripsi"
                else -> tab.text = "Ulasan"
            }
        }.attach()

    }

    private fun setFullscreen() {
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                statusBarColor = Color.TRANSPARENT
            }
        }
    }
}