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
import com.example.daggerlearning.service.DaggerUserRegistrationServiceComponent
import com.example.daggerlearning.service.EmailNotificationService
import com.example.daggerlearning.service.EmailNotificationServiceQualifier
import com.example.daggerlearning.service.NotificationService
import com.example.daggerlearning.service.NotificationServiceModule
import com.example.daggerlearning.service.UserRegistrationService
import com.example.daggerlearning.service.UserRegistrationServiceComponent
import com.example.daggerlearning.ui.theme.DaggerLearningTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    @EmailNotificationServiceQualifier
    @Inject
    lateinit var notificationService: NotificationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val component = DaggerUserRegistrationServiceComponent.builder().notificationServiceModule(
//            NotificationServiceModule(2)
//        ).build()

        val component = DaggerUserRegistrationServiceComponent.factory().create(3)

        component.inject(this)
        userRegistrationService.registerUser("rahul.gothwal@gmail.com","112233445")

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