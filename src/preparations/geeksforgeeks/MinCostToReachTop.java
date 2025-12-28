package preparations.geeksforgeeks;

public class MinCostToReachTop {
    public static void main(String[] args) {
       int cost[]={12,15,20};
       int N = cost.length;
        System.out.println(minCostClimbingStairs(cost,N));
    }

    static int minCostClimbingStairs(int cost[], int N)
    {
        int dp1 = 0, dp2 = 0;

        // traverse till N-th stair
        for (int i = 0; i < N; i++)
        {
            int dp0 = cost[i] +
                    Math.min(dp1, dp2);

            // update the last
            // two stairs value
            dp2 = dp1;
            dp1 = dp0;
        }
        return Math.min(dp1, dp2);
    }


//    static int minCostClimbingStairs(int[] cost , int N) {
//        //Write your code here
//        int first = minCostClimbingStairs(cost,N,0);
//        int second = minCostClimbingStairs(cost,N,1);
//        return Math.min(first,second);
//    }
//
//    static int minCostClimbingStairs(int[] cost , int N,int current) {
//        //Write your code here
//
//        if(current>=N){
//            return 0;
//        }
//
//        int costByOne = minCostClimbingStairs(cost,N,current+1);
//        int costByTwo = minCostClimbingStairs(cost,N,current+2);
//
//        return Math.min(costByOne,costByTwo)+cost[current];
//    }
}
