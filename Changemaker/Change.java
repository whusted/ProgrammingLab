public class Change {
  public static void main (String[]args) {
    long amt = Long.parseLong(args[0]);
    long quarters = amt / 25;
    amt = amt - (25 * quarters); //amt = amt % 25
    long dimes = amt / 10;
    amt = amt - (10 * dimes);
    long nickles = amt / 5;
    amt = amt - (5 * nickles);
    long pennies = amt;
    System.out.println(pennies + "pennies");
    System.out.println(nickles + "nickles");
    System.out.println(dimes + "dimes");
    System.out.println(quarters + "quarters");
  }
}