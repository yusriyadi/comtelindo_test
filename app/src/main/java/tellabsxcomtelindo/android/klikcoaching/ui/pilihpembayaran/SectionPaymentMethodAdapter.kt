package tellabsxcomtelindo.android.klikcoaching.ui.pilihpembayaran

import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.section_payment_method.view.*
import tellabsxcomtelindo.android.klikcoaching.R

data class PaymentMethod(val name: String, val desc: String, val img: Int)

class SectionPaymentMethodAdapter(
    val title: String,
    val desc: String,
    val groupAdapter: GroupAdapter<GroupieViewHolder>
) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            tvPaymentTitle.text = title
            tvDescPaymentMethod.text = desc
            rvPymentMethodd.apply {
                layoutManager = LinearLayoutManager(this.context)
                adapter = groupAdapter
            }
        }
    }

    override fun getLayout() = R.layout.section_payment_method


}