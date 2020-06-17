package placy.frontend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import placy.frontend.config.SeleniumBasicConfiguration;

public class FilterTest extends SeleniumBasicConfiguration {

  @BeforeEach
  public void setUpClickedFilterButton() {
    WebElement filterButton = getFilterButton();
    filterButton.click();
  }

  @Test
  public void filter_button_could_be_clicked() { }

  @Test
  public void filter_options_resolved_correctly() {
    // then
    driver.findElementByName("cities");
    driver.findElementByName("isFree");
    driver.findElementByName("isClosed");
    driver.findElementByName("lat");
    driver.findElementByName("lon");
    driver.findElementByName("radius");
  }

  @Test
  public void filter_option_city_could_be_changed_and_searched_by() {
    // given
    withSelectedFirstCity();
    // when
    searchWithDefaultInput();
    // then
    waitForLoader();
    waitForPlaces();
  }

  @Test
  public void filter_option_isfree_could_be_changed_and_searched_by() {
    // given
    withSelectedIsFree();
    // when
    searchWithDefaultInput();
    // then
    waitForLoader();
    waitForNoPlacesFound();
  }

  @Test
  public void filter_option_isclosed_could_be_changed_and_searched_by() {
    // given
    withSelectedIsClosed();
    // when
    searchWithDefaultInput();
    // then
    waitForLoader();
    waitForPlaces();
  }

  @Test
  public void filter_option_lat_could_be_changed_and_searched_by(){
    // given
    withSelectedLat();
    // when
    searchWithDefaultInput();
    // then
    waitForLoader();
    waitForPlaces();
  }

  @Test
  public void filter_option_lon_could_be_changed_and_searched_by(){
    // given
    withSelectedLon();
    // when
    searchWithDefaultInput();
    // then
    waitForLoader();
    waitForPlaces();
  }

  @Test
  public void filter_option_radius_could_be_changed_and_searched_by(){
    // given
    withSelectedRadius();
    // when
    searchWithDefaultInput();
    // then
    waitForLoader();
    waitForNoPlacesFound();
  }



  private void withSelectedLat(){
    WebElement element = driver.findElementByName("lat");
    element.sendKeys("59.9");
  }

  private void withSelectedLon(){
    WebElement element = driver.findElementByName("lon");
    element.sendKeys("30.2");
  }

  private void withSelectedRadius(){
    WebElement element = driver.findElementByName("radius");
    element.sendKeys("1");
  }

  private void searchWithDefaultInput() {
    withInput(DEFAULT_INPUT);
    WebElement searchButton = getSearchButton();
    searchButton.click();
  }

  private void withSelectedIsClosed() {
    WebElement element = driver.findElementByName("isClosed");
    element.click();
  }

  private void withSelectedIsFree() {
    WebElement element = driver.findElementByName("isFree");
    element.click();
  }

  private void withSelectedFirstCity() {
    WebElement element = driver.findElementByName("cities");
    Select select = new Select(element);
    select.selectByIndex(0);
  }
}
