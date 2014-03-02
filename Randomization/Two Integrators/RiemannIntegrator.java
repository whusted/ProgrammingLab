public class RiemannIntegrator {
  static double totalArea = 0.0;
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

    findArea(coefficients, lowerBound, upperBound, 0);

    System.out.println("Area: " + totalArea);

  }

  static void findArea(double[] coefficients, double lowerBound, double upperBound, int n) {
    double numberOfRectangles = Math.pow(2, n);
    double currentWidth = (upperBound - lowerBound) / numberOfRectangles;
    double currentRight = lowerBound + currentWidth;
    double currentLeft = lowerBound;
    double area = 0.0;
    
    // calculate area, looping based on number of rectangles
    for (int i = 0; i < numberOfRectangles; i++) {
      double midpoint = (currentLeft + currentRight) / 2;
      area = area + find_Y(coefficients, midpoint) * currentWidth;
      currentLeft += currentWidth;
      currentRight += currentWidth;
    }

    // check if within .001%
    double accuracy = (.1 * .01) * area;
    // negative area vs positive area
    if (area < 0) {
      if (!(area + accuracy <= totalArea && area - accuracy >= totalArea)) {
        totalArea = area;
        findArea(coefficients, lowerBound, upperBound, n + 1);
      } 
    } else if(area > 0) {
        if ( !(area + accuracy >= totalArea && area - accuracy <= totalArea) ) {
          totalArea = area;
          findArea(coefficients, lowerBound, upperBound, n + 1);
        }
    }
  }

  public static double find_Y(double[] array, double x_coordinate) {
    double result = 0.0;
    for (int i = 0; i < array.length; i++) {
      result = result + array[i] * ( Math.pow(x_coordinate, i) );
    }
    return result;
  }
}