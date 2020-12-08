package tellabsxcomtelindo.android.klikcoaching.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.text.style.ForegroundColorSpan
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.afollestad.materialdialogs.LayoutMode
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.bottomsheets.BottomSheet
import com.afollestad.materialdialogs.customview.customView
import com.github.ajalt.timberkt.d
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.layout_bottom_sheet_hobies.*
import org.koin.android.ext.android.inject
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.data.PreferencesHelper
import tellabsxcomtelindo.android.klikcoaching.ui.home.MainActivity
import tellabsxcomtelindo.android.klikcoaching.ui.login.LoginActivity

class RegisterActivity : AppCompatActivity() {

    lateinit var pref :PreferencesHelper

    val listItemHobies = mutableListOf<HobiesAdapter>()
    val hobies = MutableLiveData(
        mutableListOf<Hobies>(
            Hobies("Development", false),
            Hobies("Design", false),
            Hobies("Marketing", false),
            Hobies("lifestyle", false),
            Hobies("Music", false)
        )
    )

    val hobieAdapter = GroupAdapter<GroupieViewHolder>()

    var showPass = false
    var showConfirmPass = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        pref = PreferencesHelper(this)
        setSupportActionBar(toolbar_register)
        setSpannableToTermTextView()

        hobies.value?.forEach {
            listItemHobies.add(HobiesAdapter(lifecycleScope, it) { hobie ->
                hobies.value!!.filter { it.data.equals(hobie.data) }[0].isChecked = hobie.isChecked
            })
        }


        btnDaftar.setOnClickListener {
            pref.saveBoolean(PreferencesHelper.IS_LOGGED_IN, true)
            Intent(this, MainActivity::class.java).apply {
                startActivity(this)
            }
            finish()
        }

        hobieAdapter.addAll(listItemHobies)


        btnAlreadyHave.setOnClickListener {
            Intent(this, LoginActivity::class.java).apply {
                startActivity(this)
            }
        }

        btnShowsHobie.setOnClickListener {
            MaterialDialog(this, BottomSheet(LayoutMode.WRAP_CONTENT)).show {
                val custome_view = customView(R.layout.layout_bottom_sheet_hobies)
                cornerRadius(16f)
                custome_view.recyclerView.apply {
                    layoutManager = LinearLayoutManager(this@RegisterActivity)
                    adapter = hobieAdapter
                }
                custome_view.btnPilih.setOnClickListener {
                    showSelectedHobbies()
                    dismiss()
                }
                custome_view.btnBatal.setOnClickListener {
                    dismiss()
                }
            }
        }

        btnShowPass.setOnClickListener {
            if (showPass) {
                edtPass.transformationMethod = PasswordTransformationMethod()
                showPass = false
            } else {
                showPass = true
                edtPass.transformationMethod = HideReturnsTransformationMethod()
            }
        }
        btnShowConfirmPass.setOnClickListener {
            if (showConfirmPass) {
                showConfirmPass = false
                edtConfirmPass.transformationMethod = PasswordTransformationMethod()
            } else {
                showConfirmPass = true
                edtConfirmPass.transformationMethod = HideReturnsTransformationMethod()
            }
        }


    }

    private fun showSelectedHobbies() {
        val string = hobies.value!!.filter { it.isChecked == true }.map { it.data }
        val text = string.joinToString { it }
        Log.d("isi list", hobies.value.toString())
        edtHobbies.setText(text)
    }

    private fun setSpannableToTermTextView() {
        val text1 = "Clicking register means that you agree to the "
        val text2 = "Terms & Condition "
        val text3 = "And "
        val text4 = "Privacy policy "

        val combinedText = text1 + text2 + text3 + text4
        val spanable = SpannableStringBuilder(combinedText)

        spanable.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.main_blue))
            , text1.length, text1.length + text2.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        spanable.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.main_blue))
            ,
            text1.length + text2.length + text3.length,
            text1.length + text2.length + text3.length + text4.length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        tvTermCondition.text = spanable
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}