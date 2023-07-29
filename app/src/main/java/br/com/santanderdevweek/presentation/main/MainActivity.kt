package br.com.santanderdevweek.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.santanderdevweek.presentation.components.AppTopBar
import br.com.santanderdevweek.presentation.components.Header
import br.com.santanderdevweek.presentation.theme.SantanderDevWeekTheme
import androidx.constraintlayout.compose.ConstraintLayout
import br.com.santanderdevweek.domain.mock.mockSantander
import br.com.santanderdevweek.domain.models.Santander
import br.com.santanderdevweek.presentation.components.BalanceCard
import br.com.santanderdevweek.presentation.components.MenuItems
import br.com.santanderdevweek.presentation.theme.Spacing_2
import br.com.santanderdevweek.presentation.theme.Spacing_3
import br.com.santanderdevweek.presentation.components.CreditCard
import br.com.santanderdevweek.presentation.components.NewsPagerApp
import br.com.santanderdevweek.presentation.main.model.SantanderState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel:MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadScreen()
        setContent {
            val state by viewModel.state.collectAsState()
            LoadScreen(state = state)
        }
    }
}

@Composable
fun LoadScreen(state: SantanderState){
    when(state){
        is SantanderState.ScreenData -> ScreenData(santander = state.screenData)
        is SantanderState.Error -> ScreenError(exception = state.exception)
        else -> Unit
    }
}

@Composable
fun ScreenData(santander: Santander){
    SantanderDevWeekTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainApp(santander)
        }
    }
}

@Composable
fun ScreenError(exception: Throwable?){
    println(exception?.message?.let { Log.e("Error", it) })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(santander: Santander) =
    Surface(color = MaterialTheme.colorScheme.background) {
        Scaffold(
            topBar = { AppTopBar() },
            content = { innerPadding ->
                ConstraintLayout(modifier = Modifier.padding(innerPadding)) {

                    val (header, spacer, balanceCard, menuItems, creditCard, news) = createRefs()

                    Header(
                        modifier = Modifier.constrainAs(header) {
                            centerHorizontallyTo(parent)
                        },
                        name = santander.name,
                        agency = santander.account.agency,
                        number = santander.account.number
                    )

                    Spacer(
                        modifier = Modifier
                            .height(40.dp)
                            .constrainAs(spacer) {
                                top.linkTo(header.bottom)
                                bottom.linkTo(header.bottom)
                            }
                    )

                    BalanceCard(
                        modifier = Modifier.constrainAs(balanceCard) {
                            top.linkTo(spacer.top)
                        },
                        balance = santander.account.balance,
                        limit = santander.account.limit
                    )

                    MenuItems(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = Spacing_2,
                                vertical = Spacing_3
                            )
                            .constrainAs(menuItems) {
                                top.linkTo(balanceCard.bottom)
                            },
                        features = santander.features
                    )

                    CreditCard(
                        modifier = Modifier
                            .padding(
                                horizontal = Spacing_2
                            )
                            .constrainAs(creditCard) {
                                top.linkTo(menuItems.bottom)
                            },
                        number = santander.card.number
                    )

                    NewsPagerApp(
                        news = santander.news,
                        modifier = Modifier
                            .padding(
                                horizontal = Spacing_2,
                                vertical = Spacing_2
                            )
                            .constrainAs(news) {
                                top.linkTo(creditCard.bottom)
                            }
                    )

                }
            }
        )
    }

@Preview(showBackground = true)
@Composable
fun SantanderPreview() {
    SantanderDevWeekTheme {
        MainApp(mockSantander)
    }
}