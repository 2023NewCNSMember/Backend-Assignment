package Admin;

import Main.Main;

import java.io.*;
import java.util.*;

public class AdminPage {
    public static final String PRODUCTS_FILE = "products.txt";
    public static Map<String, Boolean> isBought = new HashMap<>();
    public static final Map<String, Double> products = new HashMap<>();

    List<AdminInfo> adminInfos = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
    int count = 0;
    private final double securityKey = 85078677;

    Main main = new Main();

    public AdminInfo getAdminInfo(String id){
        for(AdminInfo info : adminInfos){
            if(info.getId().equals(id)){
                return info;
            }
        }
        return null;
    }

    public boolean isLoggedIn(String id, String pw){
        AdminInfo info = getAdminInfo(id);
        return info != null && info.getPw().equals(pw);
    }

    public void adminBasicPage(){
        System.out.println("========================");
        System.out.println("어드민 기본 페이지 입니다.");
        System.out.println("1 입력 시 회원가입, 2 입력 시 로그인 페이지로 이동합니다.");
        String opInput = main.inputHell();
        if(opInput.equals("1")){
            signUp();
        }
        else if(opInput.equals("2")){
            signIn();
        }
        else{
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
                System.out.println("로그인 성공, 환영합니다! "+id+"님!");
                adminUI();
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
        adminBasicPage();
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

            if(adminInfos.contains(id)){
                System.out.println("존재하는 아이디입니다.");
            }

            else if(id.equals("")||pw.equals("")){
                System.out.println("공백으로 된 아이디나 비밀번호는 사용 하실 수 없습니다.");
            }

            else if(id.equals("quit")||pw.equals("quit")){
                System.out.println("어드민 페이지로 이동합니다");
                break;
            }

            else{
                while (true) {
                    System.out.print("사전에 제공된 인증키를 입력해주세요 : ");
                    double inputSecurity = scanner.nextDouble();
                    scanner.nextLine();
                    if (inputSecurity == securityKey) {
                        adminInfos.add(new AdminInfo(id, pw));
                        System.out.println("축하드립니다. 회원가입 되셨습니다!");
                        break;
                    } else {
                        System.out.println("옳지 않은 인증키 입니다.");
                    }
                }
            }
            break;
        }
        adminBasicPage();
    }

    public void adminUI(){
        System.out.println("========================");
        loadProductsFromFile();
        System.out.println("어드민 메인 페이지입니다.");

        while(true){
            System.out.println("1을 입력 시 상품 추가\n2를 입력 시 상품 정보 수정\n3을 입력 시 상품 조회\n4를 입력 시 상품 삭제\n'quit'을 입력 시 이전 페이지로 이동합니다.");
            System.out.print("명령어를 입력해주세요 : ");
            String op = scanner.nextLine();

            if(op.equals("quit")){
                break;
            }
            else{
                if(op.equals("1")){
                    //상품 추가
                    putProducts();
                }
                else if(op.equals("2")){
                    //정보 수정
                    balance();
                }
                else if(op.equals("3")){
                    //상품 조회
                    checkProducts();
                }
                else if(op.equals("4")){
                    //상품 삭제
                    delete();
                }
                else{
                    System.out.println("옳지 않은 명령어입니다.");
                }
            }
        }
        saveProductstoFile();
        adminBasicPage();
    }

    public void putProducts(){
        System.out.println("========================");
        System.out.println("상품 추가 페이지입니다.");
        while (true){
            System.out.println("상품 이름과 가격을 입력해주세요");
            System.out.print("이름 : ");
            String inputProduct = scanner.nextLine();
            System.out.print("가격 : ");
            double inputPrice = scanner.nextDouble();
            scanner.nextLine();

            if(inputProduct.equals("quit")){
                break;
            }
            else{
                if(products.containsKey(inputProduct)){
                    System.out.println("이미 존재하는 상품입니다.");
                }
                else{
                    products.put(inputProduct,inputPrice);
                    isBought.put(inputProduct,false);



                    System.out.println("성공적으로 추가하였습니다.");
                }
            }
        }
    }
    public void balance(){
        System.out.println("========================");
        System.out.println("상품 조정 페이지입니다.");
        while (true) {
            System.out.print("조정 하실 상품 이름을 입력해주세요 : ");
            String inputProduct = scanner.nextLine();
            if(inputProduct.equals("quit")){
                break;
            }
            else{
                if(!products.containsKey(inputProduct)){
                    System.out.println("존재하지 않는 상품입니다.");
                }
                else{
                    System.out.println("변경 이름과 가격을 입력해주세요 : ");
                    System.out.print("변경 이름 : ");
                    String rename= scanner.nextLine();
                    System.out.print("가격 : ");
                    double reprice = scanner.nextDouble();
                    scanner.nextLine();
                    products.remove(inputProduct);
                    products.put(rename,reprice);

                    System.out.println("성공적으로 변경하였습니다.");
                }
            }
        }
    }

    public void checkProducts(){
        System.out.println("========================");
        System.out.println("현재 출고 된 상품 : ");
        for(String name : products.keySet()){
            System.out.println("상품 : "+name + ", " + "가격 : " + products.get(name)+", " + "판매여부 : " + isBought.get(name));
        }
        while (true){
            System.out.print("물건 추가는 1, 물건 조정은 2, 물건 삭제는 3, 나가기는 'quit'을 입력해주세요 : ");
            String opInput = scanner.nextLine();
            if(opInput.equals("quit")){
                break;
            }
            else{
                if(opInput.equals("1")){
                    putProducts();
                }
                else if(opInput.equals("2")){
                    balance();
                }
                else if(opInput.equals("3")){
                    delete();
                }
                else{
                    System.out.println("옳지 않은 입력값입니다.");
                }
            }
        }
    }

    public void delete(){
        System.out.println("========================");
        System.out.println("상품 삭제 페이지입니다.");
        while (true){
            System.out.print("삭제할 상품 이름을 입력하시거나 'quit'을 입력해주세요 : ");
            String opInput= scanner.nextLine();
            if(opInput.equals("quit")){
                break;
            }
            else{
                if(!products.containsKey(opInput)){
                    System.out.println("존재하지 않는 상품입니다.");
                }
                else{
                    products.remove(opInput);
                    isBought.remove(opInput);
                    saveProductstoFile();
                    System.out.println("성공적으로 삭제되었습니다.");
                }
            }
        }
    }

    public static void saveProductstoFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PRODUCTS_FILE, false))) {
            for (String product : products.keySet()) {
                writer.println(product + "," + products.get(product));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadProductsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PRODUCTS_FILE))) {
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

}
