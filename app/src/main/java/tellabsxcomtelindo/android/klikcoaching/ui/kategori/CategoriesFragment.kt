package tellabsxcomtelindo.android.klikcoaching.ui.kategori

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_categories.*
import tellabsxcomtelindo.android.klikcoaching.DetailCategoryActivity
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.ui.home.MainActivity
import tellabsxcomtelindo.android.klikcoaching.utils.rvGridDecortion


data class CategoryMenus(val img: Int, val title: String)
class CategoriesFragment : Fragment(R.layout.fragment_categories) {

    val groupAdapter = GroupAdapter<GroupieViewHolder>()

    val menusCategory = listOf<CategoryMenus>(
        CategoryMenus(R.drawable.img_single_guitar, "Music"),
        CategoryMenus(R.drawable.img_yellow_decoration, "Design"),
        CategoryMenus(R.drawable.img_coding, "Programming"),
        CategoryMenus(R.drawable.img_car_engine, "Automative"),
        CategoryMenus(R.drawable.img_workshop, "Mechanical"),
        CategoryMenus(R.drawable.img_calculator, "Finance")
    )



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        menusCategory.forEach {
            groupAdapter.add(ItemCategoryAdapter(it) {
                Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
                Intent(context, DetailCategoryActivity::class.java).apply {
                    startActivity(this)
                }
            })
        }

        rvCategory.apply {
            addItemDecoration(rvGridDecortion())
            layoutManager = GridLayoutManager(context, 2)
            adapter = groupAdapter

        }
    }



    companion object {
        @JvmStatic
        fun newInstance() = CategoriesFragment()
    }

    override fun onResume() {
        super.onResume()
    }

}

