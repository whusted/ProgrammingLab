public class multipleLeapYear {
	public static void main(String[] args) {
	  for (int i=0; i< args.length; i++) {
      try {
		    long year - Long.parseLong(args[i]);
        if(year < 1) {
          throw new Exception();
        }
        System.out.println((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)));
        }
      catch (Exception e) {
        System.out.println(e.getMessage() + "bad input");
      }
	  }
  }
}