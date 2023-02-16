/* 
 * The task is to take in a credit card number, and find out if it is a valid credit card number or not. Credit card numbers follow an algorithm called "Luhn's algorithm". 
The formula verifies a number against its check digit, which is the last digit. This number must pass the following test:
From the rightmost digit, which is the check digit, and moving left, double the value of every second digit. If the result of this doubling operation is greater than 9 (e.g., 8 × 2 = 16), then add the digits of the product (e.g., 16: 1 + 6 = 7, 18: 1 + 8 = 9) or, alternatively, the same result can be found by subtracting 9 from the product (e.g., 16: 16 - 9 = 7, 18: 18 - 9 = 9).
Take the sum of all the digits.
If the total modulo 10 is equal to 0 (if the total ends in zero) then the number is valid according to the Luhn formula; else it is not valid.
Assume an example of an account number "7992739871" that will have a check digit added, making it of the form 7992739871x. The sum of all the digits, processed as per steps 1 and 2, is 67+x. Thus x must be 3 to bring the total to be modulo 10 = 0. If x is not 3, then this is not a valid credit card number.
 */
public class CreditCard {
    public static void main(String args[]){
        String card = "4539682995824395";

        cardValid(card);
     }

     public static void cardValid(String card){
        boolean second;
        int nSum = 0;
        for(int i = card.length()-1; i>=0; i--){
            int d = card.charAt(i) - '0';

                if(second = true){
                    d = d*2;
                }
                if(d>=10){
                    d=d-9;
                }
                nSum =+ d;

                second = !second;



        }  if(nSum % 10 ==0){
            System.out.println("VALID");
        }else{
            System.out.println("INVALID");
        }
     }
}
	