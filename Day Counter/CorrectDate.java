public class CorrectDate {
	public static void main(String[] args) {
		long month = Long.parseLong(args[0]);
		long day = Long.parseLong(args[1]);
		long year = Long.parseLong(args[2]);
			if (month > 0 && month <= 12 && day > 0 && day <=31 && year > 0) {
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				System.out.println("true");
			} else if (month == 4 || month == 6 || month == 9 || month == 11 && day <= 30) {
        System.out.println("true");
      } else if (month == 2 && day <= 28) {
        System.out.println("true");
      } else if (month == 2 && day == 29) {
        if (year % 400 == 0) {
          System.out.println("true");
        } else if (year % 100 == 0) {
          System.out.println("false");
        } else if (year % 4 == 0) {
          System.out.println("true");
        } else {
          System.out.println("false");
        } 
      } else {
        System.out.println("false");
      }
		} else {
      System.out.println("false");
    }
	}
}