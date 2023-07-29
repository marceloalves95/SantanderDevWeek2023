package br.com.santanderdevweek.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CardResponse(
    @SerializedName("id")
    val id:Int,
    @SerializedName("number")
    val number:String,
    @SerializedName("limit")
    val limit:Double
): Parcelable
