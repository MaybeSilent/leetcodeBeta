class Solution {
    public int maxProfit(int[] prices) {
        int firstBuy = Integer.MIN_VALUE;
        int secondBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondSell = 0;
        for(int price : prices){
            if(firstBuy < -1*price) firstBuy = -1*price;
            if(firstSell < price + firstBuy) firstSell = price + firstBuy;
            if(secondBuy < firstSell - price) secondBuy = firstSell - price;
            if(secondSell < secondBuy + price) secondSell = secondBuy + price;
        }
        return secondSell;
    }
}