class Example
{  
  public static void main ( String[] args )  
  {
    long   hoursWorked = 400;    
    double payRate     = 1485.0, taxRate = 0.99;    
    System.out.println("Hours Worked: " + hoursWorked );
    System.out.println("pay Amount  : " + (hoursWorked * payRate) );
    System.out.println("tax Amount  : " + (hoursWorked * payRate * taxRate) );
  }
}
