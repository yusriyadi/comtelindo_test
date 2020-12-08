package tellabsxcomtelindo.android.klikcoaching.ui.walkthrou

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.islamkhsh.CardSliderAdapter
import kotlinx.android.synthetic.main.item_card_slider.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.utils.loadImageFromDrawable
import tellabsxcomtelindo.android.klikcoaching.utils.loadImageFromDrawableCircle

class WalktrueCardAdapter(val images: List<Int>) :
    CardSliderAdapter<WalktrueCardAdapter.WaltrueViewHolder>() {


    override fun bindVH(holder: WaltrueViewHolder, position: Int) {
        val image = images[position]
        holder.itemView.run {
            ivSlider.loadImageFromDrawableCircle(image)
        }

    }

    override fun getItemCount() = images.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WaltrueViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_card_slider, parent, false)
        return WaltrueViewHolder(view)
    }
    class WaltrueViewHolder(view: View) : RecyclerView.ViewHolder(view)
}