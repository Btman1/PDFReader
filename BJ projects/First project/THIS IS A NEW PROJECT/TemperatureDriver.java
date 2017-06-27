import java.util.Scanner;
import java.util.InputMismatchException;
/**
 * TemperatureDriver runs and tests the Temperature class.
 * 
 * @author MEEEE
 * @version 4.0
 */
public class TemperatureDriver {
    /**
     * main() reads a temperature type and value, then 
     * converts it to the other two temperature scales.
     */
    public static void main(String[] args) {
        double inputTemperature = 0.0;
        Scanner keyInput = new Scanner(System.in); 
        Temperature t1;
        String temperatureType = "";
        boolean moreTemperatures = true; // another temperature?

        while (moreTemperatures) {
            System.out.print("Enter a temperature type (C=Celsius, " +
                "F=Fahrenheit, K=Kelvin, Q=Quit): ");
            temperatureType = keyInput.next();
            if (temperatureType.equalsIgnoreCase("Q")) { // quit
                moreTemperatures = false;
                System.out.println("\nProgram ended.");
            }
            else {
                System.out.print("Enter a temperature: ");
                try {
                    inputTemperature = keyInput.nextDouble();
                }
                catch (InputMismatchException e) {
                    System.err.println(e + ": You entered an invalid temperature!" +
                        "\nIt must be a numeric value.");
                    System.exit(1);
                }

                try {
                    t1 = new Temperature(temperatureType, inputTemperature);
                    if (temperatureType.equalsIgnoreCase("F")) {
                        System.out.println("You entered " + inputTemperature + 
                            " degrees Fahrenheit");
                        System.out.println("which is " + t1.getDegreesCelsius() + 
                            " degrees Celsius"); 
                        System.out.println("and " + t1.getDegreesKelvin() + 
                            " degrees Kelvin.");
                    }
                    else if (temperatureType.equalsIgnoreCase("C")) {
                        System.out.println("You entered " + inputTemperature + 
                            " degrees Celsius");
                        System.out.println("which is " + t1.getDegreesFahrenheit() + 
                            " degrees Fahrenheit"); 
                        System.out.println("and " + t1.getDegreesKelvin() + 
                            " degrees Kelvin.");
                    }
                    else if (temperatureType.equalsIgnoreCase("K")) {
                        System.out.println("You entered " + inputTemperature + 
                            " degrees Kelvin");
                        System.out.println("which is " + t1.getDegreesCelsius() + 
                            " degrees Celsius"); 
                        System.out.println("and " + t1.getDegreesFahrenheit() + 
                            " degrees Fahrenheit.");
                    }
                }
                catch (InvalidTemperatureTypeException e) {
                    System.err.println(e);
                    System.exit(1);
                }
                catch (InvalidTemperatureException e) {
                    System.err.println(e);
                    System.exit(1);
                }
            }
        }
    }
} 