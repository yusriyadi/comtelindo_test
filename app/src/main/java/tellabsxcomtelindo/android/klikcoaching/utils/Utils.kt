package tellabsxcomtelindo.android.klikcoaching.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageFromDrawable(source : Int){
    Glide.with(this).load(source).centerCrop().into(this)
}

fun formatRupiah(angka: Double?): String =
    angka?.let {
        return String.format("Rp. %,.0f", it).replace(",".toRegex(), ".")
    } ?: run { return "Rp. null" }