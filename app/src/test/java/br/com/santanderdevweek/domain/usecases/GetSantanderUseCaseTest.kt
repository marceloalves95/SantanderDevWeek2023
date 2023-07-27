package br.com.santanderdevweek.domain.usecases

import assertk.assertThat
import assertk.assertions.isEqualTo
import br.com.santanderdevweek.domain.model.dummySantander
import br.com.santanderdevweek.domain.models.Santander
import br.com.santanderdevweek.domain.repository.SantanderRepository
import br.com.santanderdevweek.network.event.Event
import br.com.santanderdevweek.testing.BaseTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetSantanderUseCaseTest : BaseTest() {

    @MockK
    private lateinit var repository: SantanderRepository
    private lateinit var getSantanderUseCase: GetSantanderUseCase

    @Before
    fun setup() {
        getSantanderUseCase = GetSantanderUseCase(repository)
    }

    @Test
    fun `should get screen with success when execute GetSantanderUseCase method`() = runBlocking {

        //Arrange
        val progressEmit: MutableList<Event<Santander>> = mutableListOf()

        //Act
        coEvery {
            repository.getSantander()
        } returns dummySantander

        getSantanderUseCase().collect {
            progressEmit.add(it)
        }

        //Assert
        assertThat(progressEmit).isEqualTo(
            mutableListOf(
                Event.Loading,
                Event.Data(dummySantander)
            )
        )

        coVerify {
            repository.getSantander()
        }

        confirmVerified(repository)
    }

    @Test(expected = Throwable::class)
    fun `should get screen with failure when execute GetSantanderUseCase method`() = runBlocking {

        //Arrange
        val progressEmit: MutableList<Event<Santander>> = mutableListOf()
        val throwable = Throwable(message = "ERROR")

        //Act
        coEvery {
            repository.getSantander()
        } throws throwable

        getSantanderUseCase().collect {
            progressEmit.add(it)
        }

        //Assert
        assertThat(progressEmit).isEqualTo(
            mutableListOf(
                Event.Loading,
                Event.Error(Throwable())
            )
        )

        coVerify {
            repository.getSantander()
        }
        confirmVerified(repository)
    }
}