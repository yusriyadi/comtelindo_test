package tellabsxcomtelindo.android.klikcoaching.ui.coursedetail.fargment

import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_section_topic.view.*
import kotlinx.android.synthetic.main.item_sub_topic.view.*
import tellabsxcomtelindo.android.klikcoaching.R

class ItemCourseSubTopic(val title: String) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            tvSubTopicTitle.text = title
        }
    }

    override fun getLayout() = R.layout.item_sub_topic
}