
    public class ColorDriver {
        public static void main(String[] args) {
        Color tw1;
        tw1 = new Color();
        tw1.setTextToDisplay("This line is from my first Java object!");
        tw1.display();
        Color tw2 = new Color("And this line is from my second object.");
        System.out.println(tw2.getTextToDisplay());
        }
    }