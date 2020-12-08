package tellabsxcomtelindo.android.klikcoaching.ui.paymentsuccess

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_payment_successfully.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.ui.home.MainActivity

class PaymentSuccessfullyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment_successfully)

        button2.setOnClickListener {
            Intent(this, MainActivity::class.java).apply {
                action = "openMyCourse"
                startActivity(this)
            }
        }
    }
}