import java.util.Scanner;
public class KnapsackDP {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("ENTER NO OF ITEMS:");
        int n = sc.nextInt();

        int[] weights = new int[n];
        int[] profit = new int[n];
        System.out.println("ENTER WEIGHTS OF ITEMS:");
        for (int i = 0; i < n; i++){
            weights[i] = sc.nextInt();
        }
        System.out.println("ENTER PROFITS OF ITEMS:");
        for (int i = 0; i < n; i++){
            profit[i] = sc.nextInt();
        }
        System.out.print("ENTER CAPACITY OF KNAPSACK:");
        int capacity = sc.nextInt();

        int[][] dp = new int[n + 1][capacity + 1];
        for (int i = 1; i <=n; i++){
            for (int w = 1; w <= capacity; w++){
                if (weights[i - 1] <= w){
                    dp[i][w] = Math.max(dp[i - 1][w], profit[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        System.out.println("MAXIMUM PROFIT:" + dp[n][capacity]);
                System.out.print("Selected Items: ");

        int w = capacity;

        for (int i = n; i > 0; i--) {

            if (dp[i][w] != dp[i - 1][w]) {

                System.out.print(i + " ");

                w = w - weights[i - 1];

            }

        }

        System.out.println();

        sc.close();

    }

}
    