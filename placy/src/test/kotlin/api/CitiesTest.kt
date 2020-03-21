package api

import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import placy.api.Cities
import placy.dto.City

class CitiesTest {

  lateinit var cities: Cities
  lateinit var citiesArray: Array<City>

  @Test
  fun `cities could be retrieved`() {
    givenDefaultCities()
    whenRetrieveCities()
    thenCitiesArrayNotNull()
  }

  @Test
  fun `retrieved cities are not empty`() {
    givenDefaultCities()
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
    whenRetrieveCities()
    thenCitiesArrayElementsAreFilledWithoutSlug()
  }

  @Test
  fun `cities with ordering by name asc could be retrieved`() {
    givenCitiesWithOrderingByNameAsc()
    whenRetrieveCities()
    thenCitiesArrayNotNull()
  }


  @BeforeEach
  private fun givenDefaultCities() {
    cities = Cities
    cities.orderBy = ""
    cities.fields = emptyArray()
    cities.language = ""
  }

  private fun givenCitiesWithOrderingByNameAsc() {
    cities.orderBy = "name"
  }

  private fun givenCitiesWithFieldsWithoutSlug() {
    cities.fields = arrayOf("name", "coords","language", "timezone")
  }

  private fun givenCitiesWithRussianLanguage() {
    cities.language = "ru"
  }

  private fun givenCitiesWithEnglishLanguage() {
    cities.language = "en"
  }

  private fun whenRetrieveCities() {
    citiesArray = cities.getCities()
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
}