public class Chapt15Ex1 {  

    
    public static void main(String[] args) {  
          
        int start, end;  
          
        Scanner scan = new Scanner(System.in);  
          
  
        System.out.println("Enter starting value : ");  
        start = scan.nextInt();  
        System.out.println("Enter End value : ");  
        end = scan.nextInt();  
          
      
        while(start <= end)  
        {  
            System.out.println(start);  
            start++;  
        }  
  
    }  
  
}  