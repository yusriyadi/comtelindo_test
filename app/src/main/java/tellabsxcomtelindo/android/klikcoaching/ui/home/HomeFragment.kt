package tellabsxcomtelindo.android.klikcoaching.ui.home

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter

import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_home.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.data.*
import tellabsxcomtelindo.android.klikcoaching.utils.DUmmyData.coursesRecomeded
import tellabsxcomtelindo.android.klikcoaching.utils.DUmmyData.newComerCource

class HomeFragment : Fragment(R.layout.fragment_home) {


    private val mainGroupAdapter = GroupAdapter<GroupieViewHolder>()
    private val groupAdapterRecomendedForyou = GroupAdapter<GroupieViewHolder>()
    private val groupAdapterTerbaru = GroupAdapter<GroupieViewHolder>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        coursesRecomeded.forEach {
            groupAdapterRecomendedForyou.add(ItemCourseAdapter(it) {
                Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
            })
        }

        newComerCource.forEach {
            groupAdapterTerbaru.add(ItemCourseAdapter(it) {
                Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
            })
        }




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


        rvHomeFrag.apply {
            adapter = mainGroupAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }



    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

}

