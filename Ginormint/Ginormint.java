/**
   This class models arbitrarily large, signed integers (at least MAXINT binary digits). 
   The class includes methods for all of the basic arithmetic operations (sum, difference, product, 
   quotient and remainder), for comparing numbers, converting them to strings, etc.
*/


public class Ginormint {

      public static final Ginormint NEGATIVE_ONE = new Ginormint ( "-1" );
      public static final Ginormint ZERO = new Ginormint ( "0" );
      public static final Ginormint ONE = new Ginormint ( "+1" );

      private char sign;
      private String number;

   /**
      Constructs a Ginormint from a String. The string must be "reasonably well-formed," i.e., it must have the appearance 
    of a signed integer; some examples of good strings are "-1439283467", "004245", and "+324". Spaces are allowed at 
    the ends of the string, but embedded spaces are not permitted. Leading '+' signs are optional.
   */
  public Ginormint ( String s ) {
    
    // sign

    if (s.charAt(0) == '-') {
      this.sign = '-';
      this.number = s.substring(1);
    } else if (s.charAt(0) == '+') {
      this.sign = '+';
      this.number = s.substring(1);
    } else {
      this.sign = '+';
      this.number = s;
    }

   }


   /**
      OPTIONAL: This static method returns a Ginormint from a given bit string. The argument is presumed to represent an unsigned integer.
   */
   public static Ginormint fromBitString ( String s ) {
      throw new UnsupportedOperationException();
   }
   
   /**
      OPTIONAL: Returns a copy of this Ginormint.
   */
   public Ginormint copy () {
      throw new UnsupportedOperationException();
   }   


   /**
    Performs a given arithmetic operation (<i>args[1]</i>) on two Ginormints (specified by <i>args[0]</i> and <i>args[2]</i>). 
    The legal operations are <i>sum</i>, <i>difference</i>, <i>product</i>, <i>quotient</i>, and <i>remainder</i>.
    Example of use: <i>java Ginormint 245328765823458723645 product 987987987987987987987</i>. 
   */
   public static void main ( String[] args ) {
   
    //validity check


    //make two ginormints
    Ginormint firstGinormint = new Ginormint( args[0] );
    Ginormint secondGinormint = new Ginormint( args[2] );

   //determine operation
   if (args[1].compareTo("sum") == 0) {
    System.out.println("Sum: " + firstGinormint.sum(secondGinormint));
    } else if (args[1].compareTo("difference") == 0) {
        System.out.println("Difference: " + firstGinormint.difference(secondGinormint));
    } else if (args[1].compareTo("product") == 0) {
        System.out.println(firstGinormint.product(secondGinormint));
    } else if (args[1].compareTo("quotient") == 0) {
        System.out.println(firstGinormint.quotient(secondGinormint));
    } else if (args[1].compareTo("remainder") == 0) {
        System.out.println(firstGinormint.remainder(secondGinormint));
    } else {
        System.out.println("Please provide valid input: <Ginormint> <operation> <Ginormint>");
    }
  
}
    /**
    OPTIONAL: This method returns the binary representation this Ginormint as a string of zeros and ones. 
    This Ginormint is presumed to be non-negative.
  */
   public String toBitString () {
      throw new UnsupportedOperationException();
   }


   /**
    Returns a stringy representation of this Ginormint. The initial character is the sign.
   */
   public String toString () {

    return this.sign + this.number;
  
   }

   /**
     OPTIONAL: Returns true iff this Ginormint is equivalent to the argument.
   */
   public boolean isEqualTo ( Ginormint n ) {
      throw new UnsupportedOperationException();
   }


