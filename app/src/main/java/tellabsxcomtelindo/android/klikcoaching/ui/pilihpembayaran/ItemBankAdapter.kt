package tellabsxcomtelindo.android.klikcoaching.ui.pilihpembayaran

import com.bumptech.glide.Glide
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_row_bank_method.view.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.utils.loadImageFromDrawable

class ItemBankAdapter(val img: Int, val name: String, val listener: (String) -> Unit) : Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            Glide.with(ivBankImg).load(img).into(ivBankImg)
            ivBankImg.setOnClickListener {
                listener(name)
            }
        }
    }

    override fun getLayout() = R.layout.item_row_bank_method

}