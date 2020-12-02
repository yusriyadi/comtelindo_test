package tellabsxcomtelindo.android.klikcoaching.ui.home

import androidx.core.view.marginBottom
import androidx.core.view.marginRight
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_row_course.view.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.data.Courses
import tellabsxcomtelindo.android.klikcoaching.utils.loadImageFromDrawable

class ItemCourseAdapter(
  val course : Courses,
    val clicklistener: (Courses) -> Unit
) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {

        viewHolder.itemView.apply {
            tvTitle.text = course.title
            tvAuthor.text = course.author.name
            imgPoster.loadImageFromDrawable(course.imageBanner)
        }

    viewHolder.itemView.setOnClickListener {
        clicklistener(course)
    }
    }

    override fun getLayout() = R.layout.item_row_course
}