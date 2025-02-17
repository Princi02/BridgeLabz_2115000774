public class FibonacciComparison {
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] testCases = {10, 30, 50};
        
        for (int n : testCases) {
            System.out.println("Computing Fibonacci for N = " + n);
            
            long start = System.currentTimeMillis();
            try {
                System.out.println("Recursive Result: " + fibonacciRecursive(n));
            } catch (StackOverflowError e) {
                System.out.println("Recursive approach is infeasible for N = " + n);
            }
            long end = System.currentTimeMillis();
            System.out.println("Recursive Time: " + (end - start) + " ms");
            
            start = System.currentTimeMillis();
            System.out.println("Iterative Result: " + fibonacciIterative(n));
            end = System.currentTimeMillis();
            System.out.println("Iterative Time: " + (end - start) + " ms");
            
            System.out.println();
        }
    }
}
