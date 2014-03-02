public class MapColorer {

  public static void main(String[] args) {

    //validity checks
    if (args.length % 2 == 0) {
      throw new IllegalArgumentException("Please provide input in this order: [number of countries] [pairs of adjacent country numbers]");
    }
    
    // get country information
    int numberOfCountries = Integer.parseInt(args[0]);
    String[] countries = new String[numberOfCountries];

    // create adjacency table and fill table from args
    boolean[][] adjacencies = new boolean[numberOfCountries][numberOfCountries];
    for (int i = 1; i < args.length - 1; i = i + 2) {
      int firstCountry = Integer.parseInt(args[i]);
      int secondCountry = Integer.parseInt(args[i + 1]);

      adjacencies[firstCountry][secondCountry] = true;
      adjacencies[secondCountry][firstCountry] = true;
    }

    for (int i = 0; i < numberOfCountries; i++) {
        for (int j = 0; j < numberOfCountries; j++) {
          if (!adjacencies[i][j]) {
            adjacencies[i][j] = false;
          }
        }
    }

    // array of colors
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
    if (adjacencies[currentCountry][i]) {
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