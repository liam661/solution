package jan.w3;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description 股票价格学习
 * @Author liam661
 * @Date 2022/1/23 21:06
 **/
public class StockPrice2 {
    private Map<Integer,Integer> priceMap = new HashMap();
    private TreeMap<Integer, Integer> tm = new TreeMap<>();
    private int maxTimestamp;

    public StockPrice2() {
    }

    public void update(int timestamp, int price) {
        maxTimestamp = Math.max(maxTimestamp, timestamp);
        if(priceMap.containsKey(timestamp))
        {
            int old = priceMap.get(timestamp);
            int cnt = tm.get(old);
            if(cnt == 1){
                tm.remove(old);
            }else {
                tm.put(old, cnt - 1);
            }
        }
        priceMap.put(timestamp, price);
        tm.put(price,tm.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return priceMap.get(maxTimestamp);
    }

    public int maximum() {
        return tm.lastKey();
    }

    public int minimum() {
        return tm.firstKey();
    }

    public static void main(String [] args){
        StockPrice2 obj = new StockPrice2();
        obj.update(1,10);
        obj.update(2,5);
        obj.update(1,3);
        //obj.update(4,2);
        int param_2 = obj.current();
        int param_3 = obj.maximum();
        int param_4 = obj.minimum();
        System.out.println("current: "+param_2);
        System.out.println("max: "+param_3);
        System.out.println("min: "+param_4);
    }
}
