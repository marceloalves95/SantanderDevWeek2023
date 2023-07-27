package br.com.santanderdevweek.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AccountResponse(
    @SerializedName("id")
    val id:Int,
    @SerializedName("number")
    val number:String,
    @SerializedName("agency")
    val agency:String,
    @SerializedName("balance")
    val balance:Double,
    @SerializedName("limit")
    val limit:Double
): Parcelable
