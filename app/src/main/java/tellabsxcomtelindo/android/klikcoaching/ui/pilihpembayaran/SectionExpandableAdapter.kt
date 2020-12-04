package tellabsxcomtelindo.android.klikcoaching.ui.pilihpembayaran

import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item

class SectionExpandableAdapter (): Item(),ExpandableItem{
    private lateinit var expandableGroup: ExpandableGroup
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getLayout(): Int {
        TODO("Not yet implemented")
    }

    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
            this.expandableGroup = onToggleListener
    }
}