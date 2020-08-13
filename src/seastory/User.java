package seastory;

import java.util.Scanner;

public class User {
	
	//Music music;//배경음악
	
	public Scanner sc;
	protected int strength; //해너는 잠수한 횟수마다, 어부는 고기났은 횔수 늘때 마다
	
	protected int count; //해녀는 물고기 잡은 수 or 어부는 물고기 잡을때 마다
	
	private int limit;	//fisher일 때 rolling_Rod(낚시대 돌리는 횟수), diver일 때 depth(깊이)
	
	
	
	//moneytank 돈창고 래퍼런스
	private Moneytank moneytank;
	
	//inventory인벤 래퍼런스	
	private Inventory inventory;
	
	//Fishtank 물고기창고 래퍼런스	
	private Fishtank fishtank;
	
	
	
	
	
	//user생성자
	public User() { //해녀를 생성해주면  이 메소드로 저 피드들을 바꿔준다는 거
		this.strength =100;
		this.count = 0;
		this.moneytank = new Moneytank();
		this.inventory = new Inventory(this);
		/*
		 * Fishtank가 주인이 Diver인지 Fisher인지 판별하게 하기 위해
		 * User 자기 자신을 넘겨줌 (이 때, User는 Diver나 Fisher로 특화되어 있음)
		 */
		this.fishtank = new Fishtank(this);
		this.sc = new Scanner(System.in);
	}
	
	
	
	public User( User user) {				//기존 사용하던 어부의 돈창고,물고기창고,인벤토리를 보존
		this.strength = user.strength;		//기존 어부의 체력
		this.count = user.count;					//기존 어부가 물고기를 잡은 횟수
		this.moneytank = user.getMoneytank();		//기존 어부의 돈창고에 접근
		this.inventory = user.getInventory();		//기존 어부의 인벤토리접근
		
		this.fishtank = user.getFishtank();
		this.sc = new Scanner(System.in);
	}
	
	
	
	//내가 생성한 메소드//

	//action :user 가  새참 사기 -> oceanshop에서 show_food호출 
	public void buy_food(OceanShop shop){
		shop.show_food(this);  //this를 넘겨주는 거는 user이 해녀인지 어부인지 넘겨주려고
	} 

	
	
	//Diver와 Fisher에서 구현
	public void buy_skill(OceanShop shop) {

	}
	//스킬사기
	
	
	//action: 인벤토리 확인하기
	//diver, fisher에서 구현
	public void check_inven(Inventory inven) {
		
	}
	
	//물고기 잡기
	//diver, fisher에서 구현
	//abstract로 바꿀수 있는지 나중에 확인해보기
	public void catch_seafood() {
		
	}
	
	
	
	
	
