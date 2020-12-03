package tellabsxcomtelindo.android.klikcoaching.ui.coursedetail.fargment

import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_section_author.view.*
import kotlinx.android.synthetic.main.item_section_topic.view.*
import tellabsxcomtelindo.android.klikcoaching.R

class ItemSectionSyaratKetentuan() : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {

        }
    }

    override fun getLayout() = R.layout.item_section_syarat
}