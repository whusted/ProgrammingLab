import java.util.Scanner;

public class NewMapColorer {

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


    // array of colors
    String[] colors = new String[4];
    colors[0] = "Red";
    colors[1] = "Green";
    colors[2] = "Blue";
    colors[3] = "Yellow";

    //iteratively color countries, backtracking when yellow doesn't work
    for (int i = 0; i < countries.length; i++) {
      int currentColor = 0;
      countries[i] = colors[currentColor];

      while(!solutionFound(countries, adjacencies)) {

        if (currentColor <= 3) {
          countries[i] = colors[currentColor++];
        } else {
          int firstNonYellow = firstNonYellow(i, countries, colors);

          //check if impossible map
          if (colorIndex(countries[firstNonYellow], colors) + 1 > 3) {
            throw new IllegalArgumentException("Impossible Map");
          }
          countries[firstNonYellow] = colors[colorIndex(countries[firstNonYellow], colors) + 1];
                  // reset countries above first non yellow all to null
          for (int j = firstNonYellow + 1; j < countries.length; j++) {
            countries[j] = null;
          }
                  // resume looping from first non yellow
          i = firstNonYellow;
          break;
        } 
      }
    }

    printSolution(countries);

  }

static boolean solutionFound(String[] countries, boolean[][] adjacencies) {
  for (int i = 0; i < countries.length; i++) {
    for (int j = 0; j < countries.length; j++) {
      if (adjacencies[i][j] == true && countries[i] != null && countries[j] != null && countries[i] == countries[j]) {
        return false;
      }
    }
  }
  return true;
}

static int firstNonYellow(int n, String[] countries, String[] colors) {
  int index = 0;
  for (int i = n; i >= 0; i--) {
    if (countries[i] != colors[3]) {
      index = i;
      break;
    }
  }
  return index;
}

static void printSolution(String[] countries) {
  for (int i = 0; i < countries.length; i++) {
    System.out.println("Country " + i + " is " + countries[i]);
  }
}

static int colorIndex(String color, String[] colors) {
  int colorIndex = 0;
  if (color.compareTo("Green") == 0) {
    colorIndex = 1;
  } else if (color.compareTo("Blue") == 0) {
    colorIndex = 2;
  } else if (color.compareTo("Yellow") == 0) {
    colorIndex = 3;
  }
  return colorIndex;
}

}