package com.example.labo01

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.labo01.ui.theme.Labo01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ejecutarLaboratorio()

        enableEdgeToEdge()
        setContent {
            Labo01Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Evaluador",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }

    private fun ejecutarLaboratorio() {
        val TAG = "UCA_LABO"

        // --- Ejercicio 1: Computadora ---
        val miPC = Computadora("Asus ROG", 16, 512, "Windows 11")
        miPC.encender()
        miPC.ram = 32

        val programas = listOf("Notion 2026", "Facebook 2024", "Android Studio 2026", "WhatsApp 2025")
        val instalados2026 = miPC.obtenerProgramasRecientes(programas)
        Log.d(TAG, "Ejercicio 1 - Programas 2026: $instalados2026")

        // --- Ejercicio 2: Calculadora ---
        val miCalc = Calculadora("Kasio5050", 10, 85.50)
        Log.d(TAG, "Ejercicio 2 - Suma: ${miCalc.sumar(15.0, 25.0)}")
        Log.d(TAG, "Ejercicio 2 - Division: ${miCalc.dividir(10.0, 0.0)}")

        // --- Ejercicio 3: Pasando lista ---
        val ciclo01 = mutableListOf<Estudiante>()
        ciclo01.add(Estudiante("Gabriel Urquilla", "00056122", "Programacion de Dispositivos Moviles"))
        ciclo01.add(Estudiante("Antonio Zetino", "00022165", "Programacion de Dispositivos Moviles"))
        ciclo01.add(Estudiante("Cristina Antillon", "00038622", "Programacion de Dispositivos Moviles"))
        ciclo01.add(Estudiante("Roberto Cañas", "00223324", "Redes de Computadoras"))
        ciclo01.add(Estudiante("Lucía Torres", "00445524", "Redes de Computadoras"))

        val soloPDM = ciclo01.filter { it.asignatura == "Programacion de Dispositivos Moviles" }
        Log.d(TAG, "Ejercicio 3 - Alumnos PDM: ${soloPDM.map { it.nombre }}")

        val soloRDC = ciclo01.filter { it.asignatura == "Redes de Computadoras" }
        Log.d(TAG, "Ejercicio 3 - Alumnos RDC: ${soloRDC.map { it.nombre }}")
    }
}

// --- CLASES PARA LOS EJERCICIOS ---

// Ejercicio 1
class Computadora(val marca: String, var ram: Int, var almacenamiento: Int, var sistemaOperativo: String) {
    fun encender() = Log.d("UCA_LABO", "PC $marca Encendida.")
    fun apagar() = Log.d("UCA_LABO", "PC $marca Apagada.")

    fun obtenerProgramasRecientes(lista: List<String>): List<String> {
        return lista.filter { it.contains("2026") }
    }
}

// Ejercicio 2
class Calculadora(val marca: String, val aniosVida: Int, var precio: Double) {
    fun sumar(a: Double, b: Double) = a + b
    fun restar(a: Double, b: Double) = a - b
    fun multiplicar(a: Double, b: Double) = a * b
    fun dividir(a: Double, b: Double): Any {
        return if (b != 0.0) a / b else "Error: Div por 0, regresa a Precalculo"
    }
}

// Ejercicio 3
data class Estudiante(val nombre: String, val carnet: String, val asignatura: String)

// --- COMPONENTES DE INTERFAZ ---

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hola, $name!\nRevisa el Logcat para ver los resultados de los ejercicios.\nTAG = UCA_LABO", modifier = modifier.padding(16.dp))
}