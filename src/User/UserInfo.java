package User;

public class UserInfo {
    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public double getCoin() {
        return coin;
    }

    public void setCoin(double coin) {
        this.coin = coin;
    }

    private String id;
    private String pw;
    private static double coin;


    public UserInfo(String id, String pw,double coin){
        this.id = id;
        this.pw = pw;
        this.coin = coin;
    }

    public void buy(double price){
        UserPage userPage = new UserPage();
        if(price > coin){
            System.out.println("잔액이 부족합니다. 현재 잔액 : " + coin);
        }
        else{
            coin -= price;
            System.out.println("구매에 성공하였습니다. 구매해주셔서 감사합니다!");
            userPage.currentBought.put(userPage.currentId, price);
            System.out.println("남은 코인 : "+coin);
        }
    }
    public void checkMyCoin(){
        System.out.println("현재 "+id+"님의 코인 : "+coin);
    }

}
