   
  
import java.util.Scanner;  
  
public class Final2 {  
  
        public static void main(String[] args) {  
          
        int x;  
        double y = 0.0;  
        Scanner scan = new Scanner(System.in);  
        System.out.println("Weight of order : ");  
        x = scan.nextInt();  
          
        while(x > 0)// has to be greater than zero  
        {  
            if(x <= 10)  
            {  
                y = 3.00;  // weight less than 10
            }  
            else  
            {  
                y = 3.00 + ((x - 10) * 0.25);  // weight more than 10
            }  
            System.out.println("Shipping cost : " + y);  
            System.out.println("Weight of order : ");  
            x = scan.nextInt();  
        }  
        System.out.println("bye");  
          
    }  
  
}  