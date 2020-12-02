package tellabsxcomtelindo.android.klikcoaching.ui.register

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_hobies.view.*
import kotlinx.coroutines.delay
import org.koin.android.scope.lifecycleScope
import tellabsxcomtelindo.android.klikcoaching.R

data class Hobies(val data: String, var isChecked: Boolean)

class HobiesAdapter(
    val lifecycleOwner: LifecycleCoroutineScope,
    var item: Hobies,
    val clickListener: (Hobies) -> Unit
) : Item() {
    var isChecked = MutableLiveData(false)

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {

            lifecycleOwner.launchWhenResumed {
                delay(100)
                if (item.isChecked == true) {
                    btnCheck.visibility = View.VISIBLE
                } else {
                    btnCheck.visibility = View.GONE
                }
            }
            checkedTextView.text = item.data
            setOnClickListener {
                if (isChecked.value == false) {
                    isChecked.value = true
                    clickListener(Hobies(item.data, true))
                    btnCheck.visibility = View.VISIBLE
                } else {
                    btnCheck.visibility = View.GONE
                    clickListener(Hobies(item.data, false))
                    isChecked.value = false
                }
            }
        }
    }

    override fun getLayout() = R.layout.item_hobies

}