   /**
     OPTIONAL: Returns true if and only if this Ginormint is greater than the argument.
   */
   public boolean isGreaterThan ( Ginormint n ) {
    int inThisNumber;
    int inOtherNumber;
       //both positive
    if ( this.sign == '+' && n.sign == '+' ) {

        if ( this.number.length() > n.number.length() ) {
          return true;
        } else if (this.number.length() == n.number.length()) {
          for (int i = 0; i < this.number.length(); i++ ) {
            inThisNumber = Character.getNumericValue(this.number.charAt(i));
            inOtherNumber = Character.getNumericValue(n.number.charAt(i));
            
            if (inThisNumber > inOtherNumber) {
              return true;
            } else if (inThisNumber < inOtherNumber) {
              return false;
            } else {
              //continue loop--both numbers were the same
            }

          }
          }
        {
          return false;
        }

        //both negative
    } else if ( this.sign == '-' && n.sign == '-' ) {

        if ( this.number.length() > n.number.length() ) {
          return false;    
        } else if (this.number.length() == n.number.length()) {
          for (int i = 0; i < this.number.length(); i++ ) {
            inThisNumber = Character.getNumericValue(this.number.charAt(i));
            inOtherNumber = Character.getNumericValue(n.number.charAt(i));
            
            if (inThisNumber > inOtherNumber) {
              return false;
            } else if (inThisNumber < inOtherNumber) {
              return true;
            } else {
              //continue loop--both numbers were the same
            }
          }
          }
          return false;
        
      
        //first negative, second positive
     } else if (this.sign == '-' && n.sign == '+') {

        if ( this.number.length() > n.number.length() ) {
          return false;    
        } else if (this.number.length() == n.number.length()) {
          for (int i = 0; i < this.number.length(); i++ ) {
            inThisNumber = Character.getNumericValue(this.number.charAt(i));
            inOtherNumber = Character.getNumericValue(n.number.charAt(i));
            
            if (inThisNumber > inOtherNumber) {
              return false;
            } else if (inThisNumber < inOtherNumber) {
              return true;
            } else {
              //continue loop--both numbers were the same
            }
          }
          }
          return false;
        // first positive, second negative
     } else if (this.sign == '+' && n.sign == '-') {

        if ( this.number.length() > n.number.length() ) {
          return true;
        } else if (this.number.length() == n.number.length()) {
          for (int i = 0; i < this.number.length(); i++ ) {
            inThisNumber = Character.getNumericValue(this.number.charAt(i));
            inOtherNumber = Character.getNumericValue(n.number.charAt(i));
            
            if (inThisNumber > inOtherNumber) {
              return true;
            } else if (inThisNumber < inOtherNumber) {
              return false;
            } else {
              //continue loop--both numbers were the same
            }
          }
          }
          return true;
        }
      //final return statement
      return false;
    }


   /**
     OPTIONAL: Returns true if this Ginormint is less than the argument.
   */

   public boolean isLessThan ( Ginormint n ) {
      throw new UnsupportedOperationException();
   }

   public int char2int (Character c) {
    return Character.getNumericValue( c );
   }

   public String int2string (int i) {
    return Integer.toString( i );
   }

   public String padWithZeros( int l, String smallString ) {
     for (int k = smallString.length(); k < l; k++) {
         smallString = "0" + smallString;
     }
     return smallString;
   }
   
   /**
     Returns the sum of this Ginormint and the argument.
   */
   public Ginormint sum ( Ginormint n ) {

    Ginormint thisGino = new Ginormint(this.sign + this.number);
    String result = "";
    int summed;
    Ginormint lesserGino;
    Ginormint greaterGino;
    int carry = 0;
  
    Ginormint subtracted;
    Ginormint added;
    // check if substraction should be performed instead
    if (thisGino.sign == '+' && n.sign == '-') {
      System.out.println("Sum: " + thisGino.difference(n));
      System.exit(0);
    } else if (thisGino.sign == '-' && n.sign == '+') {
      thisGino.sign = '+';
      subtracted = thisGino.difference(n);
      subtracted.sign = '-';
      System.out.println("Sum: " + subtracted);
      System.exit(0);
    } else if (thisGino.sign == '-' && n.sign == '-') {
      thisGino.sign = '+';
      n.sign = '+';
      added = thisGino.sum(n);
      added.sign = '-';
      System.out.println("Sum: " + added);
      System.exit(0);
    }
    //set lesser and greater ginos 
    if (isGreaterThan(n)) {
      lesserGino = n;
      greaterGino = thisGino;
    } else {
      lesserGino = thisGino;
      greaterGino = n;
    }
    //pad with zeros
    lesserGino.number = padWithZeros(greaterGino.number.length(), lesserGino.number);
    
    //iterate through, starting at one's column
    int j = greaterGino.number.length() - 1;
    for (int i = lesserGino.number.length() - 1; i >= 0; i--, j--) {
      //sum beginning at one's place.
    summed = ( char2int( lesserGino.number.charAt(i) ) + char2int( greaterGino.number.charAt(j) ) + carry );
      if (summed > 9) {
        summed = char2int( (summed + "").charAt((summed + "").length() - 1) );
        carry = 1;
      } else {
        carry = 0;
      }
      result = int2string(summed) + result;
    }
    if (carry == 1) {
      result =  "1" + result;
    }

      return new Ginormint(result);
   }

