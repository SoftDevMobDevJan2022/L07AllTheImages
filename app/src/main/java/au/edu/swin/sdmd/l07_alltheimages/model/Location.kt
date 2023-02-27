package au.edu.swin.sdmd.l07_alltheimages.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(val name: String, val author: String,
                    val latitude: Float, val longitude: Float,
                    // version 2.0: makes visited mutable
                    var visited: Boolean = false,
                    val image: Int = android.R.drawable.picture_frame): Parcelable {
}