public class Tuple {

private int[][] data;


public static void main(String[] args) {

  unitTest_setElement(); 
  unitTest_getElement();
  unitTest_setCount();
  unitTest_getCount();
  unitTest_toString();
  unitTest_length();
  unitTest_add();
  unitTest_usefulAdd();
  unitTest_copy();
  unitTest_equals();
  unitTest_total();
  unitTest_hashCode();

}


  public Tuple (int n) {
    //Constructs an n-tuple with all elements initialized to zero.
    this.data = new int[2][n];
    for(int cols = 0; cols < n; cols ++) {
      for(int rows = 0; rows < 2; rows ++){
        this.data[rows][cols] = 0;
      }
    }
  }

  public Tuple (int[] data) {
    //Constructs an n-tuple from the given data
    this.data = new int[2][data.length];
    for(int cols = 0; cols < data.length; cols ++) {
      this.data[0][cols] = data[cols];
      this.data[1][cols] = 0;
    }
  }

  public Tuple (int[][] data) {
    this.data = new int[2][data[0].length];
    for(int cols = 0; cols < data[0].length; cols ++) {
      this.data[0][cols] = data[0][cols];
      this.data[1][cols] = data[1][cols];
    }
  }


  public void setElement( int denom, int value ) {
    //Sets element i to value j.
    this.data[0][denom] = value;
  }

  public int getElement( int denom ) {
    //Returns the value at element i.
    return this.data[0][denom];
  }

  public void setCount(int denom, int count) {
    this.data[1][denom] = count;

  }

  public int getCount(int denom) {
    return this.data[1][denom];
  }

  public String toString() {
    //Returns a representation of this tuple using angle brackets.
    String result = "<";
    for(int cols = 0; cols < this.data[0].length - 1; cols ++) {
      result = result + this.data[0][cols] + "c : " + this.data[1][cols] + ", ";
    }

    return result + this.data[0][this.data[0].length - 1] + "c : " + this.data[1][this.data[0].length - 1] + ">";
  }

  public int length() {
    //Returns the length of this tuple.
    return this.data[0].length;
  }

  public void add(Tuple t) {
    //Adds tuple t to this tuple.
    
      for(int cols = 0; cols < data[0].length; cols ++) {
        this.data[1][cols] = this.data[1][cols] + t.data[1][cols];
      }
  }

  public Tuple usefulAdd(int denom) {
    Tuple t = this.copy();
    int currentCount;
    currentCount = this.getCount(denom);
    currentCount = currentCount + 1;
    t.setCount(denom, currentCount);
    return t;
  }

  public Tuple copy() {
    //Returns an exact copy of this tuple.
    return new Tuple(this.data);
  }

   public boolean equals(Tuple t) {
    //Returns true if this tuple is identical to t.
    this.data = new int[2][data[0].length];
    for(int cols = 0; cols < data[0].length; cols ++) {
      if (this.data[0][cols] != data[0][cols] || this.data[1][cols] != data[1][cols]) {
        return false;
      }
    }
    return true;
  }

  public int total() {
    //Returns the total of the elements of this tuple.
    int total = 0;

    for(int cols = 0; cols < data[0].length; cols ++) {
      total = total + this.data[1][cols];
    }
    return total;
  }

  public int hashCode() {
    //Overrides Object.hashCode()
    return this.data.hashCode();
  }
  
  public void print() {
    //Outputs a representation of this tuple using angle brackets.
    System.out.println(this.toString());
  }



  //unitTESTS

  private static void unitTest_setElement() {
    Tuple t0 = new Tuple(3);
    t0.setElement(0, 3);
    t0.setElement(1, 10);
    System.out.println( t0.getElement(1) == 10 );

  }

  private static void unitTest_getElement() {
    Tuple t0 = new Tuple(4);
    t0.setElement(0, 1);
    t0.setElement(1, 3);
    t0.setElement(2, 9);
    t0.setElement(3, 20);
    System.out.println( t0.getElement(1) == 3 );

  }

