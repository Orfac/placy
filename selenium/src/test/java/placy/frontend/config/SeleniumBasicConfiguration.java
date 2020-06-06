package placy.frontend.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import placy.frontend.utils.IdQueries;
import placy.frontend.utils.XPathQueries;

public class SeleniumBasicConfiguration {
  protected ChromeDriver driver;
  protected String DEFAULT_INPUT = "ресторан";
  private String URL = "localhost:3000";

  @BeforeEach
  public void initializeDriver() {
    System.setProperty("webdriver.chrome.driver", "/home/arseniy/chromedriver");
    driver = new ChromeDriver();
    driver.get(URL);
  }

  @AfterEach
  public void close() {
    driver.quit();
  }

  protected WebElement getSearchButton() {
    return driver.findElement(By.xpath(XPathQueries.FindButton));
  }

  protected WebElement getFilterButton() {
    return driver.findElement(By.xpath(XPathQueries.FilterButton));
  }

  protected void withInput(String input) {
    WebElement inputField = driver.findElement(By.id(IdQueries.InputField));
    inputField.sendKeys(input);
  }

  protected void waitForNoPlacesFound() {
    (new WebDriverWait(driver, 15))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPathQueries.NoPlacesFound)));
  }

  protected void waitForPlaces() {
    (new WebDriverWait(driver, 15))
        .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPathQueries.PlacesList)));
  }

  protected void waitForLoader() {
    (new WebDriverWait(driver, 15))
        .until(ExpectedConditions.presenceOfElementLocated(By.id(IdQueries.Loader)));
  }
}
