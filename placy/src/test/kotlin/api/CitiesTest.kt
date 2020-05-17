package api

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.jackson.responseObject
import com.github.kittinunf.result.Result
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import placy.api.Cities
import placy.dto.City
import placy.dto.Coords
import placy.dto.requests.DefaultRequestDTO

class CitiesTest {

  lateinit var citiesRequest: DefaultRequestDTO
  lateinit var citiesArray: Array<City>

  @Test
  fun `cities could be retrieved`() {
    givenDefaultCitiesRequest()
    whenRetrieveCities()
    thenCitiesArrayNotNull()
  }

  @Test
  fun `retrieved cities are not empty`() {
    givenDefaultCitiesRequest()
    whenRetrieveCities()
    thenCitiesArrayElementsAreFilledWithData()
  }

  @Test
  fun `cities with russian language could be retrieved`() {
    givenCitiesWithRussianLanguage()
    whenRetrieveCities()
    thenCitiesArrayElementsAreFilledWithData()
  }

  @Test
  fun `cities with english language could be retrieved`() {
    givenCitiesWithEnglishLanguage()
    whenRetrieveCities()
    thenCitiesArrayElementsAreFilledWithData()
  }

  @Test
  fun `cities with fields name and id could be retrieved`() {
    givenCitiesWithFieldsWithoutSlug()
    whenRetrieveCities()
    thenCitiesArrayNotNull()
  }

  @Test
  fun `cities with fields name and id are retrieved without slug`() {
    givenCitiesWithFieldsWithoutSlug()
    whenRetrieveCitiesWithoutSlugField()
    thenCitiesArrayElementsAreFilledWithoutSlug()
  }

  @Test
  fun `cities with ordering by name asc could be retrieved`() {
    givenCitiesWithOrderingByNameAsc()
    whenRetrieveCities()
    thenCitiesArrayNotNull()
  }

  @BeforeEach
  private fun givenDefaultCitiesRequest() {
    citiesRequest = DefaultRequestDTO()
  }

  private fun givenCitiesWithOrderingByNameAsc() {
    citiesRequest.orderBy = "name"
  }

  private fun givenCitiesWithFieldsWithoutSlug() {
    citiesRequest.fields = arrayOf("name", "coords", "language", "timezone")
  }

  private fun givenCitiesWithRussianLanguage() {
    citiesRequest.language = "ru"
  }

  private fun givenCitiesWithEnglishLanguage() {
    citiesRequest.language = "en"
  }

  private fun whenRetrieveCities() {
    val fuel = mockk<Fuel>()

    val citiesApi = Cities()
    every {
      fuel.get(citiesApi.CITIES_URL, citiesRequest.toList()).responseObject<Array<City>>().third
    } returns Result.Success(arrayOf(fulfilledCity(), fulfilledCity(), fulfilledCity()))


    citiesArray = citiesApi.getCities(citiesRequest)
  }

  private fun whenRetrieveCitiesWithoutSlugField() {
    val fuel = mockk<Fuel>()

    val citiesApi = Cities()
    every {
      fuel.get(citiesApi.CITIES_URL, citiesRequest.toList()).responseObject<Array<City>>().third
    } returns Result.Success(arrayOf(cityWithoutSlug(), cityWithoutSlug(), cityWithoutSlug()))

    citiesArray = citiesApi.getCities(citiesRequest)
  }

  private fun thenCitiesArrayElementsAreFilledWithoutSlug() {
    citiesArray.all {
      it.name != "" && it.coords != null &&
          it.timezone != "" && it.language != "" &&
          it.slug == ""
    }
  }

  private fun thenCitiesArrayElementsAreFilledWithData() =
      assertTrue(citiesArray.all { isCityFilledWithNameAndSlug(it) })

  private fun thenCitiesArrayNotNull() = assertNotNull(citiesArray)

  private fun isCityFilledWithNameAndSlug(city: City): Boolean =
      city.name != "" && city.slug != ""

  private fun fulfilledCity() =
      City(
          name = "City",
          slug = "slug",
          timezone = "timezone",
          coords = Coords(1.0, 2.0),
          language = "ru")

  private fun cityWithoutSlug() =
      City(
          name = "City",
          slug = "",
          timezone = "timezone",
          coords = Coords(1.0, 2.0),
          language = "ru")
}