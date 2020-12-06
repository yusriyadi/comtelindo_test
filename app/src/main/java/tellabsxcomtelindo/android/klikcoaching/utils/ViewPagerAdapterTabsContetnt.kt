package tellabsxcomtelindo.android.klikcoaching.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import tellabsxcomtelindo.android.klikcoaching.ui.courseplayer.fragment.ContentFragment
import tellabsxcomtelindo.android.klikcoaching.ui.courseplayer.fragment.DiscussionFragment

class ViewPagerAdapterTabsContetnt(fm: FragmentActivity) : FragmentStateAdapter(fm) {

    override fun getItemCount(): Int =2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 ->  ContentFragment.newInstance()
            else ->  DiscussionFragment.newInstance()
        }
    }
}