package placy.frontend;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasicConfiguration {
  public ChromeDriver driver;
  public String URL = "localhost:3000";

  @BeforeEach
  public void initializeDriver(){
    System.setProperty("webdriver.chrome.driver","/home/arseniy/chromedriver");
    driver = new ChromeDriver();
  }

  @AfterEach
  public void close(){
    driver.quit();
  }
}
