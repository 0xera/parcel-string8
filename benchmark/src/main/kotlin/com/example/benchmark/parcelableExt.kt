package com.example.benchmark

import android.content.Context
import android.os.Parcel
import android.os.Parcelable

fun <T : Parcelable> T.writeParcelable(context: Context, fileName: String) {
    val parcel = Parcel.obtain()
    try {
        parcel.writeParcelable(this, 0)
        val bytes = parcel.marshall()
        context.openFileOutput(fileName, Context.MODE_PRIVATE).use { file ->
            file.write(bytes)
        }
    } finally {
        parcel.recycle()
    }
}

inline fun <reified T : Parcelable> readParcelable(context: Context, fileName: String): T? {
    val parcel = Parcel.obtain()
    return try {
        val bytes = context.openFileInput(fileName).use { file -> file.readBytes() }
        parcel.unmarshall(bytes, 0, bytes.size)
        parcel.setDataPosition(0)
        parcel.readParcelable(T::class.java.classLoader)
    } finally {
        parcel.recycle()
    }
}