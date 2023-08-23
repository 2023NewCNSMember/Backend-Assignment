import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GUI gui = new GUI();
        //사용자 객체를 생성합니다.
        User user = new User();
        //마켓 객체를 생성합니다.
        Market market = new Market();
        while (true) {
            gui.roleGUI();
            int role = sc.nextInt();

            // 어드민 페이지
            if (role == 1) {
                while (true) {
                    gui.adminGUI();
                    int adminNumber = sc.nextInt();

                    //마켓의 물건들을 추가 합니다.
                    if (adminNumber == 1) {
                        System.out.println("추가할 물건을 입력하세요 : ");
                        String item = sc.next();
                        System.out.println("추가할 물건의 가격을 입력하세요 : ");
                        int price = sc.nextInt();
                        market.addItem(item, price);
                    }
                    //사용자의 초기 코인을 설정 합니다.
                    else if (adminNumber == 2) {
                        System.out.println("설정할 코인의 값을 입력하세요 : ");
                        int coin = sc.nextInt();
                        user.setCoin(coin);
                    }
                    //마켓에서 사용자가 주문한 물건들의 목록을 불러 옵니다.
                    else if (adminNumber == 3) {
                        market.showList();
                    }
                    // 권한 설정
                    else if (adminNumber == 4) {
                        break;
                    }
                    // 시스템 종료
                    else if (adminNumber == 5) {
                        System.exit(1);
                    } else {
                        System.out.println("번호를 잘못 입력하셨습니다.");
                    }

                }
            }


        //사용자가 물건을 구매합니다.

        //구매후 사용자의 코인 잔액을 출력합니다.

        //마켓에서 사용자가 주문한 물건들의 목록을 불러 옵니다.
    }
}
