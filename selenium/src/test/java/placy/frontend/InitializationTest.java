package placy.frontend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import placy.frontend.config.SeleniumBasicConfiguration;

public class InitializationTest extends SeleniumBasicConfiguration {
  @Test
  public void page_could_be_open(){

  }

  @Test
  public void title_resolved_correctly(){
    String title = driver.getTitle();
    assertEquals(title,"React App");
  }

  @Test
  public void buttons_resolved_correctly(){
    getSearchButton();
    getFilterButton();
  }
}
