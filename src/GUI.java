public class GUI {


    public void roleGUI() {
        System.out.println("----- 권한 설정 -----");
        System.out.println("1. ADMIN");
        System.out.println("2. USER");
    }

    public void martGUI(){
        System.out.println("-----대소고 마켓-----");
        System.out.println("1. 물건 구매");
        System.out.println("2. 코인 잔액 출력");
        System.out.println("3. 물건 구매");
        System.out.println("4. 권한 설정");
        System.out.println("4. 나가기 (종료)");
    }

    public void adminGUI(){
        System.out.println("-----어드민 페이지-----");
        System.out.println("1. 물건 추가");
        System.out.println("2. 코인 설정");
        System.out.println("3. 권한 설정");
        System.out.println("4. 나가기 (종료)");
    }
}
