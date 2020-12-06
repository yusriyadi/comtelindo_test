package tellabsxcomtelindo.android.klikcoaching.ui.courseplayer.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_content_discussion.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.ui.courseplayer.ItemDiscussionAdapter

class DiscussionFragment() : Fragment(R.layout.fragment_content_discussion) {

    val groupAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        for (i in 1..4){
            groupAdapter.add(ItemDiscussionAdapter())
        }

        rvDiscussion.apply {
            adapter = groupAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            DiscussionFragment()
    }

}