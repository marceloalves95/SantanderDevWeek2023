package br.com.santanderdevweek.presentation.main

import br.com.santanderdevweek.domain.model.dummySantander
import br.com.santanderdevweek.domain.usecases.GetSantanderUseCase
import br.com.santanderdevweek.network.event.Event
import br.com.santanderdevweek.testing.BaseTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class MainViewModelTest : BaseTest() {

    private lateinit var viewModel: MainViewModel

    @MockK
    private lateinit var getSantanderUseCase: GetSantanderUseCase

    @Before
    fun setup() {
        viewModel = MainViewModel(getSantanderUseCase)
    }

    @Test
    fun `should return screen state when use case is called with success`() = runBlocking {

        //Act
        coEvery {
            getSantanderUseCase.invoke()
        } returns flowOf(
            Event.loading(),
            Event.data(dummySantander)
        )

        viewModel.loadScreen()

        //Assert
        coVerify(exactly = 1) {
            getSantanderUseCase.invoke()
        }

        confirmVerified(getSantanderUseCase)
    }

    @Test
    fun `should return screen error state when use case is called with failure`() = runBlocking {

        //Arrange
        val throwable = Throwable(message = "ERROR")

        //Act
        coEvery {
            getSantanderUseCase.invoke()
        } returns flowOf(
            Event.loading(),
            Event.error(throwable)
        )

        viewModel.loadScreen()

        //Assert
        coVerify(exactly = 1) {
            getSantanderUseCase.invoke()
        }

        confirmVerified(getSantanderUseCase)
    }

}