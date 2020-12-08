package tellabsxcomtelindo.android.klikcoaching.ui.home

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.xwray.groupie.GroupAdapter

import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.ui.coursedetail.CourseDetailActivity
import tellabsxcomtelindo.android.klikcoaching.utils.DummyData


class HomeFragment : Fragment(R.layout.fragment_home) {


    private val mainGroupAdapter = GroupAdapter<GroupieViewHolder>()
    private val groupAdapterRecomendedForyou = GroupAdapter<GroupieViewHolder>()
    private val groupAdapterTerbaru = GroupAdapter<GroupieViewHolder>()


    override fun onStart() {
        super.onStart()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvHomeFrag.apply {
            adapter = mainGroupAdapter
            layoutManager = LinearLayoutManager(context)
        }


                for (i in 0..9) {
                    if (i <= 4) {
                        addCourseToAdapter(i)
                    } else if (i >= 5) {
                        addNewCourse(i)
                    }
                }

                activity?.runOnUiThread {

                    mainGroupAdapter.clear()
                    mainGroupAdapter.add(Section(ItemBannerAdaper()))
                    mainGroupAdapter.add(
                        Section(
                            ItemSectionCourseAdapter(
                                groupAdapterRecomendedForyou,
                                "Rekomendasi untuk Anda",
                                false
                            ) {
                                Toast.makeText(context, "lihat semua", Toast.LENGTH_SHORT).show()
                            })
                    )

                    mainGroupAdapter.add(
                        Section(
                            ItemSectionCourseAdapter(
                                groupAdapterTerbaru,
                                "Materi Seminar baru!",
                                true
                            ) {
                                Toast.makeText(context, "lihat semua", Toast.LENGTH_SHORT).show()
                            })
                    )
                }




    }

    override fun onResume() {
        super.onResume()


    }

    private fun addCourseToAdapter(i: Int) {
        groupAdapterRecomendedForyou.add(ItemCourseAdapter(DummyData.completeCourse[i]) {
            Intent(requireContext(), CourseDetailActivity::class.java).apply {
                putExtra("course", Gson().toJson(it))
                startActivity(this)
            }
        })
    }

    private fun addNewCourse(i: Int) {
        groupAdapterTerbaru.add(ItemCourseAdapter(DummyData.completeCourse[i]) {
            Intent(requireContext(), CourseDetailActivity::class.java).apply {
                putExtra("course", Gson().toJson(it))
                startActivity(this)
            }
        })
    }


    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

}

