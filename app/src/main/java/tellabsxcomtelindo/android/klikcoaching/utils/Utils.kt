package tellabsxcomtelindo.android.klikcoaching.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.squareup.picasso.Picasso

fun ImageView.loadImageFromDrawable(source : Int){
    Glide.with(this).load(source).centerCrop().into(this)
}
fun ImageView.loadImageFromDrawableCircle(source : Int){
    Glide.with(this.context).load(source).centerCrop().circleCrop().into(this)
}
fun formatRupiah(angka: Double?): String =
    angka?.let {
        return String.format("Rp. %,.0f", it).replace(",".toRegex(), ".")
    } ?: run { return "Rp. null" }