import java.util.Scanner;

/*
*@author ALLEN YAO TAHTS ME
*/
public class TemperatureDriver {
         public static void main(String[] args) {
         double inputTemperature = 0;
         Scanner keyboard = new Scanner(System.in);
         Temperature t1 = new Temperature();
         Temperature t2;
         String temperatureType = "";
         boolean moreTemperatures = true;
         boolean goodType = false; 
         boolean goodTemperature = false; //AHAHHAHAHAHAHAHAH THOU SHALT NOT
         
          while (moreTemperatures) {
            System.out.print("Enter a temperature type (C=Celsius, " +  "F = Fahrenheit, K = Kelvin, Q = Quit): ");
            temperatureType = keyboard.next();
            goodType = false;
            while ( ! goodType)  {
                if (temperatureType.equalsIgnoreCase("Q") ||
                 temperatureType.equalsIgnoreCase("C") ||
                 temperatureType.equalsIgnoreCase("F") ||
                 temperatureType.equalsIgnoreCase("K")) {
                    goodType = true;
                }
                else {
                    System.out.println("Invalid temperature type!!!!! It must be C,F,K,Q. PLEASE ENTER THE RIGHT TEMPERATURE!!!!!!");
                    temperatureType = keyboard.next();
               }
            }
            if (temperatureType.equalsIgnoreCase("Q")) { 
                moreTemperatures = false;
                System.out.println("\nProgram ended.");
            }
            else {
                 goodTemperature = false;
                 do {
                     System.out.println(" Enter a temperature");
                   
                     if (keyboard.hasNextDouble()) {
                         inputTemperature = keyboard.nextDouble();
                         if ((temperatureType.equalsIgnoreCase("C") && inputTemperature >= -273.15) ||
                             (temperatureType.equalsIgnoreCase("F") && inputTemperature >= -459.67) ||
                             (temperatureType.equalsIgnoreCase("K") && inputTemperature >= 0))
                             goodTemperature = true;
                         else {
                             System.out.println("DIS IS AN INVALID TEMPERATURE!!!!!!!!!! IT MUST BE GRATER THAT AVSOLUTE ZERO HOW DARE YOU");
                         }
                    
                     }
                     catch (InputMismatchException e)  {
                         System.out.println("IT MUST BE ANUMERIC VALUE");
                         keyboard.next();
                     }
                  }while (! goodTemperature);
            
                t1 = new Temperature();
                if (temperatureType.equals ("F")) {
                     System.out.println(" YOU HAVE ENTERED  " + inputTemperature + " degrees FAHRENHEIT MWAAHAHAHAHA");
                 t1.setDegreesFahrenheit(inputTemperature);
                 System.out.println("WHICH, IN CELSIUS SPEAK IS   " + t1.getDegreesCelsius() + "degrees celsius");
                 System.out.println("AND IN THE KELVIN LANGUAGE IT IS    " + t1.getDegreesKelvin() + "degrees Kelvin");
                }
                 else if (temperatureType.equals ("C")) {
                     System.out.println(" YOU HAVE ENTERED  " + inputTemperature + " degrees Celsius MWAAHAHAHAHA");
                 t1.setDegreesCelsius(inputTemperature);
                 System.out.println("WHICH, IN Fahrenheit SPEAK IS   " + t1.getDegreesFahrenheit() + "degrees fahrenheit");
                 System.out.println("AND IN THE KELVIN LANGUAGE IT IS    " + t1.getDegreesKelvin() + "degrees Kelvin");
                }
                else if (temperatureType.equals ("K")) {
                     System.out.println(" YOU HAVE ENTERED  " + inputTemperature + " degrees Kelvin MWAAHAHAHAHA");
                 t1.setDegreesKelvin(inputTemperature);
                 System.out.println("WHICH, IN CELSIUS SPEAK IS   " + t1.getDegreesCelsius() + "degrees celsius");
                 System.out.println("AND IN THE Fahrenheit LANGUAGE IT IS    " + t1.getDegreesFahrenheit() + "degrees Fahrenheit");
                }
                else {
                    System.out.println("You entered a wrong temperature: " + temperatureType);
                    System.out.println("It must be \"C\", \"F\", or \"K\".  HOW DARE YOU TRY TO PUT SOMETHING THAT IS NOT K, F, OR C");
                }
            }
        } 
    }
}
