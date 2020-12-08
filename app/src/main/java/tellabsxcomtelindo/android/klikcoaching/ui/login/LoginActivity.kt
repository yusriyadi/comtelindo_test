package tellabsxcomtelindo.android.klikcoaching.ui.login

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface.BOLD
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.View
import android.view.WindowManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.ext.android.inject
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.data.PreferencesHelper
import tellabsxcomtelindo.android.klikcoaching.ui.home.MainActivity
import tellabsxcomtelindo.android.klikcoaching.ui.register.RegisterActivity

val isShowsClicked = MutableLiveData<Boolean>(false)

class LoginActivity : AppCompatActivity() {
    lateinit var pref :PreferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        pref = PreferencesHelper(this)

        btnListener()
        setFullScreen()


        tvBelumPUnyaAkun.setOnClickListener {
            Intent(this, RegisterActivity::class.java).apply {
                startActivity(this)
            }
        }
        setSpannableText()


        btnLogin.setOnClickListener {
            pref.saveBoolean(PreferencesHelper.IS_LOGGED_IN,true)
            Intent(this,MainActivity::class.java).apply {
                startActivity(this)
            }
            finish()
        }

    }

    private fun setSpannableText() {
        val text = "Anda Belum punya akun? Daftar"
        val spannable = SpannableStringBuilder(text)

        spannable.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.main_orange)),
            text.length - 6,
            text.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        tvBelumPUnyaAkun.text = spannable
    }

    private fun btnListener() {
        btnShowsPassword.setOnClickListener {
            isShowsClicked.value = isShowsClicked.value == false
        }
        isShowsClicked.observe(this, Observer {
            if (it) {
                edtPassword.transformationMethod = PasswordTransformationMethod()
            } else {
                edtPassword.transformationMethod = HideReturnsTransformationMethod()
            }
        })
    }

    private fun setFullScreen() {
        window.apply {
            clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                statusBarColor = Color.TRANSPARENT
            }
        }
    }

    override fun onResume() {
        isShowsClicked.value = false
        super.onResume()

    }
}