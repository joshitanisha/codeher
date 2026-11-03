import java.util.Scanner;
public class Fibonacci {
    // recursive
    static int fibonacciRecursive(int n){
        if (n <= 1){
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    //nonrecursive
    static void fibonacciIterative(int n) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++){
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter NO OF TERMS: ");
        int n = sc.nextInt();
        if ( n < 0){
            System.out.println(" NO OF TERMS CANNOT BE NEGATIVE");
            sc.close();
            return;
        }
        System.out.println("\nFIBONACCI USING RECURSION: ");
        for (int i = 0; i < n; i++){
            System.out.print(fibonacciRecursive(i) + " ");

                }
                System.out.println("\n\nFibonacci using iteration:");

        fibonacciIterative(n);

        sc.close();
    }
}