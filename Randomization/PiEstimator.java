public class PiEstimator {
	public static void main(String[] args) {

		//short validity check
    if (args.length != 1) {
      System.out.println("Please provide one number.");
      System.exit(0);
    }

		double numberOfDarts = Double.parseDouble(args[0]);
    double dartsInCircle = 0;
    double squareLengthOfSide = 2;
    double radius = (squareLengthOfSide / 2);
    // "throw" darts
    for (long i = 0; i < numberOfDarts; i++) {
      //generate dart with random x, random y coordinates
      double x_coordinate = Math.random() * squareLengthOfSide;
      double y_coordinate = Math.random() * squareLengthOfSide;
      if (isInCircle(radius, x_coordinate, y_coordinate)) {
        dartsInCircle = dartsInCircle + 1;
      }
    }

    // print estimation of pi
    double piEstimation = 4 * (dartsInCircle / numberOfDarts);
    System.out.println("Approximation of pi using " + numberOfDarts + " darts = " + piEstimation);
	}
  /** Method */
  public static boolean isInCircle(double radius, double x_coordinate, double y_coordinate) {
    // distance formula
    double distanceFromCenter = Math.sqrt( Math.pow((x_coordinate - radius), 2) + Math.pow((y_coordinate - radius), 2) );
    if (distanceFromCenter <= radius) {
      return true;
    }
    return false;
  }
}