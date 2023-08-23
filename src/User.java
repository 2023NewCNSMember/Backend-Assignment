public class User {

    private String userName;
    private String passWd;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWd() {
        return passWd;
    }

    public void setPassWd(String passWd) {
        this.passWd = passWd;
    }

    public void userLogin(String name, String pass){
        if(userName.equals(name)|| passWd.equals(pass)){
            System.out.println("로그인 성공, 환영합니다 ! " + userName + "님!");
            ui();
        }
    }
    public void userSignUp(String userName, String passWd){
        this.userName = userName;
        this.passWd =  passWd;
    }

    public void ui(){

    }
}
