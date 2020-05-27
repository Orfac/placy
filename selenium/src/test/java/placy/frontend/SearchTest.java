package placy.frontend;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class SearchTest extends SeleniumBasicConfiguration {
  @Test
  public void search_button_could_be_clicked(){
    driver.get(URL);
    WebElement searchButton = driver.findElement(By.xpath("//button[contains(.,'Искать')]"));
    searchButton.click();
  }

  @Test
  public void search_button_should_start_search_after_click(){
    driver.get(URL);
    WebElement searchButton = driver.findElement(By.xpath("//button[contains(.,'Искать')]"));
    searchButton.click();
    WebElement dynamicElement = (new WebDriverWait(driver, 10))
        .until(ExpectedConditions.presenceOfElementLocated(By.id("")));
  }
}
