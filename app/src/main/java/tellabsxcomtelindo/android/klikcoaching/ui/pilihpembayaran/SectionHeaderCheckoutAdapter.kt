package tellabsxcomtelindo.android.klikcoaching.ui.pilihpembayaran

import android.view.View
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.section_header_checkout_payment.view.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.utils.loadImageFromDrawable

class SectionHeaderCheckoutAdapter (): Item(){
    var isExpanded = false
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            headerBill.setOnClickListener {
                if(!isExpanded){
                    isExpanded = true
                    ivArrow.loadImageFromDrawable(R.drawable.ic_baseline_keyboard_arrow_down_24)
                    expandedBill.visibility = View.VISIBLE
                }
                else{
                    ivArrow.loadImageFromDrawable(R.drawable.ic_baseline_keyboard_arrow_up_24)
                    isExpanded = false
                    expandedBill.visibility = View.GONE
                }
            }
        }
    }

    override fun getLayout() = R.layout.section_header_checkout_payment
}