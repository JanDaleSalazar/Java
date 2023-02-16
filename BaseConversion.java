
 /*The goal is to change a given number from one base to another.
  The first line contains an integer which is the base that the number N is represented in (base#1).
The second line contains an integer which is the base that the number N should be transformed into (base#2).
The third line contains a value which represents N in the specified base. 
Note that digits after 9 for higher bases are represented by lower case alphabetic characters (e.g. "ten" is a, "eleven" is b etc.)

  */

import java.util.*;
public class BaseConversion{


    public static void main(String agrs []){
        Scanner sc = new Scanner(System.in);
        String minus ="-"; 
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        String N = (sc.next()).toLowerCase(); //make sure its a lower case it takes in
        String comp =N.substring(0,1); //to check if theres a minue symbol

        if(comp.equals(minus) == true){
            String num3 = N.substring(1); // to ignore the minus if there is one

            long conversion = base10(num3,num1); 
            
                System.out.println("-" +modOp(num2, conversion));

        }else{

                 long conversion = base10(N,num1); 

                System.out.println(modOp(num2, conversion));

            }

    }


    public static long base10(String num3, int num1){
            int [] numbers = new int [num3.length()]; //array size according to number
            long sum =0;
            
            HashMap<Integer, Integer> letters = new HashMap<Integer, Integer>();
            for(int i =0; i<23; i++){
                letters.put(49+i, (10+i));
            }   // hash map starting at 49 which will be equalled to the value of the lower case letter according
                // to the ASCII then will turn that ascii value into decimal value so 97(a) - 48 =49

        for(int i=0; i<num3.length(); i++){
            
            int digits =num3.charAt(i) -48;
            if(digits>=49){
                numbers[i] = letters.get(digits);
            }else{
                numbers[i] = digits;
            }
            
        }

        for( int i =0, j = num3.length()-1; i<num3.length(); i++, j--){
            
            sum = sum +(long) (numbers[i]*(Math.pow(num1,j)));
 
        }
        return sum;
        // System.out.println(sum);

    }

    public static StringBuilder modOp(int num2,long conversion) {
        long quotient;
        long remainder;
        
        char c;
        String lastnum ="";
        HashMap<Long, Character> letters = new HashMap<Long, Character>();
        for(int i =0; i<23; i++){
            letters.put((long) (10+i), (char)('a'+i));
        } //using the remainder if its larger than 10  then uses the key to get the value of the letter

        quotient = conversion;

        while (quotient > 0){
            remainder = quotient % num2; // to get remainder mod the base with base 10 conversoin
            quotient = quotient /num2; //to update the conversion divide it the base wanting to change it into and changing quotient value
            if(remainder>=10){ 
                c = letters.get(remainder); // if the remainder is 10 it will access the hashmap and change the value decimal into a char
            }else{
            c = (char) (remainder + 48);}  //casting char to convert long into char and +48 since want the value to be decimal 0-9
            lastnum = lastnum +  c; // adding char into the string 
            
        }

        StringBuilder rev = new StringBuilder(); //using string builder function
        rev.append(lastnum);
        rev.reverse();
        return rev;

        
    }



}