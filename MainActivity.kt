package com.example.logininterface

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.logininterface.ui.theme.LoginInterfaceTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginInterfaceTheme {
                Surface(
                ) {
                    LogInInterfaceLayout()
                }
            }
        }
    }
}

@Composable
fun LogInInterfaceLayout() {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.log_in),
            fontSize = 40.sp,
            modifier = Modifier
                .padding(bottom = 20.dp, top = 60.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )

        Text(
            text = stringResource(R.string.account),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )

        EditAccountField(modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth())

        Text(
            text = stringResource(R.string.password),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )

        EditPasswordField(modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth())

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = { /*TODO*/ }
        ) {
            Text(stringResource(R.string.log_in))

        }

    }
}


@Composable
fun EditAccountField(modifier: Modifier = Modifier) {
    var accountInput by remember { mutableStateOf("") }
    TextField(
        value = accountInput,
        onValueChange = {accountInput = it},
        modifier = modifier,
        label = { Text(stringResource(R.string.account)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
}

@Composable
fun EditPasswordField(modifier: Modifier = Modifier) {
    var accountInput by remember { mutableStateOf("") }
    TextField(
        value = accountInput,
        onValueChange = {accountInput = it},
        modifier = modifier,
        label = { Text(stringResource(R.string.password)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
    )
}

@Preview(showBackground = true)
@Composable
fun InterfaceLayoutPreview() {
    LoginInterfaceTheme {
        LogInInterfaceLayout()
    }
}