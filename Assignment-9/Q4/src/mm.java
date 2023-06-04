public class mm {

 public static void main(String[] args) {

  int basenumber = 2, exponent = 3;
  long temp = 1;

  while (exponent != 0) {
   temp *= basenumber;
   --exponent;
  }

  System.out.println("Result: " + temp);
 }
}