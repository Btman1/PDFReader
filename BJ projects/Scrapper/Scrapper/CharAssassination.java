/* Character Assasination JAVA
 * 9 / 22 / 16
 * Allen
 * Description:
 * Program that uses primitive data type short.
 *  - short value = 32 works
 *  - short value = 356 works
 *  - short value = 35000 fails
 *  - int value = 35000 works
 */

class CharAssassination
{
  public static void main ( String[] args )
  {
    char ch = 'A' ;
    char ab = 'L' ;
    char ac = 'E' ;
    char ad = 'N' ;
    System.out.println("My name is " +  ch + ab + ab + ac + ad);
  }
}