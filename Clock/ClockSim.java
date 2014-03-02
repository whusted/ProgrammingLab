public class ClockSim {

	public static void main(String[] args) {
    double desiredAngle = Double.parseDouble(args[0]);
    double slice = 0.0;
    if (args.length == 1) {
      slice = 1;
    } else {
      slice = Double.parseDouble(args[1]);
    }
    if (desiredAngle < 0 || desiredAngle > 360.0 || slice < 0 || slice > 1800.0) {
      throw new IllegalArgumentException("Out of range");
    }
    
    double presentAngle = 0.0;
    double otherPresentAngle = 360.0;

    
    double anglePerSlice = (55 * slice / 600) % 360;

    double initialPosition = 0.0;
		Clock clock1 = new Clock(initialPosition, slice);




      //CHECK FIRST before tick
      if (veryClose(presentAngle, otherPresentAngle, desiredAngle, anglePerSlice)) {
            System.out.println("Time: " + clock1.toString());
          }
  
        // loop check
        final int secondsInTwelveHours = 12 * 60 * 60;
        while (clock1.getSeconds() < secondsInTwelveHours) {

          clock1.tick();
          
          presentAngle = (presentAngle + anglePerSlice) % 360;
          otherPresentAngle = 360 - presentAngle;

          if (veryClose(presentAngle, otherPresentAngle, desiredAngle, anglePerSlice)) {
            System.out.println("Time: " + clock1.toString());

          } 
        }
 
  }
    static boolean veryClose(double presentAngle, double otherPresentAngle, double desiredAngle, double anglePerSlice) {

      double accuracy = anglePerSlice / 2;
      return ( desiredAngle <= (presentAngle + accuracy) && desiredAngle > (presentAngle - accuracy) || desiredAngle <= (otherPresentAngle + accuracy) && desiredAngle > (otherPresentAngle - accuracy) );

    }

}