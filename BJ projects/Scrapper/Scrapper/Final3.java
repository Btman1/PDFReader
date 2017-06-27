public class Final3 {
    public static void main(String[] args) {
        int var[]=new int[4]; // enter the array here
        int i;
        int x = 4;//varable
        for(i = 0; i < 6; i++) { // forloop to do reversing
            System.out.println(var[x]); // reversing part 
            var[x] = var[x-1];
        }
    }
}