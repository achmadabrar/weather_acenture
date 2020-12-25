package com.achmadabrar.accenturetest.data.models

import com.google.gson.annotations.SerializedName

data class SearchResponse (
   @SerializedName("search_api")
   val searchApi: Result
)