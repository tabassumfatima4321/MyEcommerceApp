package com.dawaai.myecommerceapp.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class Product() : Parcelable {
    var id: Int? = null
    var category: String? = null
    var description: String? = null
    var title: String? = null
    var price: Double? = null
    var image: String? = null
    var rating: Rating? = null
    var quantity: Int = 0

    constructor(parcel: Parcel) : this() {
        id = parcel.readValue(Int::class.java.classLoader) as? Int
        category = parcel.readString()
        description = parcel.readString()
        title = parcel.readString()
        price = parcel.readValue(Double::class.java.classLoader) as? Double
        image = parcel.readString()
        quantity = parcel.readInt()
    }

    inner class Rating() : Serializable{
        var rate: Double? = null
        var count: Int? = null




    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(category)
        parcel.writeString(description)
        parcel.writeString(title)
        parcel.writeValue(price)
        parcel.writeString(image)
        parcel.writeInt(quantity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }

}