package placy.frontend;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import placy.frontend.config.SeleniumBasicConfiguration;
import placy.frontend.utils.XPathQueries;

public class PaginationTest extends SeleniumBasicConfiguration {
  @Test
  public void pagination_buttons_resolved_correctly(){
    // when
    searchWithDefaultInput();
    waitForLoader();
    waitForPlaces();

    // then
    getPaginationNext();
  }

  @Test
  public void pagination_button_could_be_pressed_and_new_buttons_resolved_correctly(){
    // when
    searchWithDefaultInput();
    waitForLoader();
    waitForPlaces();

    WebElement paginationNext = getPaginationNext();
    paginationNext.click();
    waitForLoader();
    waitForPlaces();

    // then
    getPaginationNext();
    getPaginationBefore();
  }

  @Test
  public void pagination_button_could_be_pressed_and_new_button_next_could_be_pressed(){
    // when
    searchWithDefaultInput();
    waitForLoader();
    waitForPlaces();

    WebElement paginationNext = getPaginationNext();
    paginationNext.click();
    waitForLoader();
    waitForPlaces();

    paginationNext = getPaginationNext();
    getPaginationBefore();
    paginationNext.click();

    // then
    waitForLoader();
    waitForPlaces();
  }

  @Test
  public void pagination_button_could_be_pressed_and_new_button_before_could_be_pressed(){
    // when
    searchWithDefaultInput();
    waitForLoader();
    waitForPlaces();

    WebElement paginationNext = getPaginationNext();
    paginationNext.click();
    waitForLoader();
    waitForPlaces();

    getPaginationNext();
    WebElement paginationBefore = getPaginationBefore();
    paginationBefore.click();

    // then
    waitForLoader();
    waitForPlaces();
  }


  private WebElement getPaginationNext(){
    return driver.findElement(By.xpath(XPathQueries.PaginationNext));
  }
  private WebElement getPaginationBefore(){
    return driver.findElement(By.xpath(XPathQueries.PaginationBefore));
  }

  private void searchWithDefaultInput() {
    withInput(DEFAULT_INPUT);
    WebElement searchButton = getSearchButton();
    searchButton.click();
  }
}
