package com.example.labo03

//pantalla

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.hardware.Sensor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onNavigateToNames: () -> Unit, onNavigateToSensors: () -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Laboratorio 3") }) }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = onNavigateToNames, modifier = Modifier.fillMaxWidth(0.7f)) {
                Text("Ver Lista de Nombres")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onNavigateToSensors, modifier = Modifier.fillMaxWidth(0.7f)) {
                Text("Ver Sensores")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NameListScreen(onBack: () -> Unit) {
    val nombres = listOf("Gabriel Urquilla", "Estudiante UCA 1", "Estudiante UCA 2", "Estudiante UCA 3")

    Scaffold(
        topBar = { TopAppBar(title = { Text("Lista de Nombres") }) }
    ) { padding ->
        Column(modifier = Modifier.fillMaxSize().padding(padding)) {
            LazyColumn(modifier = Modifier.weight(1f).padding(16.dp)) {
                items(nombres) { nombre ->
                    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                        Text(text = nombre, modifier = Modifier.padding(16.dp))
                    }
                }
            }
            Button(onClick = onBack, modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                Text("Volver al Inicio")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SensorInfoScreen(onBack: () -> Unit) {
    val proximityValues = useSensor(Sensor.TYPE_PROXIMITY)

    Scaffold(
        topBar = { TopAppBar(title = { Text("Informacion de Sensores") }) }
    ) { padding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Sensor de Proximidad", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))

            val valor = if (proximityValues.isNotEmpty()) "${proximityValues[0]} cm" else "Cargando..."
            Text(text = "Distancia: $valor", fontSize = 18.sp)

            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = onBack) {
                Text("Volver")
            }
        }
    }
}