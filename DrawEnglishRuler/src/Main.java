/**
 * Chapter 3. Recursion
 */
public class Main {
    public static void main(String[] args) {
        drawRuler(1,5);
    }

    public static void drawRuler(int nInches,int inchLength){
        drawOneTick(inchLength,0);
        for (int i=1;i<=nInches;i++){
            drawTicks(inchLength-1);
            drawOneTick(inchLength,i);
        }
    }
    public static void drawTicks(int tickLength){
        if(tickLength > 0){
            drawOneTick(tickLength-1);
            drawOneTick(tickLength);
            drawOneTick(tickLength-1);
        }
    }
    public static void drawOneTick(int length){
        drawOneTick(length,-1);
    }
    public static void drawOneTick(int length,int label){
        for(int i=0;i<length;i++){
            System.out.print("-");
        }
        if(label>= 0 ) System.out.print(" " + label);
        System.out.print("\n");
    }
}
