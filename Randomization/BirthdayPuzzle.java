import java.util.Arrays;
//import java.util.Collections;

public class BirthdayPuzzle {
	public static void main(String[] args) {
   int numberOfPeople = Integer.parseInt(args[0]);
   int[] people = new int[numberOfPeople];
   int DAYS_IN_YEAR = 365;

   // give the people birthdays
   for (int i = 0; i < numberOfPeople; i++) {
    people[i] = (int)(Math.random() * DAYS_IN_YEAR);
   }
   
   // sort people in ascending or descending order to reduce number of checks to make in loop
   Arrays.sort(people);
   for (int i =0; i < numberOfPeople; i++) {
   }

   //  loop through people array, checking for duplicates
   int counter = 0;
   for (int i = 0; i < numberOfPeople - 1; i++) {
     if (people[i] == people[i + 1]) {
       counter = counter + 1;
     }
   }

   // check second to last one with last one
     if (people[numberOfPeople - 2] == people[numberOfPeople - 1]) {
       counter = counter + 1;       
     }

   System.out.println("Number of same birthdays: " + counter);



  }

}