import java.util.Objects;
import java.util.Scanner;

public class MainSystem {
    Scanner sc = new Scanner(System.in);
    public void system(){
        System.out.println("로그인 - 1 / 회원가입  - 2");
        String ans = sc.nextLine();
        if (Objects.equals(ans,"1")) {
            SignIn.signIn();
        }
        else if (Objects.equals(ans,"2")) {
            SignUp.signUp();
        }
    }



}
