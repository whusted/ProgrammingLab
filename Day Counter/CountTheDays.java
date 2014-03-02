public class CountTheDays {
	public static void main(String[] args) {
		long firstMonth = Long.parseLong(args[0]);
		long firstDay = Long.parseLong(args[1]);
		long firstYear = Long.parseLong(args[2]);
		long secondMonth = Long.parseLong(args[3]);
		long secondDay = Long.parseLong(args[4]);
		long secondYear = Long.parseLong(args[5]);
    long firstDateTotal = 0;
    long secondDateTotal = 0;
		long sum = 0;
    long february = 28;
    long january, march, may, july, august, october, december;
      january = march = may = july = august = october = december = 31;
    long april, june, september, november;
      april = june = september = november = 30;
    long oneYear = january + february + march + april + may + june + july + august + september + october + november + december;
        //finding february for firstYear
        if (firstYear % 400 == 0) {
          february = 29;
        } else if (firstYear % 100 == 0) {
          february = 28;
        } else if (firstYear % 4 == 0) {
          february = 29;
        } else {
          february = 28;
        }
    //finding firstDateTotal
    if (firstMonth == 1) {
      firstDateTotal = firstDay;
    } else if (firstMonth == 2) {
      firstDateTotal = january + firstDay;
    } else if (firstMonth == 3) {
      firstDateTotal = (january + february) + firstDay;
    } else if (firstMonth == 4) {
      firstDateTotal = (january + february + march) + firstDay;
    } else if (firstMonth == 5) {
      firstDateTotal = (january + february + march + april) + firstDay;
    } else if (firstMonth == 6) {
      firstDateTotal = (january + february + march + april + may) + firstDay;
    } else if (firstMonth == 7) {
      firstDateTotal = (january + february + march + april + may + june) + firstDay;
    } else if (firstMonth == 8) {
      firstDateTotal = (january + february + march + april + may + june + july) + firstDay;
    } else if (firstMonth == 9) {
      firstDateTotal = (january + february + march + april + may + june + july + august) + firstDay;
    } else if (firstMonth == 10) {
      firstDateTotal = (january + february + march + april + may + june + july + august + september) + firstDay;
    } else if (firstMonth == 11) {
      firstDateTotal = (january + february + march + april + may + june + july + august + september + october) + firstDay;
    } else if (firstMonth == 12) {
      firstDateTotal = (january + february + march + april + may + june + july + august + september + october + november) + firstDay;
    }

    //finding february for secondYear
        if (secondYear % 400 == 0) {
          february = 29;
        } else if (secondYear % 100 == 0) {
          february = 28;
        } else if (secondYear % 4 == 0) {
          february = 29;
        } else {
          february = 28;
        }
    //finding secondDateTotal
    if (secondMonth == 1) {
      secondDateTotal = secondDay;
    } else if (secondMonth == 2) {
      secondDateTotal = january + secondDay;
    } else if (secondMonth == 3) {
      secondDateTotal = (january + february) + secondDay;
    } else if (secondMonth == 4) {
      secondDateTotal = (january + february + march) + secondDay;
    } else if (secondMonth == 5) {
      secondDateTotal = (january + february + march + april) + secondDay;
    } else if (secondMonth == 6) {
      secondDateTotal = (january + february + march + april + may) + secondDay;
    } else if (secondMonth == 7) {
      secondDateTotal = (january + february + march + april + may + june) + secondDay;
    } else if (secondMonth == 8) {
      secondDateTotal = (january + february + march + april + may + june + july) + secondDay;
    } else if (secondMonth == 9) {
      secondDateTotal = (january + february + march + april + may + june + july + august) + secondDay;
    } else if (secondMonth == 10) {
      secondDateTotal = (january + february + march + april + may + june + july + august + september) + secondDay;
    } else if (secondMonth == 11) {
      secondDateTotal = (january + february + march + april + may + june + july + august + september + october) + secondDay;
    } else if (secondMonth == 12) {
      secondDateTotal = (january + february + march + april + may + june + july + august + september + october + november) + secondDay;
}
//calculating days between
if (firstYear >= secondYear) {
  sum = (firstYear * oneYear) - (secondYear * oneYear) + Math.abs(secondDateTotal - firstDateTotal);
} else if (firstYear < secondYear) {
  sum = (secondYear * oneYear) - (firstYear * oneYear) + Math.abs(secondDateTotal - firstDateTotal);
}
System.out.println(sum);
  }
}