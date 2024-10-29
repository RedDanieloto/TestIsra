package com.example.testisra

import org.junit.Assert.* 
import org.junit.Before
import org.junit.Test

// aki la calculadora
class Calculadora {
    fun suma(a: Int, b: Int) = a + b // suma nomás
    fun resta(a: Int, b: Int) = a - b // menos pues
    fun multiplicacion(a: Int, b: Int) = a * b // asterisko de q chuy se extraña
    fun division(a: Int, b: Int): Int {
        if (b == 0) throw IllegalArgumentException() // mecs
        return a / b
    }
}

// aki se prueban las cosas
class ExampleUnitTest {

    private lateinit var calculadora: Calculadora // mañana

    @Before
    fun setUp() {
        calculadora = Calculadora()
    }

    @Test
    fun suma_isOk() {
        assertEquals(5, calculadora.suma(2, 3))
    }

    @Test
    fun resta_isOk() {
        assertEquals(1, calculadora.resta(3, 2)) // 3-2=1, obvio
    }

    @Test
    fun multi_isOk() {
        assertEquals(6, calculadora.multiplicacion(2, 3))
    }

    @Test
    fun divi_isOk() {
        assertEquals(2, calculadora.division(4, 2))
    }

    @Test
    fun noSeDivideEntreCero() {
        assertThrows(IllegalArgumentException::class.java) {
            calculadora.division(4, 0) // quiero lavar dinero
        }
    }

    @Test
    fun multi_porCero() {
        assertEquals(0, calculadora.multiplicacion(5, 0)) // obv xd
    }

    @Test
    fun resta_daNegativo() {
        assertEquals(-1, calculadora.resta(2, 3)) // tamos jodidos
    }

    @Test
    fun divi_entero() {
        assertEquals(2, calculadora.division(8, 4))
    }

    @Test
    fun suma_muyGrande() {
        val res = calculadora.suma(1_000_000, 2_000_000) // suma grandes nomás pa ver si truena
        assertEquals(3_000_000, res)
    }

    @Test
    fun esMultiploDeTres() {
        val num = 9
        assertTrue(checarMultiploDeTres(num)) // nuebe
    }

    private fun checarMultiploDeTres(num: Int): Boolean {
        return num % 3 == 0 // pilin
    }
}
