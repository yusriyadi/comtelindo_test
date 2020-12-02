package tellabsxcomtelindo.android.klikcoaching.ui.kategori

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_row_grid.view.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.utils.loadImageFromDrawable

class ItemCategoryAdapter(val item: CategoryMenus, val click: (CategoryMenus) -> Unit) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.setOnClickListener {
            click(item)
        }
        viewHolder.itemView.apply {
            tvMenuTitle.text = item.title
            ivCategori.loadImageFromDrawable(item.img)
        }
    }

    override fun getLayout() = R.layout.item_row_grid
}