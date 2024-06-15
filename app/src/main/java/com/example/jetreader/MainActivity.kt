package com.example.jetreader

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetreader.ui.theme.JetReaderTheme
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetReaderTheme {

                val db = FirebaseFirestore.getInstance()
                val user:MutableMap<String,Any> = HashMap()
                user["firstname"] = "Akshat"
                user["lastname"] = "Bhardwaj"


                Surface(color = MaterialTheme.colorScheme.background){
                    db.collection("users")
                        .add(user)
                        .addOnSuccessListener {
                            Log.d("FB","onCreate : $it.id")
                        }.addOnFailureListener {
                            Log.d("FB","onCreate : $it")
                        }
                    Column(modifier = Modifier.padding(45.dp)) {
                        Ramu()
                    }


                }
                }
            }
        }
    }

@Composable
fun Ramu(){
    Text(text = "Kutras rambooze")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetReaderTheme {
    }
}