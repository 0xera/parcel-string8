package com.example.benchmark

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

data class SerializableStringsData(val list: List<String>) : Serializable
data class SerializableLongsData(val list: List<Long>) : Serializable

@Parcelize
data class ParcelableStringsData(val list: List<String>) : Parcelable
@Parcelize
data class ParcelableLongsData(val list: List<Long>) : Parcelable

data class FixParcelableStringsData(val list: List<String>) : Parcelable {

    constructor(parcel: Parcel) : this(parcel.createString8List().orEmpty())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString8List(list)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<FixParcelableStringsData> {
        override fun createFromParcel(parcel: Parcel) = FixParcelableStringsData(parcel)
        override fun newArray(size: Int): Array<FixParcelableStringsData?> = arrayOfNulls(size)
    }
}
