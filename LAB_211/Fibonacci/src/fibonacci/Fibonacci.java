
package fibonacci;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println("The 45 sequence fibonacci:");
        for(int i=1;i<45;i++){
            System.out.println(Fibonacci(i) + " ");
        }
    }
    
    private static int Fibonacci(int n){
        if(n<0){
            return -1;
        }else if(n<=1){
            return n;
        }else{
            return Fibonacci(n-1) + Fibonacci(n-2);
        }
    }
    
}
