package tellabsxcomtelindo.android.klikcoaching.ui.mycourse

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_my_course.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.utils.ViewPagerAdapterTabsCourse

class MyCourceFragment:Fragment(R.layout.fragment_my_course) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        vpMyCourse.adapter = ViewPagerAdapterTabsCourse(this)
            TabLayoutMediator(tbMyCourse,vpMyCourse){tab,position->
                when(position){
                    0-> tab.text = "All Courses"
                    else -> tab.text = "Offline Course"
                }
            }.attach()
    }
    companion object{
        @JvmStatic
        fun newInstance() = MyCourceFragment()
    }

}

