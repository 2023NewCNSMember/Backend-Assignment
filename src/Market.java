import java.util.ArrayList;

public class Market {
    HashMap<String, Integer> map = new HashMap<>();


    public void addItem(String item, int price){
        map.put(item,price);
    }
}
