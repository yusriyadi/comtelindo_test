package tellabsxcomtelindo.android.klikcoaching.ui.home

import ViewPagerAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.github.ajalt.timberkt.d
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.ui.kategori.CategoriesFragment
import tellabsxcomtelindo.android.klikcoaching.ui.mycourse.MyCourceFragment
import tellabsxcomtelindo.android.klikcoaching.ui.notifikasi.NotifikasiActivity
import tellabsxcomtelindo.android.klikcoaching.ui.payment.PaymentFragment
import tellabsxcomtelindo.android.klikcoaching.ui.profile.ProfileActivity

class MainActivity : AppCompatActivity() {
    var isClicked = false
    private lateinit var showAnimation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        showAnimation = AnimationUtils.loadAnimation(this, R.anim.downtoupfaster)

        initViewPager()
        bottonNavListener()


        btnProfile.setOnClickListener {
            isClicked =false
            cardDropDown.visibility = View.GONE
            layer.visibility = View.GONE
            bottomNavigationView.elevation = 8f
            Intent(this, ProfileActivity::class.java).apply { startActivity(this) }
        }
        layer.setOnClickListener {
            isClicked =false
            layer.visibility = View.GONE
            cardDropDown.visibility = View.GONE
            bottomNavigationView.elevation = 8f
        }


    }

    private fun bottonNavListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_beranda -> {
                    viewPager.currentItem = 0
                    toolbar.visibility = View.VISIBLE
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_kategori -> {
                    viewPager.currentItem = 1
                    toolbar.visibility = View.GONE
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_kelas_saya -> {
                    toolbar.visibility = View.VISIBLE
                    viewPager.currentItem = 2
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.menu_pembayaran -> {
                    toolbar.visibility = View.VISIBLE
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_action, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_bell -> {
                goNotif()
             Log.d("MainAc", "bell")
                 true
            }
            R.id.menu_vert -> {
                d{"vert"}
                if(isClicked){
                    isClicked =false
                    cardDropDown.visibility = View.GONE
                    layer.visibility = View.GONE
                    bottomNavigationView.elevation = 8f


                }
                else{
                    isClicked =true
                    cardDropDown.visibility = View.VISIBLE
                    cardDropDown.startAnimation(showAnimation)
                    layer.visibility = View.VISIBLE
                    bottomNavigationView.elevation = 0f

                }

                 true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun goNotif(){
        Intent(this, NotifikasiActivity::class.java).apply { startActivity(this) }
    }
}