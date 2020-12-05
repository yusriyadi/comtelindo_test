package tellabsxcomtelindo.android.klikcoaching.ui.kategori

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_categories.*
import tellabsxcomtelindo.android.klikcoaching.ui.detailcategory.DetailCategoryActivity
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.utils.DUmmyData.menusCategory
import tellabsxcomtelindo.android.klikcoaching.utils.rvGridDecortion


data class CategoryMenus(val img: Int, val title: String)
class CategoriesFragment : Fragment(R.layout.fragment_categories) {

    val groupAdapter = GroupAdapter<GroupieViewHolder>()





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        menusCategory.forEach {
            groupAdapter.add(ItemCategoryAdapter(it) {
                Toast.makeText(context, it.title, Toast.LENGTH_SHORT).show()
                Intent(context, DetailCategoryActivity::class.java).apply {
                    putExtra("img", it.img)
                    putExtra("title", it.title)
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

