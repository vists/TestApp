package testapp.app.myapplication.modelpojo

import com.google.gson.annotations.SerializedName

data class UserData (@SerializedName("userId") val userId: Long,
                 @SerializedName("name") val name: String,
                 @SerializedName("email") val email: String,
                 @SerializedName("body") val body: String)