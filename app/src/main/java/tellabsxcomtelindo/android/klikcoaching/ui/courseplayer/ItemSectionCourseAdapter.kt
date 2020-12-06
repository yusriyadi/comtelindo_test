package tellabsxcomtelindo.android.klikcoaching.ui.courseplayer

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_row_content.view.*
import tellabsxcomtelindo.android.klikcoaching.R

class ItemSectionCourseAdapter (val title : String): Item(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            tvTopic.text = title
        }
    }

    override fun getLayout() = R.layout.item_row_content
}