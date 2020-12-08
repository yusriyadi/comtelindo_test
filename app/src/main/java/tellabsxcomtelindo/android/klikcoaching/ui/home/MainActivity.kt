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
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.viewpager.widget.ViewPager
import com.github.ajalt.timberkt.d
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.data.PreferencesHelper
import tellabsxcomtelindo.android.klikcoaching.ui.kategori.CategoriesFragment
import tellabsxcomtelindo.android.klikcoaching.ui.mycourse.MyCourceFragment
import tellabsxcomtelindo.android.klikcoaching.ui.notifikasi.NotifikasiActivity
import tellabsxcomtelindo.android.klikcoaching.ui.payment.PaymentFragment
import tellabsxcomtelindo.android.klikcoaching.ui.profile.ProfileActivity
import tellabsxcomtelindo.android.klikcoaching.ui.walkthrou.WalkthruActivity
import tellabsxcomtelindo.android.klikcoaching.ui.walkthrou.WalktrueCardAdapter
import tellabsxcomtelindo.android.klikcoaching.utils.DummyData

class MainActivity : AppCompatActivity() {
    private var prevMenuItem: MenuItem? = null
    var isClicked = false
    private var back_pressed: Long = 0

    lateinit var pref: PreferencesHelper

    //    private lateinit var showAnimation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        pref = PreferencesHelper(this)
//        showAnimation = AnimationUtils.loadAnimation(this, R.anim.downtoupfaster)


        initUi()


    }

    override fun onResume() {
        super.onResume()

    }

    private fun initUi() {
        initViewPager()
        bottonNavListener()
        if (intent.action == "openMyCourse") {
            bottomNavigationView.selectedItemId = R.id.menu_kelas_saya
            intent.action = ""
        }

        btnProfile.setOnClickListener {
            isClicked = false
            cardDropDown.visibility = View.GONE
            layer.visibility = View.GONE
            bottomNavigationView.elevation = 8f
            Intent(this, ProfileActivity::class.java).apply { startActivity(this) }
        }
        layer.setOnClickListener {
            isClicked = false
            layer.visibility = View.GONE
            cardDropDown.visibility = View.GONE
            bottomNavigationView.elevation = 8f
        }
        btnLogOut.setOnClickListener {
            pref.saveBoolean(PreferencesHelper.IS_LOGGED_IN, false)
            Intent(this, WalkthruActivity::class.java).apply {
                startActivity(this)
            }
            finish()
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

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if (prevMenuItem != null) {
                    prevMenuItem?.isChecked = false
                } else {
                    bottomNavigationView.menu.getItem(0).isChecked = false
                }
                bottomNavigationView.menu.getItem(position)
            }
        })
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
                d { "vert" }
                if (isClicked) {
                    isClicked = false
                    cardDropDown.visibility = View.GONE
                    layer.visibility = View.GONE
                    bottomNavigationView.elevation = 8f


                } else {
                    isClicked = true
                    cardDropDown.visibility = View.VISIBLE
//                    cardDropDown.startAnimation(showAnimation)
                    layer.visibility = View.VISIBLE
                    bottomNavigationView.elevation = 0f

                }

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun goNotif() {
        Intent(this, NotifikasiActivity::class.java).apply { startActivity(this) }
    }

    override fun onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
        } else Toast.makeText(this, "Press once again to exit!", Toast.LENGTH_SHORT).show()
        back_pressed = System.currentTimeMillis()
    }
}