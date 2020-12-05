package tellabsxcomtelindo.android.klikcoaching.ui.mycourse

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_row_my_course.view.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.data.Courses
import tellabsxcomtelindo.android.klikcoaching.utils.loadImageFromDrawable

class ItemMyCourseAdapter(val item : Courses, val onclickListener : (Courses)->Unit): Item(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            tvTitleMyCourse.text = item.title
            tvTimeCourse.text = item.duration+if(item.isWebBinar) " (web binar)" else " "
            ivMyCourse.loadImageFromDrawable(item.imageBanner)
            setOnClickListener {
                onclickListener(item)
            }
        }
    }

    override fun getLayout()= R.layout.item_row_my_course
}