	//public void sell_seafood() {
	public void sell_seafood(User user) {
	
	
		System.out.println("----------------------------내가 가진 물고기 확인하기---------------------------");
		System.out.println(" 총 해산물 갯수: " + getFishtank().getTotal_fish() +"개");
		System.out.println();
		
		for(int i=0 ; i< 5; i++) {
			
			System.out.println( getFishtank().fish_name[i]+ ": "+ getFishtank().count[i]+ "개");
		
		
		}
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.println();
		
		//String a = sc.nextLine();
		
		
	
		//어부 해녀용 //슈퍼어부용 해산물 판매 가격 다른거 뜨게
		
		if(this instanceof SuperFisher) {
		 System.out.println("┌────────────────────────────────────────────────슈퍼 어부용 해산물 판매 가격────────────────────────────────────────────────────┐");
			 
		}else {
		
		 System.out.println("┌─────────────────────────────────────────────────────해산물 판매 가격───────────────────────────────────────────────────────┐");
		}
		System.out.println();
		
		for(int i =0 ; i<5 ; i++) {
				
			System.out.print("\t"+(i+1)+")" + getFishtank().fish_name[i]+ ": "+ getFishtank().fish_price[i]+ "만원              " );
				
		}
		
		System.out.println();
		System.out.println();
		System.out.println("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────┘");
		System.out.println("판매할 해산물의 번호를 입력해주세요.");
		int sell_name= sc.nextInt();  //판매할 해산물의 번호 ex) 1이면 소라
		
		
		System.out.println("판매할 갯수를 입력해주세요.");
		int sell_count= sc.nextInt();	//판매할 갯수 ex)1이면 1마리
		
		
		if(sell_count>this.getFishtank().count[sell_name-1]  ) {
			System.out.println("해당 해산물이 존재하지 않습니다!!");
		}else {
		
		
		getFishtank().drawfish( sell_name , sell_count, this );  //판매 해산물 번호, 판매할 갯수 넘겨, Fishtank에 user 없어서 넘겨줌
		System.out.println();
		System.out.println( this.fishtank.fish_name[sell_name-1] + " 가(이) " + sell_count + "개 팔렸습니다." );
		this.getMoneytank().getmoney();
		
		System.out.println();
		}
		
		
	}
	
	
	//diver이랑 fisher이 overriding
	public void check_fishandmoney() {

	}
	
	
	//해녀 어부 overriding
	public boolean playrockpapaerscissor() {
		//가위바위보하는 거
		boolean flag = false;	//승부를 봤는지 안 봤는지
		boolean win = false;	//유저가 지면 false
		
		
		String a = sc.nextLine();

		 System.out.println("play)  0: 가위            1: 바위             2:보      ");
		 System.out.println();
		
		while (!flag) {  //true일때 동안
			System.out.print("번호를 입력해주세요 ");
			int computer = (int) (Math.random() * 3);
			int me = sc.nextInt();
			switch (me) {
			case 0:   //가위
				if (computer == 0) { //가위
					System.out.println("비겼습니다. 다시 하세요.");
					continue;
				} else {
					if (computer == 1) //바위
						
						{
						win = false;  //유저가 짐
						}
					else if(computer ==2) { //보
						win = true;  //유저가 이김
					}
					flag = true; //가위바위보 계속
				}
				break;
			case 1: //user 바위
				if (computer == 1) {  //바위
					System.out.println("비겼습니다. 다시 하세요.");
					continue;
				} else {	
					if (computer == 0) { //가위
						win = true;  //우저가 이김
					}
					else if(computer == 2) { //보
						win = false; //유저가 짐
					}
					flag = true;  //ㄱㅖ속
				}
				break;
			case 2: //user 보
				if (computer == 2) {  //보
					System.out.println("비겼습니다. 다시 하세요.");
					continue;
				} else {
					if (computer == 0) { //가위
						win = false; //유저가 
						}
					else if (computer ==1) { //바위
						win = true; //유저가 이김
					}
					flag = true;
				}
				break;
			default: System.out.println("잘못 냈습니다. 다시 하세요. ");
			}
		}
		if (win) 
			return true;  //유저가 이기면 true
		else 
			return false; //유저가 지면 false리턴
	}
	
	
	
	
	
	//showfood 에서 산 음식의 체력을 넘겨 받아서 올려
	public void addstrength(int strength) {
		this.strength += strength;
	}
	
	
	public void alarm_strength() {  //체력 20이할 일떄 경고 표시
		
		if(this.strength == 20) {
			System.out.println(" ------------------------------체력 충전 요망----------------------------------");
			System.out.println();
			System.out.println("                 체력이 20입니다!! 새참으로 체력을 보충해주세요!!");
			System.out.println();
			System.out.println(" --------------------------------------------------------------------------");
			System.out.println();
		}

	}
	
	
	public void alarm_money() {  //돈이 0 일때 경고 표시
		 if(this.getMoneytank().getmoney() == 0) {
			 	System.out.println(" ------------------------------잔액 부족 ----------------------------------");
				System.out.println();
				System.out.println("                 돈이 0입니다!! 얼른 돈을 벌어주세요.");
				System.out.println();
				System.out.println(" ------------------------------------------------------------------------");
				System.out.println();
		 }
	}

	public void game_clear() {
		
		if(this.getMoneytank().getmoney() >= 300){
			System.out.println(" ------------------------------게임 성공--------------------------------");
			System.out.println();
			System.out.println("                 목표 금액 300 만원을 다 모았습니다~!");
			System.out.println();
			System.out.println(" ---------------------------------------------------------------------");
			System.out.println();
			
			System.exit(0);
		}		
	}
	
	
	
	
	
	//setter&getter	
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public int getStrength() {
		return strength;
	}

	public int getCount() { //반한
		return count;
	}

	public Moneytank getMoneytank() {
		return moneytank;
	}


	public Inventory getInventory() {
		return inventory;
	}
	
	public Fishtank getFishtank() {
		return fishtank;
	}



	public void setStrength(int strength) {
		this.strength = strength;
	}



	public void setCount(int count) { 
		this.count = count;
	}


	public void setMoneytank(Moneytank moneytank) {
		this.moneytank = moneytank;
	}


	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void setFishtank(Fishtank fishtank) {
		this.fishtank = fishtank;
	}
	
//	public void setStrengthminusone(int strength) {
//		this.strength -=strength;
//	}
//	
}
