public class Changemaker {
	public static void main(String[] args) {

    // validate arguments coming in
    if (Integer.parseInt(args[0]) < 0) {
      System.out.println("IMPROPER AMOUNT");
      System.exit(0);
    }
    
    for (int i = 1; i < args.length; i++) {
      if (Integer.parseInt(args[i]) <= 0) {
        System.out.println("IMPROPER DENOMINATION");
        System.exit(0);
      }
    }

    if (args.length < 2) {
      System.out.println("INSUFFICIENT DATA");
      System.exit(0);
    }
    
    int numberOfCols = Integer.parseInt(args[0]) + 1;
    int[] denominations = new int[args.length - 1];
    int denomCount = 0;
    for (int i = 1; i < args.length; i++) {
      if (isInArray( denominations, Integer.parseInt(args[i]))) {
        System.out.println("DUPLICATED DENOMINATION");
        System.exit(0);
      }
      denominations[denomCount] = Integer.parseInt(args[i]);
      denomCount = denomCount + 1;
    }
    // create table
    Tuple[][] table = new Tuple[denominations.length][numberOfCols];
    // first column is zero column
    for (int rows = 0; rows < denominations.length; rows++) {
      table[rows][0] = new Tuple(denominations.length);
    }
    // first row is set
    for (int cols = 1; cols < numberOfCols; cols++) {
      if(cols % denominations[0] == 0) {
        table[0][cols] = new Tuple(denominations.length);
        table[0][cols].setCount(0, (cols / denominations[0]));
      } else {
        table[0][cols] = null;
      }
    }

    // fill out rest of table
    for (int rows = 1; rows < denominations.length; rows++) {
      for (int cols = 1; cols < numberOfCols; cols++) {
        if(cols - denominations[rows] < 0) {
          table[rows][cols] = table[rows - 1][cols];
        } else {
          // check for potentially comparing nulls
          if (table[rows - 1][cols] == null && table[rows][cols - denominations[rows]] != null) {
            table[rows][cols] = table[rows][cols - denominations[rows]].usefulAdd(rows);
          } else if (table[rows - 1][cols] == null && table[rows][cols - denominations[rows]] == null) {
            table[rows][cols] = null;
          } else if (table[rows - 1][cols] != null && table[rows][cols - denominations[rows]] == null) {
            table[rows][cols] = table[rows - 1][cols].copy();
          } else if(table[rows - 1][cols] != null && table[rows][cols - denominations[rows]] != null) {
            if (table[rows - 1][cols].total() > table[rows][cols - denominations[rows]].total() + 1) {
            table[rows][cols] = table[rows][cols - denominations[rows]].usefulAdd(rows);
            } else {
            table[rows][cols] = table[rows - 1][cols].copy();
            }
          }
        }
      }  
    }

    // return bottom right corner tuple in string
    if (table[denominations.length - 1][numberOfCols - 1] == null) {
      System.out.println("IMPOSSIBLE");
    } else {
		  Tuple optimal = table[denominations.length - 1][numberOfCols - 1];
      int finalCount = optimal.total();
      for (int i = 0; i < denominations.length; i++) {
        optimal.setElement(i , denominations[i]);
      }
      System.out.println(finalCount + " COINS: " + optimal.toString());
    }
	}

  public static boolean isInArray( int[] array, int number ) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == number) {
        return true;
      }
    }
    return false;
  }
}