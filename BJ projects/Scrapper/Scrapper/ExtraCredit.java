
/**
 * Write a description of class ExtraCredit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class ExtraCredit {
public static void main(String[] args){
  
    String x;
    int numPeople = 0;
    boolean lightUno = false;
    boolean lightDos = false;
    boolean lightTres = false;
    
    Scanner scan = new Scanner(System.in);
  while (true) {
    System.out.println("Enter a letter: A,R,L,O,Q,W");
    x = scan.nextLine();
    if (x.equalsIgnoreCase("A")){
        int y;
        int z;
 
        System.out.println("Enter an integer");
        y = scan.nextInt();
        scan.nextLine();
        if (y < 0){
           System.out.println("Not VALID... input ignored :)");
        }
        else {
            numPeople = numPeople + y;
            System.out.println("The number of people in the class is " + numPeople);
        }
    }
    if (x.equalsIgnoreCase("R")){
        int a;
        int b;
 
        System.out.println("Enter an integer");
        a = scan.nextInt();
        scan.nextLine();
        numPeople = numPeople - a;
        if(a > numPeople){
            numPeople = 0;
        }
        System.out.println("The number of people in the class is  " + numPeople);
       
    }
    if (x.equalsIgnoreCase("Q")){
        System.out.println("SHUTTING DOWN...");
        break;
    }
    if (x.equalsIgnoreCase("L")){
        int c;
        System.out.println("enter 1, 2, or 3");
        c = scan.nextInt();
        scan.nextLine();
        if(c == 1){
            lightUno = true;
        }
        if(c == 2){
            lightDos = true;
        }
        if(c == 3){
            lightTres = true;
        }
        if(lightUno){
            System.out.println("Light one is on");
        }
        if(lightDos){
            System.out.println("Light two is on");
        }
        if(lightTres){
            System.out.println("Light three is on");
        }
    }
    if (x.equalsIgnoreCase("O")){
        int d;
        System.out.println("enter 1, 2, or 3");
        d = scan.nextInt();
        scan.nextLine();
        if(d == 1){
            lightUno = false;
        }
        if(d == 2){
            lightDos = false;
        }
        if(d == 3){
            lightTres = false;
        }
        if(lightUno == false){
            System.out.println("Light one is off");
        }
        if(lightDos == false){
            System.out.println("Light two is off");
        }
        if(lightTres == false){
            System.out.println("Light three is off");
        }
       
    }
    if (x.equalsIgnoreCase("W")){
        int classmate;
        System.out.println("Enter which student to give the award to.");
        classmate = scan.nextInt();
        scan.nextLine();
        if (classmate > numPeople) {
            System.out.println("Not a classmate");
        }
        else{
            System.out.println("classmate " + classmate + " has the award.");
        }
    }
}
    
   
}
}