  private static void unitTest_setCount() {
    Tuple t0 = new Tuple(4);
    t0.setCount(0, 1);
    t0.setCount(1, 3);
    t0.setCount(2, 9);
    t0.setCount(3, 20);
    System.out.println( t0.getCount(2) == 9);
  }
  
  private static void unitTest_getCount() {
    Tuple t0 = new Tuple(4);
    t0.setCount(0, 1);
    t0.setCount(1, 3);
    t0.setCount(2, 9);
    t0.setCount(3, 20);
    System.out.println( t0.getCount(1) == 3);
  }

  private static void unitTest_toString() {
    Tuple t1 = new Tuple(4);
    t1.setElement(0, 1);
    t1.setElement(1, 5);
    t1.setElement(2, 10);
    t1.setElement(3, 25);

    System.out.println(t1.toString().equals("<1c : 0, 5c : 0, 10c : 0, 25c : 0>"));
  }

  private static void unitTest_length() {
    Tuple t0 = new Tuple(3);
    System.out.println(t0.length() == 3);

  }
  private static void unitTest_add() {
    Tuple t0 = new Tuple(3);
    t0.setCount(0, 2);
    t0.setCount(1, 4);
    t0.setCount(2, 8);

    Tuple t1 = new Tuple(3);
    t1.setCount(0, 2);
    t1.setCount(1, 4);
    t1.setCount(2, 8);
    t0.add(t1);

    System.out.println(t0.getCount(0) == 4);
    System.out.println(t0.getCount(1) == 8);
    System.out.println(t0.getCount(2) == 16);
  }

  private static void unitTest_usefulAdd() {
    Tuple t0 = new Tuple(3);
    t0.setCount(0, 2);
    t0.setCount(1, 4);
    t0.setCount(2, 8);
    Tuple t1 = t0.usefulAdd(1);
    System.out.println(t1.getCount(1) == 5);

  }
  private static void unitTest_copy() {
    Tuple t0 = new Tuple(3);
    t0.setCount(0, 2);
    t0.setElement(0, 1);
    t0.setCount(1, 4);
    t0.setElement(1, 5);
    t0.setCount(2, 8);
    t0.setElement(2, 10);

    Tuple t1 = t0.copy();
    System.out.println(t0.getCount(0) == t1.getCount(0));
    System.out.println(t0.getCount(1) == t1.getCount(1));
    System.out.println(t0.getCount(2) == t1.getCount(2));
    System.out.println(t0.getElement(0) == t1.getElement(0));
    System.out.println(t0.getElement(1) == t1.getElement(1));
    System.out.println(t0.getElement(2) == t1.getElement(2));

  }
  private static void unitTest_equals() {
    Tuple t0 = new Tuple(3);
    t0.setCount(0, 2);
    t0.setCount(1, 4);
    t0.setCount(2, 8);

    Tuple t1 = new Tuple(3);
    t1.setCount(0, 2);
    t1.setCount(1, 4);
    t1.setCount(2, 8);

    System.out.println(t0.equals(t1));

  }
  private static void unitTest_total() {
    Tuple t0 = new Tuple(2);
    t0.setElement(0, 1);
    t0.setElement(1, 5);

    Tuple t1 = new Tuple(new int[]{1, 2, 3});
    t1.setElement(0, 2);
    t1.setCount(0, 2);
    t1.setElement(2, 5);
    t1.setCount(1, 10);

    System.out.println(t0.total() == 0);
    System.out.println(t1.total() == 12);

  }
  private static void unitTest_hashCode() {
    Tuple t0 = new Tuple(3);
    t0.setCount(0, 1);
    t0.setElement(0, 1);
    t0.setCount(1, 4);
    t0.setElement(1, 5);
    t0.setCount(2, 8);
    t0.setElement(2, 10);

    System.out.println(t0.hashCode());
  }

}