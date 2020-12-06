package tellabsxcomtelindo.android.klikcoaching.ui.courseplayer

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_section_content.view.*
import tellabsxcomtelindo.android.klikcoaching.R

class SectionHeaderCourseAdapter (val title : String): Item(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            tvSectionTItle.text = title
        }
    }

    override fun getLayout() = R.layout.item_section_content
}