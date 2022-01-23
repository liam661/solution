package jan.w3;

import java.util.*;

/**
 * @Description 股票价格
 *
 * @Author liam661
 * @Date 2022/1/23 11:44
 **/
public class StockPrice {
    private Map priceMap = new HashMap();
    private int maxPrice;
    private int minPrice;
    private int maxTimestamp;

    public StockPrice() {

    }
    public void update(int timestamp, int price) {
        if(priceMap.isEmpty()){
            maxPrice = price;
            minPrice = price;
            maxTimestamp = timestamp;
        }else {
            if(price > maxPrice){
                maxPrice = price;
            }
            if(price < minPrice){
                minPrice = price;
            }
            if(timestamp > maxTimestamp){
                maxTimestamp = timestamp;
            }
        }
        priceMap.put(timestamp,price);
    }

    public int current() {
       return (int) priceMap.get(maxTimestamp);
    }

    public int maximum() {
        List<Map.Entry<Integer, Integer>> priceList = new ArrayList<>(priceMap.entrySet());
        Collections.sort(priceList, (o1, o2) -> (o1.getValue() - o2.getValue()));
        return priceList.get(priceList.size() - 1).getValue();
    }

    public int minimum() {
        List<Map.Entry<Integer, Integer>> priceList = new ArrayList<>(priceMap.entrySet());
        Collections.sort(priceList, (o1, o2) -> (o1.getValue() - o2.getValue()));
        return priceList.get(0).getValue();
    }

    public static void main(String [] args){
        StockPrice obj = new StockPrice();
        obj.update(1,2);
        obj.update(3,4);
        obj.update(5,3);
        int param_2 = obj.current();
        int param_3 = obj.maximum();
        int param_4 = obj.minimum();
        System.out.println("current: "+param_2);
        System.out.println("max: "+param_3);
        System.out.println("min: "+param_4);
    }
}
