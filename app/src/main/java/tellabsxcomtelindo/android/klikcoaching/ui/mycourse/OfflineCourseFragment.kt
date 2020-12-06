package tellabsxcomtelindo.android.klikcoaching.ui.mycourse

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.ajalt.timberkt.d
import com.google.gson.Gson
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_offline_course.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.data.Courses
import tellabsxcomtelindo.android.klikcoaching.ui.coursedetail.CourseDetailActivity
import tellabsxcomtelindo.android.klikcoaching.ui.courseplayer.CoursePlayerActivity
import tellabsxcomtelindo.android.klikcoaching.utils.DummyData

class OfflineCourseFragment : Fragment(R.layout.fragment_offline_course) {

    val groupAdapter = GroupAdapter<GroupieViewHolder>()
    var i = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        DummyData.dataDummyOfflineCourse.observe(viewLifecycleOwner, Observer {
            d{"sssss : $it"}
            groupAdapter.clear()
            it.forEach { datanya ->
                ExpandableGroup(ExpandableHeaderItemCourse(datanya.title), if (i % 4 == 1) false else true).apply {
                    datanya.courses.forEach {
                        val itemChild = ItemMyCourseAdapter(it) { courseData: Courses ->
                            Intent(requireContext(), CoursePlayerActivity::class.java).apply{startActivity(this)}
                        }
                        add(itemChild)
                    }
                    groupAdapter.add(this)
                }
                i++
            }


        })


        rvOfflineCourse.apply {
            adapter = groupAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }


    }

    companion object {
        @JvmStatic
        fun newInstance() = OfflineCourseFragment()
    }

    override fun onResume() {
        super.onResume()
    }
}

