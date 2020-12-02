package tellabsxcomtelindo.android.klikcoaching.ui

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_row_course_vertical.view.*
import kotlinx.android.synthetic.main.item_row_grid.view.*
import tellabsxcomtelindo.android.klikcoaching.ItemMenu
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.utils.loadImageFromDrawable

class ItemDetailCategoryAdapter(val item : ItemMenu, val click: (String) -> Unit) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener {
            click(item.judul)
        }
        viewHolder.itemView.apply {
            tvTitle.text = item.judul
            tvTime.text = item.time
        }
    }

    override fun getLayout() = R.layout.item_row_course_vertical
}