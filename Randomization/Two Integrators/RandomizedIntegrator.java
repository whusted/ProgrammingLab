import java.util.Arrays;

public class RandomizedIntegrator {
	public static void main(String[] args) {
		// validate args
    if (args.length < 4 || args[0].compareTo("poly") != 0) {
      throw new IllegalArgumentException("Please provide input in this order: 'poly' [at least 1 digit] [2 parameters]");
    }

    // set bounds
    double lowerBound = Double.parseDouble(args[args.length - 2]);    
    double upperBound = Double.parseDouble(args[args.length - 1]);

    // put args (coefficients) in correct place --> create equation
    double[] coefficients = new double[args.length - 3];

    // loop to add coefficients from back to front
    int n = 0;
    for (int i = args.length - 3; i > 0; i--) {
      coefficients[n] = Double.parseDouble(args[i]);
      n++;
    }
    
    // Find random Y coordinates
    int randomPoints = 100000;
    double[] randomY_Coordinates = new double[randomPoints];
    for (int i = 0; i < randomPoints; i++) {
      double randomX = lowerBound + Math.random() * (upperBound - lowerBound);
      randomY_Coordinates[i] = find_Y(coefficients, randomX);
    }

    // find top and bottom of rectangle
    double topOfRectangle = 0.0;
    double bottomOfRectangle = 0.0;
    double ERROR = 0.1;

    // sort randomY_Coordinates to find largest and smallest values
    Arrays.sort(randomY_Coordinates);
    // set top 10% higher to account for error
    if (randomY_Coordinates[randomPoints - 1] > 0) {
      topOfRectangle = randomY_Coordinates[randomPoints - 1] + ERROR * randomY_Coordinates[randomPoints - 1];
    }
    
    // set bottom 10% lower to account for error
    if (randomY_Coordinates[0] < 0) {
      bottomOfRectangle = randomY_Coordinates[0] + ERROR * randomY_Coordinates[0];
    }

    // determine number of darts to be thrown
     double numberOfDarts = 10000000.0;
     double dartsInArea = 0.0;
    // "throw" darts
    for (long i = 0; i < numberOfDarts; i++) {
      //generate dart with random x, random y coordinates based on rect
      double x_coordinate = lowerBound + Math.random() * (upperBound - lowerBound);
      double y_coordinate = bottomOfRectangle + Math.random() * (topOfRectangle - bottomOfRectangle);

      // check if dart is in area
      if (y_coordinate < 0) {
        if (y_coordinate >= find_Y(coefficients, x_coordinate) && y_coordinate < 0.0) {
          dartsInArea = dartsInArea - 1;
        }
      } else if (y_coordinate > 0) {
          if (y_coordinate <= find_Y(coefficients, x_coordinate) && y_coordinate > 0.0) {
            dartsInArea = dartsInArea + 1;
          }
      } 
    }

    // area of rectangle
    double areaOfRectangle = Math.abs( (upperBound - lowerBound) * (topOfRectangle + bottomOfRectangle) );
    // print estimation of area
    double totalArea = areaOfRectangle * (dartsInArea / numberOfDarts);
    System.out.println("Approximation of area: " + totalArea);
	}

  public static double find_Y(double[] array, double x_coordinate) {
    double result = 0.0;
    for (int i = 0; i < array.length; i++) {
      result = result + array[i] * ( Math.pow(x_coordinate, i) );
    }
    return result;
  }
}