package tellabsxcomtelindo.android.klikcoaching.ui.coursedetail.fargment

import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.activity_course_detail.view.*
import kotlinx.android.synthetic.main.item_row_review.view.*
import kotlinx.android.synthetic.main.item_section_topic.view.*
import kotlinx.android.synthetic.main.item_sub_topic.view.*
import tellabsxcomtelindo.android.klikcoaching.R


data class CourseReview(val reviewerName : String, val rating : Double, val review : String)
class ItemCourseReview(val item : CourseReview) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            tvReviewer.text = item.reviewerName
            tvCourseRate.rating =item.rating.toFloat()
            tvReview.text = item.review
        }
    }

    override fun getLayout() = R.layout.item_row_review
}