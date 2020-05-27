package placy.frontend;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class InitializationTest extends SeleniumBasicConfiguration{
  @Test
  public void page_could_be_open(){
    driver.get(URL);
  }

  @Test
  public void title_resolved_correctly(){
    driver.get(URL);
    String title = driver.getTitle();
    assertEquals(title,"React App");
  }

  @Test
  public void buttons_resolved_correctly(){
    driver.get(URL);
    driver.findElement(By.xpath("//button[contains(.,'Искать')]"));
    driver.findElement(By.xpath("//button[contains(.,'Фильтр')]"));
  }
}
