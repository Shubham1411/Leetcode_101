/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future
to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestTimeBuySellStock {

    public static int maxProfit(int[] prices) {

        //Let price[0] be buy price and sell price. Profit=0
        int buy = prices[0], sell = prices[0], profit = 0;

        for (int i = 0; i < prices.length; i++) {

            //If price[i] is less than buy then buy=price[i] and make sell=0
            if (prices[i] < buy) {
                buy = prices[i];
                sell = 0;
            }

            //If price[i] is more than sell then sell=price[i]
            if (prices[i] > sell)
                sell = prices[i];

            //If sell-buy > profit assign profit=sell-buy
            if ((sell - buy) > profit)
                profit = sell - buy;

        }

        if (profit > 0)
            return profit;
        else
            return 0;

    }

    public static void main(String[] args) {

        int prices[] = {7, 1, 5, 3, 6, 4};

        System.out.println("Maximized Profit : " + maxProfit(prices));
    }
}
