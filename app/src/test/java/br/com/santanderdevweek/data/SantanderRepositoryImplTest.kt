package br.com.santanderdevweek.data

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isInstanceOf
import br.com.santanderdevweek.data.mapper.toSantander
import br.com.santanderdevweek.data.model.dummySantanderResponse
import br.com.santanderdevweek.data.models.SantanderResponse
import br.com.santanderdevweek.domain.models.Santander
import br.com.santanderdevweek.domain.repository.SantanderRepository
import br.com.santanderdevweek.network.model.ServiceState
import br.com.santanderdevweek.network.service.NetworkingApi
import br.com.santanderdevweek.testing.BaseTest
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.confirmVerified
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SantanderRepositoryImplTest : BaseTest(){

    @RelaxedMockK
    private lateinit var networkingApi: NetworkingApi

    @RelaxedMockK
    private lateinit var repository: SantanderRepository

    @Before
    fun setup(){
        repository = SantanderRepositoryImpl(networkingApi)
    }

    @Test
    fun `should get screen when it is called with success`() = runBlocking {

        //Arrange
        coEvery {
            networkingApi.get(
                url = ACCOUNT,
                responseKClass = SantanderResponse::class
            )
        } returns ServiceState.Success(dummySantanderResponse)

        //Act
        val result = repository.getSantander()

        //Assert
        assertThat(result).isEqualTo(dummySantanderResponse.toSantander())
        assertThat(result).isInstanceOf(Santander::class)

        coVerify(exactly = 1) {
            networkingApi.get(
                url = ACCOUNT,
                responseKClass = SantanderResponse::class
            )
        }

        confirmVerified(networkingApi)
    }

    @Test(expected = Throwable::class)
    fun `should get screen when it is called with failure`() = runBlocking {

        //Arrange
        val throwableMock = mockk<Throwable>()

        coEvery {
            networkingApi.get(
                url = ACCOUNT,
                responseKClass = SantanderResponse::class
            )
        } returns ServiceState.Error(exception = throwableMock, response = mockk(relaxed = true))

        //Act
        repository.getSantander()

        //Assert
        coVerify(exactly = 1) {
            networkingApi.get(
                url = ACCOUNT,
                responseKClass = SantanderResponse::class
            )
        }

        confirmVerified(networkingApi)
    }
}