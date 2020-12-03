package tellabsxcomtelindo.android.klikcoaching.ui.detailcategory

import android.view.View
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_row_course_vertical.view.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.data.Courses
import tellabsxcomtelindo.android.klikcoaching.utils.loadImageFromDrawable

    class ItemDetailCategoryAdapter(val item : Courses, val click: (Courses) -> Unit) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener {
            click(item)
        }
        viewHolder.itemView.apply {
            if(item.isWebBinar) webinar.visibility = View.VISIBLE
            tvTitle.text = item.title
            tvTime.text = item.duration
            ivImage.loadImageFromDrawable(item.imageBanner)
        }
    }

    override fun getLayout() = R.layout.item_row_course_vertical
}