/*
    Given an array prices where prices[i] represents the price of a stock on the i-th day,
    this method finds the maximum profit you can achieve by making at most one transaction.
    You must buy before you sell.

    Approach:
    - I keep track of the minimum price seen so far while iterating through the array.
    - For each price, I calculate the potential profit if sold on that day (price - minPrice).
    - I update maxProfit if the calculated profit is greater than the current maxProfit.
 */

class Solution {
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            int profit = price - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}