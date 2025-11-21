class Solution {
    public int maxProfit(int[] prices) {
        int buy_price = prices[0];
        int profit = 0;
        int maxProfit = 0;
        for(int price : prices){
            if(price < buy_price){
                buy_price = price;
            }
            else{
                profit = price - buy_price;
                if(profit > maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
    public int maxProfitBruteForce(int[] prices){
        int maxProfit = Integer.MIN_VALUE;
        int currProfit = maxProfit;
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j<prices.length; j++){
                if(prices[j]-prices[i] > maxProfit){
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        if(maxProfit > 0) return maxProfit;
        return 0;
    }
}