package tellabsxcomtelindo.android.klikcoaching.ui.coursedetail.fargment

import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_section_topic.view.*
import tellabsxcomtelindo.android.klikcoaching.R

class ItemCourseTopic(val title: String,val groupAdapter: GroupAdapter<GroupieViewHolder>) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            tvTopicHeadTitle.text = title
            rvTopics.apply {
                layoutManager = LinearLayoutManager(viewHolder.itemView.context)
                adapter = groupAdapter
            }
        }
    }

    override fun getLayout() = R.layout.item_section_topic
}