package placy.frontend;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import placy.frontend.config.SeleniumBasicConfiguration;

public class SearchTest extends SeleniumBasicConfiguration {

  private String NON_EXISTING_INPUT = "asdasdasdasdasdasdasdasdasdasd";

  @Test
  public void search_button_could_be_clicked(){
    WebElement searchButton = getSearchButton();
    searchButton.click();
  }

  @Test
  public void search_button_should_start_search_after_click(){
    WebElement searchButton = getSearchButton();
    searchButton.click();
    waitForNoPlacesFound();
  }

  @Test
  public void search_button_should_show_loader_and_no_places_found_for_non_existing_query(){
    // given
    withInput(NON_EXISTING_INPUT);
    WebElement searchButton = getSearchButton();
    // when
    searchButton.click();
    // then
    waitForLoader();
    waitForNoPlacesFound();
  }

  @Test
  public void search_button_should_show_loader_and_search_results_for_existing_query(){
    // given
    withInput(DEFAULT_INPUT);
    WebElement searchButton = getSearchButton();
    // when
    searchButton.click();
    // then
    waitForLoader();
    waitForPlaces();
  }
}
