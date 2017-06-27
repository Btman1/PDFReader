
/**
 * Write a description of class TypeWriter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Color {
    private String textToDisplay; // the text to be displayed
    

    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class TypeWriter
     */
    
    
    public void setTextToDisplay(String inputText) {
        textToDisplay = inputText;
    }  
    
    public String getTextToDisplay() {
        return textToDisplay;
    }
    
    public void display() {
        System.out.println(textToDisplay);
    }
     
    public Color() {
        textToDisplay = "";
    }

    public Color(String inputText) {
       textToDisplay = inputText;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
//HELLO ITS ME
//IVE BEEN WONDERING IF AFTER ALL THESE YEARS
//
