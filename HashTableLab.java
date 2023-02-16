/*
 The goal is to insert all the words into the hash table and then find them all again with the minimum number of collisions. 
 You can use any hashing strategy you like. 
 The main method that reads in the data is provided (see Java 8 code stub). There is also a HashTable class - you must use the check() method to check for a collision when you are finding a word. 
 Every time you make an unsuccessful check() call (i.e. a collision), a counter ticks up. You have to keep this as low as possible. You should just complete the fill() and find() methods. When you run the code, it will output the number of collisions you have. 
 If you see the word "error!" it means that your find() method is not finding the words properly in the hash table.
 */
import java.util.*;
import java.io.*;

class HashTable{
   
    private String[] hashTable;
    private long total=0; //size variable of the array

    public HashTable(String[] input){
        hashTable = input;
    }

    public boolean check(int slot, String check){
        if(hashTable[slot].equals(check)){
            return true;
        }else{
            total++;
            return false;
        }
    }
   
    public long gettotal(){
        return total;
    }
}

class Solution{
    public static String [] hashArray;
   static int size =0;
    static int arraySize;
    
     
    public int find(int size, HashTable mytable, String word){
       
        //fill this in so as to minimize collisions
        //takes in the HashTable object and the word to be found
        //the only thing you can do with the HashTable object is call "check"
        //this method should return the slot in the hashtable where the word is
        if(isPrime(size)){
            
            arraySize = size;
        }else {
            int primeCount = getNextPrime(size);
            
            arraySize = primeCount; //if given size of hash table not prime then it is changed into primeCount
        }
        //on the day change this arraySize = size;

            int hashVal = hashFunction1(word);
            int stepSize = hashFunction2(word);

            
            while(hashArray[hashVal] != null){
                
                if(mytable.check(hashVal,word)){
                return hashVal;
                
                }else{
                hashVal = hashVal + stepSize;
                hashVal = hashVal % arraySize;
                
                }

                
            }

            return -1;
        }
       

    
   
    public  String[] fill(int size, String [] array){
       
        //takes in the size of the hashtable, and the array of Strings to be placed in the hashtable
        //this should add all the words into the hashtable using some system
        //then it should return the hashtable array
      
        if(isPrime(size)){
            hashArray = new String[size];
            arraySize = size;
        }else {
            int primeCount = getNextPrime(size);
            hashArray = new String[primeCount];
            arraySize = primeCount; //if given size of hash table not prime then it is changed into primeCount
        }
        // on the day change this to arraysize = size NB
        
        for(int i=0;i<array.length;i++){
    
            insert(array[i]);
            
        }
        return hashArray;
       
    }

    
    
    public static boolean isPrime(int num){ //returning boolean to check if the number given is a prime
        for(int i =2; i*i <=num; i++){ //starting from the lowest prime 
            if(num %i == 0){  //if its divisible by soemthing apart from itself then its not a prime
                return false;
            }
        } 
        return true;
    }
    
    public static int getNextPrime(int minNumber){ //the number passed in will check the next bigger prime
        for(int i  = minNumber; true; i++){ // indefinite loop
            if(isPrime(i)){ //if i prime 
                return i; //this will break the loop once it returns i
            }
        }
    }
    
    public static int  hashFunction1(String word){
        
         int hashVal = hashCodeValue(word); // this .hasCode() will convert the word into a numeric position im putting the numeric val into a smaller size
         hashVal = hashVal % arraySize; // moding it into the array size will achieve us finding an index position more suitable to the array size
        
        return hashVal; //ideal index position we would like to put the word into
    }
    
    
    public static int hashFunction2(String word){ //return step size
        int hashVal = hashCodeValue(word); // we need to ensure this wont be the same code as hashfunction 1
         hashVal = hashVal % arraySize;
         
         return  283 * hashVal % arraySize; // use a prime number less than array size  & needs to be prime
         
    }
    public static int hashCodeValue(String word){ //hashing code method which allow to have it unique int
        int resultNum =3;
        for(int i=0; i<word.length();i++){
            resultNum = ((resultNum*7) +((word.charAt(i)- 'a')))%arraySize; //takes one character and mutiply it by the power to the length of the word
        }
        return resultNum;
    }

    
    public void insert(String word){
        int hashVal =hashFunction1(word);
        int stepSize = hashFunction2(word);
        while(hashArray[hashVal]!= null){ //if its not null and theres data then do the second step
            hashVal = hashVal + stepSize; //increasing the hashVal 
            hashVal = hashVal % arraySize; // moding it finding a smaller apporpriate size
            
        }
        hashArray[hashVal] = word; // when we go out of the while loop we have found our ideal position to put the word
        size++; //increasing the size, checking how many elements have been put into the size of the hashtable
    }
    
     
    
    
}
public class HashTableLab {
    
public static void main(String args[]) {
         Dictionary dictionary = new Dictionary();
       
        String cars [] = {"ford", "mazda", "vanessa", "jan","december", "november","helloworld", "eight","nine","hell","heaven","jaysus","nike","yeezy"};
       
        int numInput = 60000;
        String array[] = new String[dictionary.getSize()];
        for(int i =0; i<dictionary.getSize();i++){
            array[i]=dictionary.getWord(i);
            // array[i]=array[i].replaceAll("[a-zA-Z0-9]","");
        }

        Solution method = new Solution();
        
        
        //350000
        method.fill(numInput,array);

        String [] table = method.fill(numInput,array);

        // for(int i =0; i<table.length;i++){
        //     System.out.println(table[i]);
        // }
        HashTable  tables = new HashTable(table);

        // System.out.println(array.length);
        System.out.println(method.find(numInput,tables,"facioscapulohumeral"));
        System.out.println(tables.gettotal());
        
        
        
        
       
        
    }
}