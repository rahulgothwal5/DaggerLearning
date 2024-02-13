package com.example.daggerlearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.daggerlearning.service.notificationservice.EmailNotificationServiceQualifier
import com.example.daggerlearning.service.notificationservice.NotificationService
import com.example.daggerlearning.service.registerationservice.DaggerUserRegistrationServiceComponent
import com.example.daggerlearning.service.registerationservice.UserRegistrationService
import com.example.daggerlearning.ui.theme.DaggerLearningTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    @EmailNotificationServiceQualifier
    @Inject
    lateinit var notificationService: NotificationService

    @EmailNotificationServiceQualifier
    @Inject
    lateinit var notificationService2: NotificationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComponent = (application as DaggerLearningApp).appComponent
        val userRegistrationServiceComponent = DaggerUserRegistrationServiceComponent.factory().create(3,appComponent)

        userRegistrationServiceComponent.inject(this)
        userRegistrationService.registerUser("rahul.gothwal@gmail.com", "112233445")

        setContent {
            DaggerLearningTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaggerLearningTheme {
        Greeting("Android")
    }
}