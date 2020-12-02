package tellabsxcomtelindo.android.klikcoaching

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.activity_detail_category.*
import kotlinx.android.synthetic.main.fragment_categories.*
import tellabsxcomtelindo.android.klikcoaching.ui.ItemDetailCategoryAdapter
import tellabsxcomtelindo.android.klikcoaching.utils.DUmmyData


data class ItemMenu(val judul: String, val time: String, val img: Int)

class DetailCategoryActivity : AppCompatActivity() {
    val groupAdapter = GroupAdapter<GroupieViewHolder>()

    val listMenu = listOf<ItemMenu>(
        ItemMenu(
            "The Best Beginner Fingerstyle Guitar Lesson",
            "11m remaining",
            DUmmyData.mutableListImage[1]
        ),
        ItemMenu(
            "The Best Beginner Fingerstyle Guitar Lesson",
            "11m remaining",
            DUmmyData.mutableListImage[2]
        ),
        ItemMenu(
            "The Best Beginner Fingerstyle Guitar Lesson",
            "11m remaining",
            DUmmyData.mutableListImage[3]
        ),
        ItemMenu(
            "The Best Beginner Fingerstyle Guitar Lesson",
            "11m remaining",
            DUmmyData.mutableListImage[4]
        ),
        ItemMenu(
            "The Best Beginner Fingerstyle Guitar Lesson",
            "11m remaining",
            DUmmyData.mutableListImage[5]
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_category)
        setFullscreen()

        listMenu.forEach {
            groupAdapter.add(
                ItemDetailCategoryAdapter(it) {
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