      public String inject( int index, int desired, String source ) {
        char desiredChar = Integer.toString(desired).charAt(0);
        char[] result = source.toCharArray();
        result[index] = desiredChar;

        return new String(result);

      }
   /**
     Returns the difference of this Ginormint and (i.e., minus) the argument.
   */

   public Ginormint difference ( Ginormint n ) {

    Ginormint thisGino = new Ginormint(this.sign + this.number);
    String result = "";
    int subtracted;
    Ginormint lesserGino;
    Ginormint greaterGino;
    
    Ginormint added;
    //check if addition should be performed
    if (thisGino.sign == '+' && n.sign == '-') {
      n.sign = '+';
      System.out.println("Difference: " + thisGino.sum(n));
      System.exit(0);
      
    } else if (thisGino.sign == '-' && n.sign == '+') {
      thisGino.sign = '+';
      added = thisGino.sum(n);
      added.sign = '-';
      System.out.println("Difference: " + added);
      System.exit(0);
      
      //not being used...
    } else if (thisGino.sign == '-' && n.sign == '-') {
      thisGino.sign = '+';
      added = thisGino.sum(n);
      added.sign = '-';
      System.out.println("Difference: " + added);
      System.exit(0); 
    }

    //set lesser and greater ginos 
    if (isGreaterThan(n)) {
      lesserGino = n;
      greaterGino = thisGino;
    } else {
      lesserGino = thisGino;
      greaterGino = n;
    }
    //pad with zeros
    lesserGino.number = padWithZeros(greaterGino.number.length(), lesserGino.number);

    //iterate through, starting at one's column
    int j = greaterGino.number.length() - 1;
    for (int i = lesserGino.number.length() - 1; i >= 0; i--, j--) {
      int borrow = 0;
  
      if ( char2int( lesserGino.number.charAt(i) ) > char2int( greaterGino.number.charAt(j) ) ) {
        //borrow
        for (int k = j - 1; k >= 0; k--) {
          if ( char2int(greaterGino.number.charAt(k)) > 0 ) {
            greaterGino.number = inject(k, char2int(greaterGino.number.charAt(k)) - 1, greaterGino.number);
            borrow = 10;
            break;
          } else {
              greaterGino.number = inject(k, 9, greaterGino.number);
          }
        }
      }
    subtracted = ( char2int( greaterGino.number.charAt(j) )  + borrow - char2int( lesserGino.number.charAt(i) ) );
      result = int2string(subtracted) + result;
    }
      return new Ginormint(result);
    }


   /**
     Returns the product of this Ginormint and the argument.
   */
   public Ginormint product ( Ginormint n ) {

      throw new UnsupportedOperationException();

   }

   /**
     Returns the quotient of this Ginormint and (i.e., divided by) the argument.
   */
   public Ginormint quotient ( Ginormint n ) {
      throw new UnsupportedOperationException();
   }


   /**
Returns the remainder of this Ginormint if divided by the argument. It is 
     similar to Java's infix modulo operator (%).
   */
   public Ginormint remainder ( Ginormint n ) {
      throw new UnsupportedOperationException();
   }


   /** OPTIONAL: Returns the absolute value of this Ginormint. */
   public Ginormint absoluteValue () {
      throw new UnsupportedOperationException();
   }
   
  

}


