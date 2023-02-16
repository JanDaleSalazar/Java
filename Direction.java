/*
 In this task you will get a set of instructions to get from a home location to a destination location. You have to give the instructions which begin at the destination location and return to the home location. In other words, you need to reverse the directions to get home. Sometimes a mistake will be made with the directions, meaning that the latest direction should be deleted. The possible set of directions is "Go North", "Go South", "Go East" and "Go West". Another possible instruction is "Go Back" which means to undo the latest step. The instruction "Arrived" means the sequence of directions is complete.
The way to solve this problem is to push all the instructions onto the stack, and to pop and 'flip' directions as appropriate to have a reversed set of instructions to get you home. 
You can copy and paste the code for a Stack class from the notes and alter it to work with Strings (or maybe use chars or ints if you want to represent the instructions in a different format).
NOTE: You will never be asked to "Go Back" without at least 1 previous valid direction
 */
import java.util.*;

public class Direction {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int howMany = 100;
        Stack theStack = new Stack(howMany);
        String back = "Go Back";
        String arrived = "Arrived";
        
        for(int i=0; i<howMany; i++){
            
            String instruction = sc.nextLine();
            
                if(back.compareTo(instruction) ==0){
                    theStack.pop();
                }else if(arrived.compareTo(instruction)==0){
                    break;
                }else{
                
                 theStack.push(instruction);
                }
        }
        
        HashMap<String, String> oppDirection = new HashMap<String, String>();
        oppDirection.put("Go North", "Go South");
        oppDirection.put("Go South", "Go North");
        oppDirection.put("Go West", "Go East");
        oppDirection.put("Go East", "Go West");
        
        
        while(!theStack.isEmpty()){
            String ans = theStack.pop();
            
            System.out.println(oppDirection.get(ans));
            
        }
      
    }
    
public static class Stack{ 
    private int maxSize;
    private String[] stackArray;
    private int top;
    
    public Stack(int s){
        maxSize =s;
        stackArray = new String[maxSize];
        top = -1;
    }
    
    public void push(String j) { //put item on top of stack
        top++;
        stackArray[top] = j;
    }
    
    public String pop(){ // take item from top of stack
        return stackArray[top--]; //access and decrement top
    }
    
    public String peek(){ //peek at top ofstack
        return stackArray[top];
    }
    
    public boolean isEmpty() { //true if stack is empty
    
        return (top ==-1);
    }
    
    public boolean isFull(){ //true if  stack is full 
        
        return (top ==maxSize-1);
        
    }
    
    public void makeEmpty(){ //empty stack
        top=-1;
        
    }
    
}//end of stack class
    
}
