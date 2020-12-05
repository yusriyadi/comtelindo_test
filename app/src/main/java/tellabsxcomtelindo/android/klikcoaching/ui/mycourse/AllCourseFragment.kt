package tellabsxcomtelindo.android.klikcoaching.ui.mycourse

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_all_course.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.data.Courses
import tellabsxcomtelindo.android.klikcoaching.ui.coursedetail.CourseDetailActivity
import tellabsxcomtelindo.android.klikcoaching.utils.DummyData


data class HeaderAndCourse(val title: String, val courses: List<Courses>)
class AllCourseFragment : Fragment(R.layout.fragment_all_course) {

    val dataDummy = mutableListOf<HeaderAndCourse>()

    val groupAdapter = GroupAdapter<GroupieViewHolder>()
    var i = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        for (i in 0..4) {
            val data = mutableListOf<Courses>()
            for (j in 0..2) {
                if(j %2 ==0){
                    data.add(DummyData.completeCourse[(5..9).random()])
                }
                else{
                    data.add(DummyData.completeCourse[(0..4).random()])
                }
            }
           dataDummy.add(HeaderAndCourse(DummyData.menusCategory[i].title, data))
        }

        dataDummy.forEach {datanya->

            ExpandableGroup(ExpandableHeaderItemCourse(datanya.title),if (i%4==0) false else true).apply {
                datanya.courses.forEach {
                    val itemChild = ItemMyCourseAdapter(it){
                        Intent(requireContext(), CourseDetailActivity::class.java).apply {
                            putExtra("course",Gson().toJson(it))
                            if (it.isWebBinar) putExtra("isThisDay",true) else putExtra("isThisDay",false)
                            startActivity(this)
                        }
                    }
                    add(itemChild)
                }
                groupAdapter.add(this)
            }
            i++
        }




        rvAllMyCourse.apply {

            adapter = groupAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }

    companion object {
        @JvmStatic
        fun newInstance() = AllCourseFragment()
    }

}

