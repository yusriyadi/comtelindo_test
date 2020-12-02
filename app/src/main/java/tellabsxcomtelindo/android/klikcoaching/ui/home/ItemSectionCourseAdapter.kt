package tellabsxcomtelindo.android.klikcoaching.ui.home

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_section_recomended_for_you.view.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.utils.RvHorizontalItemDecoration

class ItemSectionCourseAdapter(val groupAdapter: GroupAdapter<GroupieViewHolder>, val title : String,val isGridLayout : Boolean, val showAllListener:()->Unit): Item(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            tvTitleRecomended.text = title

            rvRecomendedCourse.apply {
                adapter = groupAdapter
                addItemDecoration(RvHorizontalItemDecoration())
                layoutManager = if (!isGridLayout){
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
                }else{
                    GridLayoutManager(context,2)
                }
            }

            tvLihatSemua.setOnClickListener {
                showAllListener()
            }

        }
    }

    override fun getLayout()= R.layout.item_section_recomended_for_you
}