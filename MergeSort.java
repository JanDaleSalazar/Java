/*
 * The goal is to sort numbers by their Collatz length.
It is conjectured that any number can be reduced to 1 by following these steps:
1) If the number is even divide it in 2

2) If the number is odd, multiply by 3 and add 1
 */
import java.util.*;
public class MergeSort{
    
    public static void main(String args []){

        Scanner sc = new Scanner(System.in);
        long start = sc.nextLong();
        long end = sc.nextLong();
        int target = sc.nextInt();
        int maxSize = (int)(end-start +1);
        long [] theArray = new long [maxSize];
        long [] origNumber = new long [maxSize];
        
        for(int i =0; i<maxSize;i++,start++){

            theArray[i]=collatz(start);
            origNumber[i]=start;

        }

        mergeSort(theArray,origNumber);
        System.out.println(origNumber[target-1]);

        }

    
    public static long collatz(long n){

        if(n==1) // base case
            return 0;
        else if(n%2 ==0)
            return 1+collatz(n/2); //+1 incrementing the amount of steps taking note of how many is taken
        else
            return 1+ collatz(3*n+1);
    }
    
    private static void mergeSort(long [] inputArray, long [] origNum) {

        int inputLength = inputArray.length;
        
        if (inputLength < 2) { // if the array is only contains one it means it is sorted 
             return;               // this is the base case
        }
        
        int midIndex = inputLength / 2; // this will split the array by finding the mid
        long[] leftHalf = new long[midIndex]; // left half
        long[] rightHalf = new long[inputLength - midIndex]; // right half
        long[] origL = new long[midIndex];
        long[] origR = new long[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++) {

            leftHalf[i] = inputArray[i];    //left half array will have the left side of our input 
            origL[i] = origNum[i];  

        }
        for (int i = midIndex; i < inputLength; i++) {

            rightHalf[i - midIndex] = inputArray[i]; // right half array will have the right side 
            origR [i - midIndex] = origNum[i];

        }
        
        mergeSort(leftHalf,origL); //calling it recursively 
        mergeSort(rightHalf,origR);
        
        merge(inputArray, origNum, leftHalf, rightHalf, origL, origR);
     }

    private static void merge (long[] inputArray, long [] origNum, long[] leftHalf, long[] rightHalf, long [] origL, long [] origR) {

        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        
        int i = 0, j = 0, k = 0; // 3 pointers
            // i will be the pointer for right, j will be for left and k will be for the merge
        while (i < leftSize && j < rightSize) { //while we ran out of the right and left side
            if (leftHalf[i] <= rightHalf[j]) { // checking if left is the lowest
                inputArray[k] = leftHalf[i]; // if so add left into the merge array
                origNum[k] = origL[i];
                i++; //next left half array
            }
            else {
                inputArray[k] = rightHalf[j]; //if so right half is the smallest is so add to merge array
                origNum[k] = origR[j];
                j++;
            }
            k++; //increment our merge array value so it will be placed
        }
        
        while (i < leftSize) { // if theres no more comparing to do then it will jst place the rest
            inputArray[k] = leftHalf[i];
            origNum[k] = origL[i];
            i++;
            k++;
        }
        
        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            origNum[k] = origR[j];
            j++;
            k++;
        }
    }
}

