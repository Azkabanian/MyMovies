package android.mymovies.domain.model

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("display_title")
    val displayTitle: String,
    @SerializedName("summary_short")
    val summaryShort: String,
    val headline: String,
    val multimedia: Multimedia

)