
class Solution {
    public int coinChange(int[] coins, int amount) {
        int [][] dp  = new int [coins.length+1][amount+1];
        int m= dp.length;
        int n= dp[0].length;
        
        
        for(int i=0 ;i < m ; i++){
            dp[i][0]= 0;
        }
        for(int i=1 ;i < n; i++){
            dp[0][i]=99999;
        }
        for(int i=1; i<m ; i++){
            for (int j=1 ; j< n ;  j++){
                if(j< coins[i-1]){
                    dp[i][j]= dp[i-1][j];
                } else{
                    dp[i][j]= Math.min(dp[i-1][j], 1+dp[i][j-coins[i-1]]);
                }
                
            }
        }
        return dp[m-1][n-1];
    }
}