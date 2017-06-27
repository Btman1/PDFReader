//this is my 3rd program of the midterm
// By Allen Yao
import java.util.Scanner;

public class sumofnumbers 
{




	public static void main(String[] arg) { // the normal programming stuff

	    System.out.println("Enter a number");   

	   Scanner scan = new Scanner(System.in);
	   int n = scan.nextInt(); //here you want to enter a number


	   int sum = 0;
	   for(int i = 0;i <= n; i++)
	              { 
	      
	       System.out.println("Squares are " + sum*sum); //this is where the square is computed
	                  System.out.println("Cubes are " + sum*sum*sum); //this is where the cube is computed
	                  sum=sum+1 ;
	
	                  
	               }
	           }  
}	