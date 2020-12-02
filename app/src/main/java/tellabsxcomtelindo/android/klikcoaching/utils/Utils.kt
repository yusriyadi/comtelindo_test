package tellabsxcomtelindo.android.klikcoaching.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageFromDrawable(source : Int){
    Glide.with(this).load(source).into(this)
}