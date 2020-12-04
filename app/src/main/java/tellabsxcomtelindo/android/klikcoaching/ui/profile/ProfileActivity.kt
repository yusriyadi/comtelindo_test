package tellabsxcomtelindo.android.klikcoaching.ui.profile



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.customview.customView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.dialog_choose_video_quality.*
import org.koin.android.ext.android.inject
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.data.PreferencesHelper

class ProfileActivity : AppCompatActivity() {
    val pref: PreferencesHelper by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        Glide.with(profileImg).load(R.drawable.ic_profile).centerCrop().circleCrop().into(profileImg)

        pref.getString(PreferencesHelper.CHOOSEN_RADIO_TEXT).let {
            if (!it.equals("")) {
                tvChoosenQuality.text = it
            }
        }

        btnBack.setOnClickListener {
            onBackPressed()
        }

        tvLabelQuality.setOnClickListener {
            MaterialDialog(this).show {
                val view = customView(R.layout.dialog_choose_video_quality, noVerticalPadding = true, horizontalPadding = false, dialogWrapContent = true)
                pref.getInt(PreferencesHelper.CHOOSEN_RADIO_ID)?.let {
                    if (it != 0) {
                        radio_button.check(it)
                    }
                }
                cornerRadius(16.0f)
                RadioButtonListener(view)
            }
        }

        tvChoosenQuality.setOnClickListener {
            tvLabelQuality.callOnClick()
        }

    }


    fun RadioButtonListener(view: MaterialDialog) {
        view.radio_button.setOnCheckedChangeListener { radioGroup, i ->
            val choosen = view.findViewById<RadioButton>(i)
            tvChoosenQuality.text = choosen.text
            pref.apply {
                saveString(PreferencesHelper.CHOOSEN_RADIO_TEXT, choosen.text.toString())
                saveInt(PreferencesHelper.CHOOSEN_RADIO_ID, i)
            }
            view.dismiss()
        }
    }

}