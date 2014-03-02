public class LeapYear {
  public static void main(String[]args) {
    long year = Long.parseLong(args[0]);
    if (year % 400 == 0) {
      System.out.println("true");
    } else if (year % 100 == 0) {
      System.out.println("false");
    } else if (year % 4 == 0) {
      System.out.println("true");
    } else {
      System.out.println("false");
    }
  }
}