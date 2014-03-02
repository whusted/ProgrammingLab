public class PlaygroundSim {

public static void main(String[] args) {

//  get slice

double slice = Double.parseDouble(args[args.length - 1]);

//  initialize clock

double initialTime = 0.0;
Clock clock1 = new Clock(initialTime, slice);
    

int ballsCount = 0;
int flagpolesCount = 0;

// count flagpoles and balls in loop

for (int i = 0; i < args.length; i++) {
  if (args[i].compareTo("B") == 0) {
    ballsCount = ballsCount + 1;

  } else if (args[i].compareTo("F") == 0) {
    flagpolesCount = flagpolesCount + 1;
  }
}

// Set up arrays without objects, just with length

Ball[] balls = new Ball[ballsCount];
Flagpole[] flagpoles = new Flagpole[flagpolesCount];
int ballsPosition = 0;
int flagpolesPosition = 0;

// process data, put objects into array

for (int i = 0; i < args.length; i++) {

  if (args[i].compareTo("B") == 0) {

    balls[ballsPosition] = new Ball( Double.parseDouble(args[i + 1]), Double.parseDouble(args[i + 2]), Double.parseDouble(args[i + 3]), Double.parseDouble(args[i + 4]) );
    ballsPosition = ballsPosition + 1;

  } else if (args[i].compareTo("F") == 0) {

    flagpoles[flagpolesPosition] = new Flagpole( Double.parseDouble(args[i + 1]), Double.parseDouble(args[i + 2]) );
    flagpolesPosition = flagpolesPosition + 1;

  }
}

    // initial report on locations of objects, as well as velocity of balls
    
    System.out.println("Initial report:");
    System.out.println("Time: " + clock1.toString());
    for (Ball b: balls) {
      System.out.println(b);
    }

    int counter = 0;
    while ( !isBallCollision(balls) || !isFlagCollision(balls, flagpoles) ) {
      clock1.tick();
      move(balls, slice);

      // Report of location of every ball
  
      System.out.println("Report:");
      for (Ball b: balls) {
        System.out.println(b);
      }
      System.out.println("Time: " + clock1.toString());
      if (isBallCollision(balls)) {
        System.out.println("At " + clock1.toString() + " a ball hit a ball.");
        break;
      } else if (isFlagCollision(balls, flagpoles)) {
        System.out.println("At " + clock1.toString() + " a ball hit a flagpole.");
        break;
      }
        if (clock1.getSeconds() >= 12 * 60 * 60 ) {
          System.out.println("No Collision Possible");
          System.exit(0);
        }
      }  
}

  // method that advances all the balls in the array by the same time slice

  static void move( Ball[] balls, double slice ) {
    for (int i = 0; i < balls.length; i++) {
      balls[i].updatePositionX( slice );
      balls[i].updatePositionY( slice );
    }
  }

  static double distanceBetweenBalls( Ball[] balls ) {
    for (int i = 0; i < balls.length - 1; i++) {

      double firstCompareX = balls[i].getX_Coordinate();
      double firstCompareY = balls[i].getY_Coordinate();

      for (int j = i + 1; j < balls.length; j++) {

        double secondCompareX = balls[j].getX_Coordinate();
        double secondCompareY = balls[j].getY_Coordinate();

      return distanceFormula(firstCompareX, secondCompareX, firstCompareY, secondCompareY);
        
      } 
    } return 0;
  }
  
  static double distanceBetweenFlags( Ball[] balls, Flagpole[] flagpoles ) {

    for (int i = 0; i < balls.length; i++) {
      double firstCompareX = balls[i].getX_Coordinate();
      double firstCompareY = balls[i].getY_Coordinate();

      for (int k = 0; k < flagpoles.length; k++) {

        double secondCompareX = flagpoles[k].getX_Coordinate();
        double secondCompareY = flagpoles[k].getY_Coordinate();

      return distanceFormula(firstCompareX, secondCompareX, firstCompareY, secondCompareY);

      } 
    } return 0;
  }
  
  static boolean isBallCollision( Ball[] balls ) {
    return (distanceBetweenBalls(balls) <= 1.0);
  }


  static boolean isFlagCollision( Ball[] balls, Flagpole[] flagpoles) {
        return (distanceBetweenFlags(balls, flagpoles) <= 0.5);
  }
            
  static double distanceFormula( double firstCompareX, double secondCompareX, double firstCompareY, double secondCompareY ) {
    // distance formula
   return Math.sqrt( Math.pow((secondCompareX - firstCompareX), 2) + Math.pow((secondCompareY - firstCompareY), 2) );
  }

}