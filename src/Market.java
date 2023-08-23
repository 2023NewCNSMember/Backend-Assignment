import java.util.ArrayList;
import java.util.List;

public class Market {
    private List<String> sangppooms = new ArrayList<>();
    public List<String> addSangpoom(String sangpoom){
        sangppooms.add(sangpoom);
        return sangppooms;
    }
}
