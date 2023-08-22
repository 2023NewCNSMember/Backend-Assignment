import java.util.ArrayList;

public class Market {
    private ArrayList arr = new ArrayList();

    public void addItem(String item){
        this.arr.add(item);
        System.out.println(this.arr);
    }
}
