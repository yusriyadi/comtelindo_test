package tellabsxcomtelindo.android.klikcoaching.ui.mycourse

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.ajalt.timberkt.d
import com.google.gson.Gson
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_all_course.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.data.Courses
import tellabsxcomtelindo.android.klikcoaching.ui.coursedetail.CourseDetailActivity
import tellabsxcomtelindo.android.klikcoaching.ui.courseplayer.CoursePlayerActivity
import tellabsxcomtelindo.android.klikcoaching.utils.DummyData
import tellabsxcomtelindo.android.klikcoaching.utils.DummyData.dataDummyAllCourse


data class HeaderAndCourse(val title: String, val courses: MutableList<Courses>)
class AllCourseFragment : Fragment(R.layout.fragment_all_course) {


    val groupAdapter = GroupAdapter<GroupieViewHolder>()
    var i = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        groupAdapter.clear()
        fetchDatas()



        rvAllMyCourse.apply {
            adapter = groupAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

    }


    override fun onResume() {
        super.onResume()

    }

    private fun fetchDatas() {

        lifecycleScope.launchWhenResumed {
            kotlin.runCatching {
                dataDummyAllCourse
            }.onSuccess { datas ->
                activity?.runOnUiThread {

                    datas.forEach { datanya ->
                        ExpandableGroup(
                            ExpandableHeaderItemCourse(datanya.title),
                            if (i % 4 == 0) false else true
                        ).apply {
                            datanya.courses.forEach {
                                val itemChild = ItemMyCourseAdapter(it) { datCourse ->

                                    if (!datCourse.isWebBinar) {

                                        Intent(
                                            requireContext(),
                                            CoursePlayerActivity::class.java
                                        ).apply { startActivity(this) }
                                        //                            kotlin.runCatching {
                                        //                                val sizeCourse = DummyData.dataDummyOfflineCourse.value?.filter { it.courses.equals(datCourse) }?.size
                                        //                                d { "sizee : $sizeCourse" }
                                        //                                if (sizeCourse == 0) {
                                        //                                    DummyData.dataDummyOfflineCourse.value?.apply {
                                        //                                        last().courses.add(datCourse)
                                        //                                        DummyData.dataDummyOfflineCourse.postValue(this)
                                        //                                    }
                                        //                                }
                                        //                            }.onSuccess {
                                        //                                d { "sukses" }
                                        //                            }.onFailure {
                                        //                                d { "error $it" }
                                        //                            }

                                    } else {
                                        Intent(
                                            requireContext(),
                                            CourseDetailActivity::class.java
                                        ).apply {
                                            putExtra("course", Gson().toJson(it))
                                            if (it.isWebBinar) putExtra(
                                                "isThisDay",
                                                true
                                            ) else putExtra("isThisDay", false)
                                            startActivity(this)
                                        }
                                    }
                                }
                                add(itemChild)
                            }
                            groupAdapter.add(this)
                        }
                        i++
                    }
                }
            }.onFailure {

            }
        }


    }

    companion object {
        @JvmStatic
        fun newInstance() = AllCourseFragment()
    }

}

