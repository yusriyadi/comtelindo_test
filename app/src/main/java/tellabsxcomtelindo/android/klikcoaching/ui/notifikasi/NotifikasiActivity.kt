package tellabsxcomtelindo.android.klikcoaching.ui.notifikasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_notifikasi.*
import tellabsxcomtelindo.android.klikcoaching.R

class NotifikasiActivity : AppCompatActivity() {
    val groupAdapter = GroupAdapter<GroupieViewHolder>()


    val dummy = mutableListOf<Int>(
        R.drawable.ic_video,
        R.drawable.ic_vector_chat,
        R.drawable.ic_vector_chat,
        R.drawable.ic_vector_chat,
        R.drawable.ic_vector_chat,
        R.drawable.ic_vector_chat
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifikasi)

        dummy.forEach {
            groupAdapter.add(ItemNotifikasiAdapter(it))
        }

        rvNotif.apply {
            layoutManager = LinearLayoutManager(this@NotifikasiActivity)
            adapter = groupAdapter
        }

    }
}