/*
 *The goal is to find your way out of the maze.
  You have 200 moves to make, before you die.
   You can choose to move "north", "south", "east" or "west". Each maze is a 20x20 grid, with walls represented by "X" and spaces by " ".
    You will appear at some point in the maze but you don't know where.
  Each maze has exactly one exit.
 */
import java.util.*;
public class Maze{
    public static void main(String args[]){
        int lives = 200;
        Scanner myScanner = new Scanner(System.in);
        String [] input = new String[20];
        // for(int i =0; i<20;i++){
        //     input[i]= myScanner.nextLine();
        // }
        input [0] ="XXX XXXXXXX XXXXXX X";
        input [1] ="XXX XXXXXXX XXXXXX X";
        input [2] = "XXX      XX XXXX   X";
        input [3] = "XXXXXXX XXXXXXXXXXXX";
        input [4] ="XXXXXXX XX      XXXX";
        input [5] ="XXX  XXXXX XXXX XXXX";
        input [6] = "XX  X XXXX   XX XXXX";
        input [7] = "XXX XXXXXXXX XX XXXX";
        input [8] = "XX  X  XXXXX XX XXXX";
        input [9] = "XXXXXX       XX XXXX";
        input [10] = "X XXXX XX  XXXX XXXX";
        input [11] = "     XXXX  XXXX XXXX";
        input [12] = "XXXXXXXXXXXXXXX XXXX";
        input [13] = "XXXXXX  XXXX    XXXX";
        input [14] = "XX XX XXXXXX XX XXXX";
        input [15] = "X  XX XXXXXX XX XXXX";
        input [16] = "XX XX X  X   XX XX  ";
        input [17] = "X  XXXXXXX XXXX XX X";
        input [18] = "XX XXXXXXX XXXXXXX X";
        input [19] = "XX XXXXXXX XXXXXXX X";
    
    int posX = Integer.parseInt(myScanner.nextLine());
    int posY = Integer.parseInt(myScanner.nextLine());
    boolean [][] maze = new boolean [20][20];
    for(int i=0; i<20;i++){
        for(int j=0; j<20;j++){
            if(input[i].charAt(j)=='X'){
                maze[i][j]=false;

            }else{
                maze[i][j]=true;
            }
        }
    }
    Brain myBrain = new Brain();

    while(lives>0){
        String move = myBrain.getMove(maze[posX-1][posY],maze[posX+1][posY],maze[posX][posY+1],maze[posX][posY-1]);
        if(move.equals("north")&& maze[posX-1][posY]){
            posX--;
            
        }else if(move.equals("south")&&maze[posX+1][posY]){
            posX++;
            
        }else if(move.equals("east")&&maze[posX][posY+1]){
            posY++;
            
        }else if(move.equals("west")&&maze[posX][posY-1]){
            posY--;
            
        }
        lives--;
        if(posY%19==0 || posX%19==0){
            System.out.println(posX+","+posY);
            System.exit(0);
        }

    }
    System.out.println("You died in the maze!");

}

}

class Brain{
    
    public boolean [][] wasVisited = new boolean[40][40];
    
    public Stack<Integer> stackX = new Stack<Integer> ();
    public Stack<Integer> stackY = new Stack<Integer> ();
    
    public StackX stack = new StackX();
    
    public int vertex =0;
    int rowX =20;
    int colY =20;
    ;


    

    public String getMove(boolean north, boolean south, boolean east, boolean west){
       
       wasVisited[rowX][colY] = true;

       if(!north){
           wasVisited[rowX-1][colY]=true;
       }
       if(!south){
           wasVisited[rowX+1][colY]=true;
           
       }
       if(!west){
           wasVisited[rowX][colY-1]=true;
           
       }
       if(!east){
           wasVisited[rowX][colY+1]=true;
           
       }
       System.out.println(rowX +","+colY);
          
          if(wasVisited[rowX-1][colY]==false){
           
           stack.push("south");
           rowX = rowX -1;
           
           return "north";
          }else if(wasVisited[rowX+1][colY]==false){
       
            stack.push("north");
            rowX = rowX +1;
             
            return "south";
           }
           else if(wasVisited[rowX][colY+1]==false){
           
            stack.push("west");
            colY = colY +1;
            
            return "east";
           }
           else if((wasVisited[rowX][colY-1]==false)){
        
            stack.push("east");
            colY = colY -1;
           
 
            return "west";
           }
           else{
            
                
            String word = stack.pop();
             if(word.equals("north")){
                // rowX=(Integer)(stackX.pop());
                 rowX = rowX -1;
                
                
                return "north";
             }else if(word.equals("south")){
                
                rowX =rowX+1;
                
                
                return "south";
             }else if(word.equals("west")){
               
                 colY= colY -1;
                
                
                return "west";
             }else if(word.equals("east")){
                
                colY= colY +1;
                
                return "east";
             }
            
            
             } 
           return "west";
           
            }
   
      
       


    }



class StackX
{
    private final int SIZE = 200;
    private String [] st;
    private int top;

    public StackX(){ //constructor
        st = new String[SIZE]; // make array
        top =-1;
    }

    public void push(String j){ //put item on stack
        st[++top] =j;
    }

    public String pop(){ //take item off
        return st[top--];
    }

    public String peek(){
        return st[top]; //peek at top of stack
    }

    public boolean isEmpty(){
        return (top ==1); //true if nothing
    }

}

