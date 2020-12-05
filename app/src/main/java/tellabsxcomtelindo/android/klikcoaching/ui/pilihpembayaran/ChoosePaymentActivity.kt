package tellabsxcomtelindo.android.klikcoaching.ui.pilihpembayaran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_choose_payment.*
import kotlinx.android.synthetic.main.fragment_desciption.*
import tellabsxcomtelindo.android.klikcoaching.R
import tellabsxcomtelindo.android.klikcoaching.ui.paymentsuccess.PaymentSuccessfullyActivity

class ChoosePaymentActivity : AppCompatActivity() {

    val groupAdapter = GroupAdapter<GroupieViewHolder>()
    val prakerjaAdapter = GroupAdapter<GroupieViewHolder>()
    val atmAdapter = GroupAdapter<GroupieViewHolder>()
    val ewalletAdapter = GroupAdapter<GroupieViewHolder>()
    val prakerja = mutableListOf<PaymentMethod>(
        PaymentMethod(
            "PRAKERJA",
            "Pembayaran terhubung langsung dengan Kartu Prakerja Anda",
            R.drawable.ic_prakerja
        )
    )
    val ewallet = mutableListOf<PaymentMethod>(
        PaymentMethod("GOPAY", "Gunakan dana pada dompet digital Anda", R.drawable.ic_gopay)
    )
    val atm = mutableListOf<PaymentMethod>(
        PaymentMethod(
            "BCA",
            "Gunakan kode unik diakhir nominal untuk verifikasi otomatis",
            R.drawable.ic_bca
        ),
        PaymentMethod(
            "BNI",
            "Gunakan kode unik diakhir nominal untuk verifikasi otomatis",
            R.drawable.ic_bni
        ),
        PaymentMethod(
            "MANDIRI",
            "Gunakan kode unik diakhir nominal untuk verifikasi otomatis",
            R.drawable.ic_mandiri
        ),
        PaymentMethod(
            "BRI",
            "Gunakan kode unik diakhir nominal untuk verifikasi otomatis",
            R.drawable.ic_bri
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_payment)



        rvCheckout.apply {
            layoutManager = LinearLayoutManager(this@ChoosePaymentActivity)
            adapter = groupAdapter
        }

        groupAdapter.add(Section(SectionHeaderCheckoutAdapter()))

        prakerja.forEach {
            prakerjaAdapter.add(ItemBankAdapter(it.img, it.name) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                gotSuccessPayment()
            })
        }
        groupAdapter.add(SectionPaymentMethodAdapter("Prakerja", prakerja[0].desc, prakerjaAdapter))

        ewallet.forEach {
            ewalletAdapter.add(ItemBankAdapter(it.img, it.name){
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            gotSuccessPayment()
            })
        }
        groupAdapter.add(SectionPaymentMethodAdapter("E-wallet", ewallet[0].desc,ewalletAdapter))

        atm.forEach {
            atmAdapter.add(ItemBankAdapter(it.img, it.name) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            gotSuccessPayment()
            })
        }
        groupAdapter.add(SectionPaymentMethodAdapter("ATM/ Transfer Bank",atm[0].desc, atmAdapter))

    }

    fun gotSuccessPayment(){
        Intent(this, PaymentSuccessfullyActivity::class.java).apply {
            startActivity(this)
        }
    }
}