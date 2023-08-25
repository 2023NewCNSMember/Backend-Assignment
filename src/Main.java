import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GUI gui = new GUI();
        User user = new User();
        Market market = new Market();

        while (true) {
            gui.roleGUI();
            int role = sc.nextInt();

            switch (role) {
                case 1: // 어드민 페이지
                    while (true) {
                        gui.adminGUI();
                        int adminNumber = sc.nextInt();

                        switch (adminNumber) {
                            case 1: // 마켓의 물건 추가
                                System.out.println("추가할 물건을 입력하세요 : ");
                                String item = sc.next();
                                System.out.println("추가할 물건의 가격을 입력하세요 : ");
                                int price = sc.nextInt();
                                market.addItem(item, price);
                                break;

                            case 2: // 사용자 초기 코인 설정
                                System.out.println("설정할 코인의 값을 입력하세요 : ");
                                int coin = sc.nextInt();
                                user.setCoin(coin);
                                break;

                            case 3: // 마켓에서 사용자가 주문한 물건 목록
                                market.showList();
                                break;

                            case 4: // 권한 설정
                                break;

                            case 5: // 시스템 종료
                                System.exit(1);
                                break;

                            default:
                                System.out.println("번호를 잘못 입력하셨습니다.");
                                break;
                        }

                        if (adminNumber == 4) {
                            break;
                        }
                    }
                    break;

                case 2: // 유저 페이지
                    while (true) {
                        gui.martGUI(); // GUI 세팅
                        int userNumber = sc.nextInt();

                        switch (userNumber) {
                            case 1: // 사용자 물건 구매
                                market.showItem();
                                String item = sc.next();
                                user.setCoin(user.getCoin() - market.buyItem(item));
                                System.out.println("구매후 코인은 " + user.getCoin() + "원 입니다.");
                                break;

                            case 2: // 코인 조회
                                System.out.println("보유중인 코인은 " + user.getCoin() + "원 입니다.");
                                break;

                            case 3: // 권한 설정
                                break;

                            case 4: // 시스템 종료
                                System.exit(1);
                                break;

                            default:
                                System.out.println("번호를 잘못 입력하셨습니다.");
                                break;
                        }

                        if (userNumber == 3) {
                            break;
                        }
                    }
                    break;

                default:
                    System.out.println("번호를 잘못 입력하셨습니다.");
                    break;
            }
        }
    }
}
