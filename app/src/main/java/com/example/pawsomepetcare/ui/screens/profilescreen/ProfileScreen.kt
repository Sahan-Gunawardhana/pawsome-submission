package com.example.pawsomepetcare.ui.screens.profilescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pawsomepetcare.R
import com.example.pawsomepetcare.ui.theme.PawsomePetCareTheme

@Composable
fun ProfileScreen(navController: NavController, modifier: Modifier = Modifier) {
    val colors = MaterialTheme.colorScheme
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.avatar),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
                Text(
                    text = "John Doe",
                    modifier = Modifier.padding(top = 8.dp),
                    style = MaterialTheme.typography.titleLarge
                )
                Box(
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                        .clip(shape = MaterialTheme.shapes.small)
                        .background(color = colors.tertiaryContainer)
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp), // Spacing between rows
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Username", style = MaterialTheme.typography.titleMedium)
                            Text(text = "JohnDoe")
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Password", style = MaterialTheme.typography.titleMedium)
                            Text(text = "***********")
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Email", style = MaterialTheme.typography.titleMedium)
                            Text(text = "johndoe@example.com")
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Phone", style = MaterialTheme.typography.titleMedium)
                            Text(text = "+1234567890")
                        }
                    }
                }

            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Ongoing Activities",
                style = MaterialTheme.typography.titleLarge
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(IntrinsicSize.Max)
                        .fillMaxWidth()
                        .clip(shape = MaterialTheme.shapes.small) // Apply rounded corners to the Box
                        .background(color = colors.tertiaryContainer)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                        ) {
                            Text(text = "Appointment", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)
                            Text(text = "2024/01/23", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                        ) {
                            Text(text = "From")
                            Text(text = "2024/01/25")
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                        ) {
                            Text(text = "Till")
                            Text(text = "2024/01/30")
                        }
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .align(Alignment.End)
                                .padding(bottom = 0.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colors.errorContainer,
                                contentColor = colors.onErrorContainer
                            ),
                            elevation = ButtonDefaults.buttonElevation(
                                focusedElevation = 8.dp,
                                defaultElevation = 8.dp,
                                pressedElevation = 8.dp,
                                hoveredElevation = 8.dp
                            )
                        ) {
                            Text(text = "Cancel")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Order History Section
            Text(text = "Order History", style = MaterialTheme.typography.titleLarge)

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .height(IntrinsicSize.Max)
                        .fillMaxWidth()
                        .clip(shape = MaterialTheme.shapes.small)
                        .background(color = colors.tertiaryContainer)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                        ) {
                            Text(text = "Order #12341", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)
                            Text(text = "2024/01/23", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, textDecoration = TextDecoration.Underline)
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                        ) {
                            Text(text = "Total")
                            Text(text = "$123.00")
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                        ) {
                            Text(text = "Arrival")
                            Text(text = "2024/01/30")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(70.dp))
        }
        ExtendedFloatingActionButtonCommon(title = "Edit Your Profle", onClick = { /*TODO*/ }, modifier = Modifier.align(Alignment.BottomEnd).padding(end = 8.dp))
        Spacer(modifier = Modifier.height(150.dp))
    }
}
