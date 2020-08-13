package seastory;

import java.util.Scanner;

public class Diver extends User {

	boolean skill;
	
	private final int TIMER = 10;
	public Scanner sc;
	
	public Diver(){
		super(); //User  변수 메소드 다 호출 기본 생성자로
		super.setLimit(1);   //setLimit 호출 1로 초기화
				
	}
	

	//해녀용
	public void check_inven(Inventory inven) {
		System.out.println("인벤토리에서 가지고 있는 스킬을 확인하 고 장착 할수 있습니다.");
		System.out.println(
				"┌────────────────────────────────────────────────────────────────────────────────────┐");
		System.out.println("");
		System.out.println(" 			  (1)스킬 확인하기               (2) 스킬  장착하기");
		System.out.println("");
		System.out.println(
				"└────────────────────────────────────────────────────────────────────────────────────┘");
		Scanner  sc = new Scanner(System.in);
		
		int a  = sc.nextInt();
		//openShop 변수들이 이 diver에서 필요해
		
		if( a== 1) {
			
			System.out.println("스킬 확인하기\n");
			System.out.println("-------------------스킬 확인하기---------------------");
		
			
			for(int i =0 ; i< this.getInventory().skillname.length ; i++ ) {
				
				System.out.println((i+1)+")"+this.getInventory().skillname[i] + " : " + this.getInventory().count[i]  );
				
				}
			
			System.out.println("--------------------------------------------------");
			
			
			
			}else if (a == 2)
			{
			
			System.out.println("스킬 확인하고 장착하기\n");
			System.out.println("-------------------스킬 확인하기---------------------");
			for(int i =0 ; i< this.getInventory().skillname.length ; i++ ) {
				
				System.out.println(	(i+1)+")"+this.getInventory().skillname[i] + " : " + this.getInventory().count[i]  );
		
			}
			
			System.out.println("--------------------------------------------------");
			System.out.println();
			
			String line   = sc.nextLine();
			
			System.out.println("장착할 스킬의 번호를 입력해주세요.(스킬이 0개 일 경우 장착이 불가합니다)");
			
			int index= sc.nextInt();  //스킬 번호를 입력받아
			
			//해당 스킬 item count 는 하나 떨어진다.
			
			
			if( index == 1 ) {   //5m 내려가기
				
			
					if(getInventory().count[index-1]==0 ) {  //해당 스킬 item count가 0 이면 {0,0}스킬이 없으니깐 다시 잠수 깊이 1m 로 조정
						super.setLimit(1);
						System.out.println("<5m 내려가기>  스킬을 구매하셔야 사용할 수 있습니다.");
						
					}else {
					
					System.out.println("<5m 내려가기> 를 장착합니다.");
					System.out.println("당신은 이제 [문어]를 잡을 수 있는 기회가 생겼습니다.");
					super.setLimit(5);						//스킬을 선택하면 해당 스킬을 장착하는  limit을 5로 바꿔주고
					this.getInventory().count[index-1 ]--;	//해당 스킬 item count 는 하나 떨어진다. ex){1,0}->{0,0}
					
					}
					
					
			}else if( index == 2 ) {

				
				if(getInventory().count[index -1] == 0) {     //해당 스킬 item count가 0 이면 {0,0}스킬이 없으니깐 다시 잠수 깊이 1m 로 조정
					super.setLimit(1);
					System.out.println("<10m 내려가기> 스킬을 구매하셔야 사용할 수 있습니다.");
				}else {
				
			System.out.println("<10m 내려가기> 를 장착합니다.");
			System.out.println("당신은 이제 [전복]을 잡을 수 있는 기회가 생겼습니다.");
			super.setLimit(10);								//스킬을 선택하면 해당 스킬을 장착하는  limit을 10로 바꿔주고
			this.getInventory().count[index-1]--;			//해당 스킬 item count 는 하나 떨어진다. ex){0,1}->{0,0}
			
			
						}
					}
			
			
				}
			}
			
			
			
			
			
		
			

	
	//스킬사기(바다 상점)
	public void buy_skill(OceanShop shop) {
		shop.show_skill_diver(this);  // 샵에 Diver을 보내는 거
	}
	
