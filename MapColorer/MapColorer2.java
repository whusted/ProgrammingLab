import java.util.Scanner;

public class MapColorer2 {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    
    // get country information
    int numberOfCountries = scan.nextInt();
    String[] countries = new String[numberOfCountries];

    // create adjacency table and fill table from args
    boolean[][] adjacencies = new boolean[numberOfCountries][numberOfCountries];
    while (scan.hasNextInt()) {
      int firstCountry = scan.nextInt();
      int secondCountry = scan.nextInt();

      adjacencies[firstCountry][secondCountry] = true;
      adjacencies[secondCountry][firstCountry] = true;
    }

    for (int i = 0; i < numberOfCountries; i++) {
        for (int j = 0; j < numberOfCountries; j++) {
          if (adjacencies[i][j] != true) {
            adjacencies[i][j] = false;
          }
        }
    }

    // array of colors to be linked to numbers at very end
    String[] colors = new String[4];
    colors[0] = "Red";
    colors[1] = "Green";
    colors[2] = "Blue";
    colors[3] = "Yellow";

  // Run try to color
  if (!tryToColor(0, colors, countries, adjacencies)) {
      System.out.println("Impossible map");
    } else {
      printSolution(countries);
    } 

  }

public static boolean tryToColor(int n, String[] colors, String[] countries, boolean[][] adjacencies) {
  for (int i = 0; i < colors.length; i++) {
    String currentColor = colors[i];
    countries[n] = currentColor;
      if (isPartialSolution(currentColor, n, countries, adjacencies)) {
        if (n == countries.length - 1) {
          return true;
        } else {
          if (tryToColor(n + 1, colors, countries, adjacencies)) {
            return true;
          }
        } 
      } 
  }
  countries[n] = null;
  return false;
} 

static boolean isPartialSolution(String currentColor, int currentCountry, String[] countries, boolean[][] adjacencies) {
  for (int i = 0; i < countries.length; i++) {
    if (adjacencies[currentCountry][i] == true) {
      if (countries[i] == currentColor) {
        return false;
      }
    }
  }
  return true;
}

static void printSolution(String[] countries) {
  for (int i = 0; i < countries.length; i++) {
    System.out.println("Country " + i + " is " + countries[i]);
  }
}

}