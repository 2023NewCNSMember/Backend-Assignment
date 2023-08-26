package Main;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import Admin.AdminPage;
import User.UserInfo;
import User.UserPage;

public class Main {
    public static void main(String[] args) {
        
        Main main = new Main();
        UserPage userPage = new UserPage();
        AdminPage adminPage = new AdminPage();
        System.out.println("========================");
        System.out.println("대소코인 마켓입니다.");
        while (true){
            System.out.println("1을 입력하면 어드민, 2를 입력하면 유저 페이지로 이동합니다.");
            String input = main.inputHell();
            if(input.equals("1")){
                adminPage.adminBasicPage();
            }
            else if (input.equals("2")) {
                userPage.userBasicPage();

            }
            else if(input.equals("quit")){
                break;
            }
        }
        
        System.out.println("이용해주셔서 감사합니다. 다음에 또 와줘잉~");
    }

    public String inputHell(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("입력값 : ");
            String opInput = scanner.next();
            if(opInput.equals("1")||opInput.equals("2")){
                return opInput;
            }
            else if(opInput.equals("quit")){
                return opInput;
            }
            else{
                System.out.println("옳지 않은 입력 값입니다.");
            }
        }
    }
}
