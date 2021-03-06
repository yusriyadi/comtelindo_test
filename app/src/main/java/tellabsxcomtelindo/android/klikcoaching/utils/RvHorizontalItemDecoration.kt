package tellabsxcomtelindo.android.klikcoaching.utils

import android.graphics.Rect
import android.view.View
import androidx.core.view.marginLeft
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.absoluteValue

class RvHorizontalItemDecoration : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        outRect.top = 16
        if ( position== parent.adapter!!.itemCount - 1) {
            outRect.right = 32
        }
        if(position == 0){
            outRect.left = 32
        }
    }

}