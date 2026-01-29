package com.example.coffeeapp.presentation.ui_component

import android.widget.Toast
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeapp.presentation.theme.CharcoalGray
import com.example.coffeeapp.presentation.theme.LightGray

@Composable
fun AppMessageDialog(
    show: Boolean,
    title: String,
    message: String,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current

    if (show) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(title, fontSize = 24.sp, color = Color.Black) },
            text = { Text(message, fontSize = 20.sp, color = CharcoalGray) },
            confirmButton = {
                TextButton(
                    onClick = {
                        Toast.makeText(context, "Item added to cart", Toast.LENGTH_SHORT).show()
                        onDismiss()
                    },
                    modifier = Modifier.width(80.dp),
                    shape = RoundedCornerShape(10.dp),

                ) { Text("Ok", fontSize = 20.sp) }
            }
        )
    }

}