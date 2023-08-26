package Admin;

public class AdminInfo {
    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    private String id;
    private String pw;

    public AdminInfo(String id, String pw){
        this.id = id;
        this.pw = pw;
    }
}
