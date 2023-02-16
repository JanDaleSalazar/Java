/*Take in a list of words and sort them by how many points they would earn in the game of Scrabble, with the lowest scoring words being outputted first. If two words have the same Scrabble score, then they should be sorted in alphabetical order. Letters in Scrabble earn the following points:
*/
import java.util.*;
public class Scrabble {
    
public static void main(String args[]) {
        
      Scanner sc = new Scanner (System.in);
      int howMany = Integer.parseInt(sc.nextLine()); //changed it into int parse int since spaces was detected with next()
      String [] words = new String[howMany];
      int [] counter = new int [howMany];
      int count = 0;
      
      for(int i = 0; i<words.length;i++){
          
          words[i] = sc.nextLine().toLowerCase();
          
      }
        
      HashMap<Character, Integer> scrabbleScore = new HashMap<Character, Integer>();    
           
            scrabbleScore.put('a',1);
            scrabbleScore.put('e',1);
            scrabbleScore.put('i',1);
            scrabbleScore.put('o',1);
            scrabbleScore.put('u',1);
            scrabbleScore.put('l',1);
            scrabbleScore.put('n',1);
            scrabbleScore.put('s',1);
            scrabbleScore.put('t',1);
            scrabbleScore.put('r',1);
            
            scrabbleScore.put('d',2);
            scrabbleScore.put('g',2);
            
            scrabbleScore.put('b',3);
            scrabbleScore.put('c',3);
            scrabbleScore.put('m',3);
            scrabbleScore.put('p',3);
            
            scrabbleScore.put('f',4);
            scrabbleScore.put('h',4);
            scrabbleScore.put('v',4);
            scrabbleScore.put('w',4);
            scrabbleScore.put('y',4);
            
            scrabbleScore.put('k',5);
            
            scrabbleScore.put('j',8);
            scrabbleScore.put('x',8);
            
            scrabbleScore.put('q',10);
            scrabbleScore.put('z',10);
            
            char pair;
            
            
            for(int i =0; i<words.length;i++){ //this loops through the word array
                count =0; //resetting the count each time per word
                
                for(int j = 0; j<words[i].length();j++){ //this loops through the length of each word
                    
                    pair = words[i].charAt(j);

                    if(String.valueOf(pair).matches("[^a-z]")){ //to check if the char pair isnt any special character or any numbers and jst ignores it

                        counter[i] = counter[i];

                    }else{
                    
                    count = count + scrabbleScore.get(pair);
                    
                    counter[i] = count;
                    }  
                   
                }
            }

      
    //bubble sorts the final list
        for(int i=counter.length-1;i>=0; i--){
            for(int j =0; j <i;j++){
            if(counter[j] > counter[j+1]){
                int temp = counter[j];
                 String tempWords = words[j];
                 counter[j]=counter[j+1];
                 words[j]=words[j+1];  
                 counter[j+1] = temp;
                 words[j+1] = tempWords;
            }if(counter[j] == counter[j+1]){
                //to compare one string with other string
                //this will return an int if the same 
                  if(words[j].compareTo(words[j+1])>0){
                      
                          int temp = counter[j];
                          String tempWords = words[j];

                          counter[j]=counter[j+1];
                           words[j]=words[j+1];  

                          counter[j+1] = temp;
                          words[j+1] = tempWords;
               
                  }
              }
        }
    }
            
    for(int i= 0;i<words.length; i++){
        System.out.println(words[i]);
      
    }
}
}
