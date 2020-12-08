package tellabsxcomtelindo.android.klikcoaching.ui.chatdiscussion

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_row_chat_left.view.*
import tellabsxcomtelindo.android.klikcoaching.R

class ItemChatAdapterLeft(val item : Chat): Item() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
            viewHolder.itemView.apply {
                tvPersonSend.text = item.sender
                tvChat.text = item.chat
            }
    }

    override fun getLayout() = R.layout.item_row_chat_left
}