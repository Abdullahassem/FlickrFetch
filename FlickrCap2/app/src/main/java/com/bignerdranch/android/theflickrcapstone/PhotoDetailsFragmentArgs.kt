package com.bignerdranch.android.theflickrcapstone


import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.bignerdranch.android.theflickrcapstone.Photo
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

data class PhotoDetailsFragmentArgs(
    val photo: Photo
) : NavArgs {
    @Suppress("CAST_NEVER_SUCCEEDS")
    fun toBundle(): Bundle {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Photo::class.java)) {
            result.putParcelable("photo", this.photo as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Photo::class.java)) {
            result.putSerializable("photo", this.photo as Serializable)
        } else {
            throw UnsupportedOperationException(Photo::class.java.name +
                    " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
    }

    companion object {
        @JvmStatic
        fun fromBundle(bundle: Bundle): PhotoDetailsFragmentArgs {
            bundle.setClassLoader(PhotoDetailsFragmentArgs::class.java.classLoader)
            val __photo : Photo?
            if (bundle.containsKey("photo")) {
                if (Parcelable::class.java.isAssignableFrom(Photo::class.java) ||
                    Serializable::class.java.isAssignableFrom(Photo::class.java)) {
                    __photo = bundle.get("photo") as Photo?
                } else {
                    throw UnsupportedOperationException(Photo::class.java.name +
                            " must implement Parcelable or Serializable or must be an Enum.")
                }
                if (__photo == null) {
                    throw IllegalArgumentException("Argument \"photo\" is marked as non-null but was passed a null value.")
                }
            } else {
                throw IllegalArgumentException("Required argument \"photo\" is missing and does not have an android:defaultValue")
            }
            return PhotoDetailsFragmentArgs(__photo)
        }
    }
}
