package tellabsxcomtelindo.android.klikcoaching.ui.courseplayer.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_content_course.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.ui.courseplayer.ItemSectionCourseAdapter
import tellabsxcomtelindo.android.klikcoaching.ui.courseplayer.SectionHeaderCourseAdapter

class ContentFragment() : Fragment(R.layout.fragment_content_course) {

    val groupAdapter = GroupAdapter<GroupieViewHolder>()
    val topic = mutableListOf<String>("Topik 1", "Topik 2", "Topik 3")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        groupAdapter.add(Section(
            SectionHeaderCourseAdapter(
                "Section 1 - Introduction"
            )
        ))
        topic.forEach { groupAdapter.add(
            ItemSectionCourseAdapter(
                it
            )
        ) }

        groupAdapter.add(Section(
            SectionHeaderCourseAdapter(
                "Section 2 - Step 1"
            )
        ))
        topic.forEach { groupAdapter.add(
            ItemSectionCourseAdapter(
                it
            )
        ) }

        groupAdapter.add(Section(
            SectionHeaderCourseAdapter(
                "Section 3 - Step 2"
            )
        ))
        topic.forEach { groupAdapter.add(
            ItemSectionCourseAdapter(
                it
            )
        ) }

        groupAdapter.add(Section(
            SectionHeaderCourseAdapter(
                "Section 4 - Review"
            )
        ))
        topic.forEach { groupAdapter.add(
            ItemSectionCourseAdapter(
                it
            )
        ) }

        rvContentSectoin.apply {
            adapter = groupAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ContentFragment()
    }


}