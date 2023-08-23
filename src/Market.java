import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Market{
    private int itemPrice = 0;
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList list = new ArrayList();


    // ADMIN 아이템 저장 로직
    public void addItem(String item, int price){
        map.put(item,price);
    }

    // 저장된 상품 보여주는 로직
    public void showItem(){
        System.out.println("현재 등록된 상품 갯수 : " + map.size());
        List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort(String::compareTo);
        for (String key : keyList) {
            System.out.println("[ " + key + "의 가격은 " +  map.get(key) + "원 입니다. ]" );
        }
    }

    //아이템 검색 및 구매 로직
    public int buyItem(String item){
        String[] arr = new String[100];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String name = entry.getKey();
            if (name.contains(item)) {
                this.itemPrice=entry.getValue();
                list.add(entry.getKey());
            }
            else {
                System.out.println("잘못된 값을 입력하셨습니다.");
            }
        }
        return this.itemPrice;
    }
    // 구매한 물건 조회
    public void showList(){
        for (int i=0; i<list.size(); i++){
            System.out.println(i+1 + ". : " + list.get(i) + " 구매함.");
        }
    }


}
