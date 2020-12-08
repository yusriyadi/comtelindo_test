package tellabsxcomtelindo.android.klikcoaching.ui.chatdiscussion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.github.ajalt.timberkt.d
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_choose_payment.*
import kotlinx.android.synthetic.main.activity_discussion_chat.*
import kotlinx.android.synthetic.main.dialog_add_comment.*
import kotlinx.coroutines.delay
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.utils.loadImageFromDrawable


data class Chat(val isUs: Boolean, val sender: String, val chat: String)

val chats = MutableLiveData(mutableListOf<Chat>(
    Chat(false, "Sahed", "Hellow My name is Sahed, I am based in France."),
    Chat(true, "Usery.id", "Hellow My name is Sahed, I am based in Milan"),
    Chat(false, "Hamsworth", "Hellow My name is Sahed, I am based in Italie."),
    Chat(false, "Hamsworth", "Hellow My name is Sahed, I am based in Italie."),
    Chat(true, "Usery.id", "Pokoe mantep lah"))
)

class DiscussionChatActivity : AppCompatActivity() {

    val groupAdapter = GroupAdapter<GroupieViewHolder>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discussion_chat)
        imageView25.loadImageFromDrawable(R.drawable.ic_baseline_supervised_user_circle_24)

        rvChat.apply {
            adapter = groupAdapter
            layoutManager = LinearLayoutManager(this@DiscussionChatActivity)
        }
        chats.value?.forEach {
            if (it.isUs) {
                groupAdapter.add(ItemChatAdapterRight(it))
            } else {
                groupAdapter.add(ItemChatAdapterLeft(it))
            }
        }


        btnAddComment.setOnClickListener {

            MaterialDialog(this).show {
                val view = customView(
                    R.layout.dialog_add_comment,
                    noVerticalPadding = true,
                    horizontalPadding = false
                )
                cornerRadius(16.0f)
                btnSendChat.setOnClickListener {
                    val chat = Chat(true, "Hanika", view.edtMsg.getText().toString())
                    groupAdapter.add(ItemChatAdapterRight(chat))
                    chats.value?.add(chat)
                    dismiss()
                }
                btnCancel.setOnClickListener {
                    dismiss()
                }

            }
            scrollToLastPosition()
        }


    }

    private fun scrollToLastPosition(){
        val last = chats.value?.lastIndex
        rvChat.scrollToPosition(3)
    }
}