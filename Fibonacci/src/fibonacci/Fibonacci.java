
package fibonacci;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci:");
        Fibonacci(1,1,0);
    }

    private static int Fibonacci(int step, int lower, int higher){
        if (step > 45){
            return higher;
        }
        System.out.println(higher +"("+step+")");
        return Fibonacci(step +1,higher, higher+lower);
    }
}
