package br.com.santanderdevweek.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SantanderResponse(
    @SerializedName("id")
    val id:Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("account")
    val account: AccountResponse,
    @SerializedName("card")
    val card: CardResponse,
    @SerializedName("features")
    val features: List<FeatureResponse>,
    @SerializedName("news")
    val news: List<NewsResponse>
): Parcelable