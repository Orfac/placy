package placy.frontend.utils;

public class XPathQueries {

  // Buttons
  public static String FindButton = "//button[contains(.,'Искать')]";
  public static String FilterButton = "//button[contains(.,'Фильтр')]";

  // Search Results
  public static String PlacesList = "//h5[contains(.,'Список мест')]";
  public static String NoPlacesFound = "//h4[contains(.,'К сожалению ничего не удалось найти')]";

  // Pagination
  public static String PaginationNext = "//a[contains(.,'Следующий набор')]";
  public static String PaginationBefore = "//a[contains(.,'Предыдущий набор')]";
}
