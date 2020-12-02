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
import kotlinx.android.synthetic.main.item_section_recomended_for_you.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.data.HomeResponse
import tellabsxcomtelindo.android.klikcoaching.data.musicCategory1

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val mainGroupAdapter = GroupAdapter<GroupieViewHolder>()
    private val groupAdapterRecomendedForyou = GroupAdapter<GroupieViewHolder>()
    private val groupAdapterTerbaru = GroupAdapter<GroupieViewHolder>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        musicCategory1.courses.forEach {
            groupAdapterRecomendedForyou.add(ItemCourseAdapter(it) {
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

