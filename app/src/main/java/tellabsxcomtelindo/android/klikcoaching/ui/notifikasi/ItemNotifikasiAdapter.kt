package tellabsxcomtelindo.android.klikcoaching.ui.notifikasi

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_row_notification.view.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.utils.loadImageFromDrawable

class ItemNotifikasiAdapter(val img : Int):Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.ivNotifImage.loadImageFromDrawable(img)
    }

    override fun getLayout() = R.layout.item_row_notification
}