public class DayCounter {
	public static void main(String[] args) {
		long month1 = Long.parseLong(args[0]);
		long day1 = Long.parseLong(args[1]);
		long year1 = Long.parseLong(args[2]);
		long month2 = Long.parseLong(args[3]);
		long day2 = Long.parseLong(args[4]);
		long year2 = Long.parseLong(args[5]);
    //assume the dates given are valid
    if (!inConsecutiveOrder(month1, day1, year1, month2, day2, year2)) {
      long x = month1; month1 = month2; month2 = x;
           x = day1; day1 = day2; day2 = x;
           x = year1; year1 = year2; year2 = x;
    }
    long count = 0;
    while (day1 != day2 || month1 != month2 || year1 != year2) {
      count ++;
      if (day1 < numberOfDays(month1, year1)) {
        day1 ++;
      } else if (month1 < 12) {
        day1 = 1; month1 ++;
      } else {
        day1 = 1; month1 = 1; year1 ++;
      }
    } System.out.println(count);
	}
  public static boolean inConsecutiveOrder(long month1, long day1, long year1, long month2, long day2, long year2) {
      return ((year1 < year2) || (year1 == year2) && (month1 < month2) || (year1 == year2) && (month1 == month2) && (day1 <= day2));
    }
  public static boolean isLeapYear(long year) {
    if (year % 400 == 0 || ((year % 4 == 0) && (year % 100 != 0))) {
      return true;
    } else {
      return false;
    }
  }
    public static long numberOfDays(long month, long year) {
      if (month == 4 || month == 6 || month == 9 || month == 11) {
        return 30;
    } else if (month == 2 && isLeapYear(month)) {
        return 29;
    } else if (month == 2 && !isLeapYear(month)) {
        return 28;
    }
    else {
      return 31;
      }
    }
}