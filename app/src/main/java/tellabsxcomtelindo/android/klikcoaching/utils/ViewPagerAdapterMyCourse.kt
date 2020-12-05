package tellabsxcomtelindo.android.klikcoaching.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import tellabsxcomtelindo.android.klikcoaching.ui.coursedetail.fargment.DesciptionFragment
import tellabsxcomtelindo.android.klikcoaching.ui.coursedetail.fargment.UlasanFragment
import tellabsxcomtelindo.android.klikcoaching.ui.mycourse.AllCourseFragment
import tellabsxcomtelindo.android.klikcoaching.ui.mycourse.OfflineCourseFragment

class ViewPagerAdapterTabsCourse(fm: Fragment) : FragmentStateAdapter(fm) {

    override fun getItemCount(): Int =2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 ->  AllCourseFragment.newInstance()
            else ->  OfflineCourseFragment.newInstance()
        }
    }
}