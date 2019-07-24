package com.codingblocks.unittesting

object CalcFareUtils {
    fun calcFare(km: Float, min: Int): Float {
        var fare = 60f
        if (km > 5) fare += (km - 5) * 10
        if (min > 30) fare += (min - 30) * 2
        return fare
    }
}