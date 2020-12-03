package tellabsxcomtelindo.android.klikcoaching.ui.detailcategory

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_detail_category.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.ui.coursedetail.CourseDetailActivity
import tellabsxcomtelindo.android.klikcoaching.utils.DUmmyData
import tellabsxcomtelindo.android.klikcoaching.utils.loadImageFromDrawable


data class ItemMenu(val id : Int,val judul: String, val time: String, val img: Int)

class DetailCategoryActivity : AppCompatActivity() {
    val groupAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_category)
        setFullscreen()

        val img = intent.getIntExtra("img", 0)
        val text = intent.getStringExtra("title")

        ivBannerCategory.loadImageFromDrawable(img)
        tvTitleCategory.text = text

        btnBack.setOnClickListener {
            onBackPressed()
        }


        DUmmyData.completeCourse.forEach {
            groupAdapter.add(
                ItemDetailCategoryAdapter(
                    it
                ) {
                    Intent(this, CourseDetailActivity::class.java).apply {
                        putExtra("course", Gson().toJson(it))
                        startActivity(this)
                    }
                }
            )
        }

        rvCategoryDetail.apply {
            adapter = groupAdapter
            layoutManager = LinearLayoutManager(context)
        }
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