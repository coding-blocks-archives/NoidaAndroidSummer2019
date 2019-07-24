package com.codingblocks.unittesting

import org.junit.Test

import org.junit.Assert.*

class CalcFareTest {
    @Test
    fun  caclFare_for_0km_0min(){
        assertEquals(100f,CalcFareUtils.calcFare(0f,0))
    }
}