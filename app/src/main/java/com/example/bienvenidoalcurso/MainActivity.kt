package com.example.exploracioncomponentes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    // Vista principal
                }
            }
        }
    }
}

// ================= CONTENEDORES =================

@Preview(showBackground = true)
@Composable
fun PreviewLazyColumn() {
    LazyColumn(modifier = Modifier.size(200.dp, 150.dp)) {
        items(5) { index -> Text("Elemento $index", modifier = Modifier.padding(8.dp)) }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLazyRow() {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(5) { index -> Text("Item $index", modifier = Modifier.padding(16.dp)) }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGrid() {
    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.size(200.dp)) {
        items(4) { index -> Text("Celda $index", modifier = Modifier.padding(8.dp)) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PreviewScaffold() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Scaffold Demo") }) }
    ) { padding ->
        Text("Contenido principal", modifier = Modifier.padding(padding))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSurface() {
    Surface(color = Color.LightGray, shape = MaterialTheme.shapes.medium, modifier = Modifier.size(150.dp, 60.dp)) {
        Box(contentAlignment = Alignment.Center) { Text("Superficie Surface") }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Preview(showBackground = true)
@Composable
fun PreviewFlowRow() {
    FlowRow(modifier = Modifier.padding(8.dp)) {
        repeat(5) { AssistChip(onClick = {}, label = { Text("Tag $it") }, modifier = Modifier.padding(4.dp)) }
    }
}

// ================= CONTROLES (I) =================

@Preview(showBackground = true)
@Composable
fun PreviewAlertDialog() {
    AlertDialog(
        onDismissRequest = {},
        confirmButton = { TextButton(onClick = {}) { Text("OK") } },
        title = { Text("Alerta") },
        text = { Text("Este es un mensaje de prueba.") }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCard() {
    Card(modifier = Modifier.size(180.dp, 80.dp)) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { Text("Tarjeta Card") }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCheckbox() {
    var checked by remember { mutableStateOf(true) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checked, onCheckedChange = { checked = it })
        Text("Opción")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFAB() {
    FloatingActionButton(onClick = {}) {
        Icon(Icons.Default.Add, contentDescription = "Añadir")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProgressBar() {
    Column(modifier = Modifier.padding(8.dp)) {
        CircularProgressIndicator()
        Spacer(Modifier.height(8.dp))
        LinearProgressIndicator()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSlider() {
    var position by remember { mutableFloatStateOf(0.5f) }
    Slider(value = position, onValueChange = { position = it })
}

@Preview(showBackground = true)
@Composable
fun PreviewSwitch() {
    var checked by remember { mutableStateOf(true) }
    Switch(checked = checked, onCheckedChange = { checked = it })
}

// ================= CONTROLES (II) =================

@Preview(showBackground = true)
@Composable
fun PreviewNavigationBar() {
    NavigationBar {
        NavigationBarItem(selected = true, onClick = {}, icon = { Icon(Icons.Default.Home, null) }, label = { Text("Inicio") })
        NavigationBarItem(selected = false, onClick = {}, icon = { Icon(Icons.Default.Favorite, null) }, label = { Text("Favoritos") })
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDivider() {
    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), thickness = 2.dp, color = Color.Gray)
}

@Preview(showBackground = true)
@Composable
fun PreviewOutlinedTextField() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(value = text, onValueChange = { text = it }, label = { Text("Nombre") })
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PreviewTooltip() {
    TooltipBox(
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
        tooltip = { PlainTooltip { Text("Información adicional") } },
        state = rememberTooltipState()
    ) {
        IconButton(onClick = {}) { Icon(Icons.Default.Menu, contentDescription = null) }
    }
}