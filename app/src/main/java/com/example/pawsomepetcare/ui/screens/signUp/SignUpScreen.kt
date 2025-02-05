package com.example.pawsomepetcare.ui.screens.signUp

import DatePickerDocked
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pawsomepetcare.Authentications.AuthState
import com.example.pawsomepetcare.Authentications.AuthViewModel
import com.example.pawsomepetcare.R
import com.example.pawsomepetcare.navigation.Screens
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme

@Composable
fun SignUpScreen(navController: NavHostController, modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val colors = MaterialTheme.colorScheme
    val name = remember { mutableStateOf("") }
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val tele = remember { mutableStateOf("") }
    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate(Screens.LoginScreen.name){
                popUpTo(Screens.LoginScreen.name){inclusive = true}
            }
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message,Toast.LENGTH_LONG).show()
            else -> Unit

        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colors.background)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally


    ) {

        // Form Box
        Box(
            modifier = Modifier
                .background(colors.background, shape = shapes.small)

                .padding(16.dp)
                .fillMaxWidth() // Ensure it fills available width
                .align(Alignment.CenterHorizontally),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .padding(vertical = 16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.signup_title),
                    style = typography.titleLarge,
                    color = colors.onBackground
                )

                // The other TextFields and buttons remain unchanged
                Spacer(modifier = Modifier.height(36.dp))

                // Name Field
                TextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text(text = stringResource(id = R.string.signup_name_text_field)) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = stringResource(R.string.login_user_name_desc)
                        )
                    },
                    shape = shapes.small,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Username Field
                TextField(
                    value = username.value,
                    onValueChange = { username.value = it },
                    label = { Text(text = stringResource(id = R.string.signup_user_name_text_field)) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = stringResource(R.string.login_password_desc)
                        )
                    },
                    shape = shapes.small,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Password Field
                TextField(
                    value = password.value,
                    onValueChange = { password.value = it },
                    label = { Text(text = stringResource(id = R.string.signup_password_text_field)) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = stringResource(R.string.signup_password_desc)
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    shape = shapes.small,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    visualTransformation = PasswordVisualTransformation()
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Email Field
                TextField(
                    value = email.value,
                    onValueChange = { email.value = it },
                    label = { Text(text = stringResource(id = R.string.signup_email)) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = stringResource(R.string.signup_email_desc)
                        )
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Done
                    ),
                    shape = shapes.small,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Phone Field
                TextField(
                    value = tele.value,
                    onValueChange = { tele.value = it },
                    label = { Text(text = stringResource(id = R.string.signup_tele)) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Phone,
                            contentDescription = stringResource(R.string.signup_tele_desc)
                        )
                    },
                    shape = shapes.small,
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Date Picker
               Row(
                   modifier = Modifier.padding(horizontal = 30.dp)
               ) {
                   DatePickerDocked("Birthday")
               }
                Spacer(modifier = Modifier.height(16.dp))

                // Sign Up Button
                Button(
                    onClick = { authViewModel.signUp(email.value, password.value)},
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp,
                        focusedElevation = 8.dp,
                        pressedElevation = 8.dp
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colors.primaryContainer,
                        contentColor = colors.onPrimaryContainer
                    )
                ) {
                    Text(text = stringResource(R.string.signup_button_text))
                }
            }
        }

        // Redirect Text
        Spacer(modifier = Modifier.height(16.dp)) // Add space below the form
        Row {
                Text(
                    text = stringResource(id = R.string.signup_redirect_to_sign_up),
                    style = typography.bodyMedium,
                    color = colors.onBackground
                )
                Spacer(modifier = Modifier.width(3.dp))
                Text(
                    text = stringResource(id = R.string.signup_redirect_to_sign_clickable_text),
                    style = typography.bodyMedium.copy(color = colors.secondary),
                    fontWeight = FontWeight(600),
                    modifier = Modifier
                        .clickable {

                        }
                )
        }
    }
}




