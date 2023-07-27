package br.com.santanderdevweek.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeatureResponse(
    @SerializedName("id")
    val id:Int,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("description")
    val description: String
) : Parcelable
