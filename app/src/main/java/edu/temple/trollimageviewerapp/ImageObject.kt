package edu.temple.trollimageviewerapp

import android.os.Parcel
import android.os.Parcelable

// A simple data class that will store and return the specified properties
// for each instance
data class ImageObject (val description: String?, val resourceId: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun describeContents(): Int {
        return 0;
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(description)
        parcel.writeInt(resourceId)
    }

    companion object CREATOR : Parcelable.Creator<ImageObject> {
        override fun createFromParcel(parcel: Parcel): ImageObject {
            return ImageObject(parcel)
        }

        override fun newArray(size: Int): Array<ImageObject?> {
            return arrayOfNulls(size)
        }
    }
    fun getDesc() : String?
    {
        return description;
    }
    fun getRes() : Int
    {
        return resourceId;
    }
}