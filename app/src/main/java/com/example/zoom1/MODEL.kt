package com.example.zoom1

data class MODEL(

    var id: Int = getAutoId(),
    var owner: String = "",
    var descerptions: String = "",
) {
    companion object {
        fun getAutoId(): Int {
            val random = java.util.Random()
            return random.nextInt(100)
        }
    }

}
