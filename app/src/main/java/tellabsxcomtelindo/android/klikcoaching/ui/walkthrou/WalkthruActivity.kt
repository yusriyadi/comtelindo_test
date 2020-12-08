package tellabsxcomtelindo.android.klikcoaching.ui.walkthrou

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_walkthru.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.data.PreferencesHelper
import tellabsxcomtelindo.android.klikcoaching.ui.home.MainActivity
import tellabsxcomtelindo.android.klikcoaching.ui.login.LoginActivity
import tellabsxcomtelindo.android.klikcoaching.utils.DummyData

class WalkthruActivity : AppCompatActivity() {


    lateinit var pref: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walkthru)
        pref = PreferencesHelper(this)

        if (pref.getBoolean(PreferencesHelper.IS_LOGGED_IN)) {
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
            }
            finish()
        }

        btnMulai.isEnabled = false
        btnMulai.setOnClickListener {
            Intent(this, LoginActivity::class.java).apply {
                startActivity(this)
            }
        }
        Toast.makeText(this, "Loading data...", Toast.LENGTH_SHORT).show()
        lifecycleScope.launch(Dispatchers.Main) {

            kotlin.runCatching {
                DummyData.generateData()
            }.onSuccess {
                btnMulai.isEnabled = true
                Toast.makeText(this@WalkthruActivity, "Data berhasil dimuat", Toast.LENGTH_SHORT).show()
            }.onFailure {
                Toast.makeText(this@WalkthruActivity, "gagal buka ulang aplikasi", Toast.LENGTH_SHORT).show()
            }

        }


    }

    override fun onResume() {
        super.onResume()

        kotlin.runCatching {
            mutableListOf<Int>(
                R.drawable.img_calculator,
                R.drawable.img_coloring_tools,
                R.drawable.img_guitar,
                R.drawable.img_car_engine,
                R.drawable.img_slider2
            )
        }.onSuccess { images ->
            runOnUiThread {
                viewPager.adapter = WalktrueCardAdapter(images)
                viewPager.smallScaleFactor = 0.9f
            }

        }.onFailure {

        }

    }

}
