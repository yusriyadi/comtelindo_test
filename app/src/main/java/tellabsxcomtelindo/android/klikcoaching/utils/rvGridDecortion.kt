package tellabsxcomtelindo.android.klikcoaching.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class rvGridDecortion() : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val manager = parent.layoutManager as GridLayoutManager?
        outRect.left = 32
        outRect.bottom = 0
        outRect.top = 0
        if (parent.getChildAdapterPosition(view)<manager!!.spanCount){
            outRect.top = 16
        }
        if (parent.getChildAdapterPosition(view)%2==1){
            outRect.right = 32
            outRect.left= 0
        }


    }

}