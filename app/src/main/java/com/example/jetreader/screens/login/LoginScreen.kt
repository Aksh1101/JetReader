package com.example.jetreader.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetreader.components.EmailInput
import com.example.jetreader.components.PasswordInput
import com.example.jetreader.components.ReaderLogo

@Composable
fun LoginScreen(navController: NavController){
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally){
            ReaderLogo(modifier = Modifier.padding(top = 100.dp))
            UserForm(loading = false, isCreateAccount = false)
        }
    }

}

@Preview
@Composable
fun UserForm(
    loading : Boolean = false,
    isCreateAccount : Boolean = false,
    onDone :(String,String) -> Unit = {email , pwd ->}
){
    val email = rememberSaveable{ mutableStateOf("")}
    val password = rememberSaveable{ mutableStateOf("")}
    val passwordVisibility = rememberSaveable{ mutableStateOf(false)}
    val passwordFocusRequest = FocusRequester.Default
    val keyboardController = LocalSoftwareKeyboardController.current
    val valid = remember(email.value, password.value){
        email.value.trim().isNotEmpty() && password.value.trim().isNotEmpty()
    }
    val modifier = Modifier
        .height(250.dp)
        .background(MaterialTheme.colorScheme.background)
        .verticalScroll(rememberScrollState())

    Column(modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {

        EmailInput(emailState = email, enabled = !loading,
            onAction = KeyboardActions {passwordFocusRequest.requestFocus() })
        PasswordInput(
            modifier = Modifier.focusRequester(passwordFocusRequest),
            passwordState = password,
            labelId = "Password",
            enabled = !loading,
            passwordVisibility  = passwordVisibility,
            OnAction = KeyboardActions {
                if (!valid) return@KeyboardActions
                onDone(email.value.trim(), password.value.trim())
            })


    }





}