	// 해녀 도둑만나기
	//user meet_thief()오버라이딩
	public void meet_thief() {      
		boolean win = super.playrockpapaerscissor();
		if (win) {
			System.out.println();
			System.out.println("가위바위보를 이겼습니다!");
			System.out.println();
			this.getMoneytank().addMoney(30);
			System.out.println("해녀 도둑에게 30만원을 획득해 총 "+ this.getMoneytank().getmoney()+" 만원이 되셨습니다~\n"); //돈 얼마 인지 보여줘
			System.out.println();
		} else {
			System.out.println();
			System.out.println("가위바위보를 졌습니다.");
			System.out.println();
			this.getFishtank().cleartank();
			System.out.println("물고기 창고가 0 이 되었습니다.다시 열심히 물고기를 잡아주세요.");
			System.out.println();
		}
	} 
	
	
	//Overriding
	//user catch_seafood()오버라이딩
	//2)물고기 잡기
	public void catch_seafood() { //dive_depth가 limit
	
		//Music oceansound = new Music("Water Sound.mp3",true);
		
		
		
		
		
		Fishtank currentFishtank = null; //1round에 잡은 물고기 
		
		
		this.alarm_strength();
		
		if (super.getStrength() <= 0) {
			System.out.println("체력이 부족합니다. 게임에 실패하셨습니다.");
			System.exit(0);
		}
		
		int dive_depth = super.getLimit();   // 기본1m 잠수
		
		int term; //= (int)(Math.random()*20) + 1; // 물고기를 잡고 쉬는 시간 
		int type;  //어느 물고기를 생성할지
		
		switch(dive_depth) { //
		
		case 1:  	 	//1m잠수일때  type=3으로 5개중 3개(index)숫자 받아줘
			type = 3; 
			break;
		case 5:			//5m잠수일때  type=4으로 5개중 4개(index)숫자 받아줘
			type = 4;
			break;
		case 10:		//10m잠수일때  type=5으로 5개중 5개(index)숫자 받아줘
			type = 5;
			break;
		default:
			type =3;
			break;
			
		}
		
		//해녀 물고기 창고에 물고기 집어놔주기
		for(int i =0 ; i <= TIMER ; i+= term) {  //10초 동안 랜덤한 초를 지나게해서
			
			
			
			currentFishtank = this.getFishtank().addFish(type, this);
			
			System.out.println();
			System.out.println();
			term =(int)(Math.random()*5)+1;
			this.count++;  //해녀가 물고기에 물고기를 10번 잡을때
			if (this.count % 10 == 0 && this.count != 0 ) { //물고기를 10마리중 한번 잡거나 0번 이상 일때
				System.out.println("잠깐! 도둑 해녀가 나타났습니다!\n");
				System.out.println("가위바위보에서 이기면 돈 30만원을 획득하고,");
				System.out.println("가위바위보에서 지면 물고기를 다 잃게 됩니다.");
				meet_thief( );
			}
			
			
		}
		//this.strength -= 10; //user의 체력 떨어트려
		
		System.out.println("해산물이 "+ currentFishtank.getNow_total_fish() + "개 잡혔습니다.");
		System.out.println(currentFishtank);
		currentFishtank.setNow_total_fish(0);
		currentFishtank.setJustnow_catch(new Seafood[10]);
		super.setLimit(1);
	}
	
	
	//Overriding diver용(해녀용)
	public void check_fishandmoney() {
	
			
			System.out.println("-------------------------------물고기 창고---------------------------");
			System.out.println(" 총 해산물 갯수: " + super.getFishtank().getTotal_fish() +"개");
			System.out.println();
			
			for(int i=0 ; i< 5; i++) {
				
				System.out.println( super.getFishtank().fish_name[i]+ ": "+ getFishtank().count[i]+ "개");
			
			
			}
			
			System.out.println("------------------------------------------------------------------");
			System.out.println();
			
		}
		
		
}
		

	
	
	
	
	
	
	
	
	
		
	



