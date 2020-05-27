package placy.frontend;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FilterTest extends SeleniumBasicConfiguration {
  @Test
  public void filter_button_could_be_clicked(){
    driver.get(URL);
    WebElement filterButton = driver.findElement(By.xpath("//button[contains(.,'Фильтр')]"));
    filterButton.click();
  }
}
