package tellabsxcomtelindo.android.klikcoaching.ui.mycourse

import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_header_my_course.view.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.utils.loadImageFromDrawable

class ExpandableHeaderItemCourse (val title : String): Item(),ExpandableItem{

    private lateinit var expandableGroup: ExpandableGroup

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            tvTitleN.text = title
            viewHolder.itemView.ivHeaderArrow.loadImageFromDrawable(getRotateiconResId())
            setOnClickListener {
                expandableGroup.onToggleExpanded()
                viewHolder.itemView.ivHeaderArrow.loadImageFromDrawable(getRotateiconResId())
            }
        }
    }

    override fun getLayout()= R.layout.item_header_my_course

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        expandableGroup = onToggleListener
    }

    fun getRotateiconResId()= if(expandableGroup.isExpanded) R.drawable.ic_baseline_keyboard_arrow_up_24 else R.drawable.ic_baseline_keyboard_arrow_down_24
}