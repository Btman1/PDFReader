
//This is my second program for the midterm.
//By Allen Yao 
//Version one
  
   
import java.util.Scanner;  
public class SecondProgramofMidterm {  
  
      
    public static void main(String[] args) {  
          
        int x;  // for the periods that will appear
        String y, Z;   //for my 2 words the use will enter
        Scanner scan = new Scanner(System.in);  
        System.out.println("First, enter the first word : ");  
        y = scan.nextLine();  
        System.out.println("Then, enter second word : ");  
        Z = scan.nextLine();  // those two are for the user entering words
          
        x = y.length()+Z.length();  
                System.out.println("prepare to be dazzled"); //building up some suspense
                
          
        System.out.print(y);  // my first word
       
        while(x < 30)  // this is my loop
        {  
            System.out.print(".");  
            x++;  
        }   // this prints periods in between the words
        System.out.println(Z);  //my second word
  
    }  
  
}  
  
