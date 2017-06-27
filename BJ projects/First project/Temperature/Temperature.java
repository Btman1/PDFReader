
 
 public class Temperature{
     
    private double degreesFahrenheit; // Fahrenheit temperture
    
    
    public double getDegreesCelsius() {
    return (degreesFahrenheit - 32) * 5 / 9;
    }
    
    public double getDegreesKelvin() {        
    return (degreesFahrenheit - 32) * 5 / 9 + 273.15;
    }
    
    public double getDegreesFahrenheit() {
    return degreesFahrenheit;
    }
    public void setDegreesFahrenheit(double degrees) {
       degreesFahrenheit = degrees;
    }
     public void setDegreesKelvin(double degrees) {
       this.degreesFahrenheit = (degrees - 32) * 5 / 9 + 273.15;
    }
     public void setDegreesCelsius(double degrees) {
         this.degreesFahrenheit = (degrees - 32) * 5 / 9;
    }
    
}