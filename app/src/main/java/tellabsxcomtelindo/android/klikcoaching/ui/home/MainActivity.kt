package tellabsxcomtelindo.android.klikcoaching.ui.home

import ViewPagerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_main.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.ui.kategori.CategoriesFragment
import tellabsxcomtelindo.android.klikcoaching.ui.mycourse.MyCourceFragment
import tellabsxcomtelindo.android.klikcoaching.ui.payment.PaymentFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        initViewPager()
        bottonNavListener()

    }

    private fun bottonNavListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_beranda -> {
                    viewPager.currentItem = 0
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_kategori -> {
                    viewPager.currentItem = 1
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_kelas_saya -> {
                    viewPager.currentItem = 2
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_pembayaran -> {
                    viewPager.currentItem = 3
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }
    }

    private fun initViewPager() {
        viewPager.offscreenPageLimit = 3
        ViewPagerAdapter(supportFragmentManager).apply {
            addFragment(HomeFragment.newInstance())
            addFragment(CategoriesFragment.newInstance())
            addFragment(MyCourceFragment.newInstance())
            addFragment(PaymentFragment.newInstance())
            viewPager.adapter = this
        }
    }

}