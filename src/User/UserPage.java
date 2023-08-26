package User;

import Admin.AdminInfo;
import Admin.AdminPage;
import Main.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static Admin.AdminPage.*;

public class UserPage {
    AdminPage admin = new AdminPage();

    public Map<String,Double> currentBought = new HashMap<>();

    Map<String, Double> canBuy = new HashMap<>();

    Main main = new Main();

    public List<UserInfo> userInfos = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    int count = 0;

    String currentId;

    public UserInfo getUserInfo(String id){
        for(UserInfo info : userInfos){
            if(info.getId().equals(id)){
                return info;
            }
        }
        return null;
    }

    public boolean isLoggedIn(String id, String pw){
        UserInfo info = getUserInfo(id);
        return info != null && info.getPw().equals(pw);
    }

    public void userBasicPage(){
        System.out.println("========================");
        System.out.println("유저 기본 페이지 입니다.");
        System.out.println("1 입력 시 회원가입, 2 입력 시 로그인 페이지로 이동합니다.");
        String opInput = main.inputHell();
        if(opInput.equals("1")){
            signUp();
        }
        else if(opInput.equals("2")){
            signIn();
        }
    }

    public void signIn(){

        System.out.println("========================");
        System.out.println("로그인 페이지입니다.");

        while(true){
            System.out.println("아이디와 비밀번호를 입력해주세요");
            System.out.print("아이디 : ");
            String id = scanner.nextLine();
            System.out.print("비밀번호 : ");
            String pw = scanner.nextLine();

            if(isLoggedIn(id,pw)){
                currentId = id;
                System.out.println("로그인 성공, 환영합니다! "+id+"님!");
                userUI();
                break;
            }

            else if (id.equals("quit")||pw.equals("quit")) {
                break;
            }

            else{
                count += 1;
                if(count == 3){
                    System.out.println("비정상적인 접근, 프로그램을 종료합니다.");
                    System.exit(0);
                }
                else{
                    System.out.println("옳지 않은 아이디 또는 비밀번호입니다. 현재 " + count + "번 실패");
                }
            }
        }
        userBasicPage();
    }

    public void signUp(){
        System.out.println("========================");
        System.out.println("회원가입 페이지입니다.");

        while(true){

            System.out.println("아이디와 비밀번호를 입력해주세요");
            System.out.print("아이디 : ");
            String id = scanner.nextLine();
            System.out.print("비밀번호 : ");
            String pw = scanner.nextLine();

            if(userInfos.contains(id)){
                System.out.println("존재하는 아이디입니다.");
            }

            else if(id.equals("")||pw.equals("")){
                System.out.println("공백으로 된 아이디나 비밀번호는 사용 하실 수 없습니다.");
            }

            else if(id.equals("quit")||pw.equals("quit")){
                System.out.println("유저 페이지로 이동합니다");
                break;
            }

            else{
                userInfos.add(new UserInfo(id, pw,50000));
                System.out.println("축하드립니다. 회원가입 되셨습니다!");
                break;
            }
            break;
        }
        userBasicPage();
    }

    public void userUI(){
        System.out.println("========================");
        System.out.println("유저 메인 페이지입니다.");
        while(true){
            System.out.println("1을 입력 시 상품 구매\n2를 입력 시 상품 구매 확인\n3을 입력 시 나의 대소코인 확인\n'quit'을 입력 시 이전 페이지로 이동합니다.");
            System.out.print("명령어를 입력해주세요 : ");
            String op = scanner.nextLine();

            if(op.equals("quit")){
                break;
            }
            else{
                if(op.equals("1")){
                    //상품 구매
                    buy();
                }
                else if(op.equals("2")){
                    //구매 정보
                    checkMyProducts();

                }
                else if(op.equals("3")){
                    //코인 확인
                    checkMyCoin();
                }
                else{
                    System.out.println("옳지 않은 명령어입니다.");
                }
            }
        }
        userBasicPage();
    }

    public void buy(){
        System.out.println("========================");
        System.out.println("상품 구매 페이지입니다.");
        loadProductsFromFile();
        System.out.println("현재 출고 된 상품 : ");
        for(String name : products.keySet()){
            System.out.println("상품 : "+name + ", " + "가격 : " + admin.products.get(name)+", " + "판매여부 : " + admin.isBought.get(name));
        }
        while (true){
            System.out.print("구매하고 싶은 상품을 입력해주세요 : ");
            String opInput = scanner.nextLine();
            if(opInput.equals("quit")){
                break;
            }
            else{
                if (!products.containsKey(opInput)){
                    System.out.println("이미 팔린 상품이거나 존재하지 않는 상품입니다.");
                }
                else{
                        UserInfo info = userInfos.get(0);
                        info.buy(products.get(opInput));
                        isBought.put(opInput,true);
                        saveProductstoFile();
                    }
                }
            }
        }

    private static void loadProductsFromFile() {
        AdminPage adminPage = new AdminPage();
        try (BufferedReader reader = new BufferedReader(new FileReader(adminPage.PRODUCTS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String productName = parts[0];
                    double productPrice = Double.parseDouble(parts[1]);
                    products.put(productName, productPrice);
                    isBought.put(productName, false);
                }
            }
        } catch (IOException e) {
            // 파일이 없거나 읽을 수 없는 경우
        }
    }
    public void checkMyCoin(){
        UserInfo info = userInfos.get(0);
        info.checkMyCoin();
    }
    public void checkMyProducts(){
        System.out.println("현재 " +currentId+"님이 구매하신 상품 : ");
        for(String name : currentBought.keySet()){
            System.out.println("상품 : " + name + ", " + "가격 : "+currentBought.get(name));
        }
    }

}
