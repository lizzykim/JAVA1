//문제:297번 줄에 setStrength로 체력 -1깍은 값으로 설정해주는데 menu메소드에서 현재 상태가 원래 값 100으로 다시 셋팅됨

package seastory;

import java.util.Scanner;

public class Fisher extends User implements Runnable{
	

	int fish_index;
	public boolean stop = false; //스레드의 종료목죡
	public boolean work = true;  //yeid f를 호출한 시점을 알기 위해

	
	public Fisher() {
		
		super();
		super.setLimit(100);
	
	}
	
	
	public Fisher(User user) {
		
		super(user);
		super.setLimit(user.getLimit());
	}

	
	//해일만나기: 물고기 창고 0 이됨
	public void meet_hail() {
		super.getFishtank().cleartank();
		System.out.println("물고기 창고가 0 이 되었습니다.다시 열심히 물고기를 잡으세요.");
		System.out.println();
	}
	
	
	
	//어부용 
	public void check_inven(Inventory inven) {
	
	System.out.println("인벤토리에서 가지고 있는 스킬을 확인하고 장착 할수 있습니다.");
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
			
			System.out.println(	(i+1) + ") "+this.getInventory().skillname[i] + " : " + this.getInventory().count[i]  );
			
			}
		
		System.out.println("--------------------------------------------------");
		
		
		}else if (a == 2)
		{
	
	
			System.out.println("스킬 확인하고 장착하기\n");
			System.out.println("-------------------스킬 확인하기---------------------");
			for(int i =0 ; i< this.getInventory().skillname.length ; i++ ) {
				
				System.out.println(	(i+1) + ") "+this.getInventory().skillname[i] + " : " + this.getInventory().count[i]  );
		
			}
			
			System.out.println("--------------------------------------------------");
			System.out.println();
			
			String line   = sc.nextLine();
			
			System.out.println("장착할 스킬의 번호를 입력해주세요.(스킬이 0개 일 경우 장착이 불가합니다)");
			
			int index= sc.nextInt();  //스킬 번호를 입력받아
			
			//해당 스킬 item count 는 하나 떨어진다.
			
			if( index == 1 ) {   //낚시줄 500번 돌리기
	
				if(getInventory().count[index-1]==0 ) {  //해당 스킬 item count가 0 이면 {0,0}스킬이 없으니깐 다시 낚시대 100번 돌리기 로 조정
					super.setLimit(100);
					System.out.println("<낚시줄100번 돌리기> 스킬을 구매하셔야 사용할 수 있습니다.");
					
					}else {
					
					System.out.println("<낚시줄 500번> 돌리기 를 장착합니다.");
				    System.out.println("당신은 이제 [복어]를 잡을 수 있는 기회가 생겼습니다.");
				    super.setLimit(500);						//스킬을 선택하면 해당 스킬을 장착하는  limit을 5로 바꿔주고
				    this.getInventory().count[index-1 ]--;	//해당 스킬 item count 는 하나 떨어진다. ex){1,0}->{0,0}
				
				}
				
			}else if( index == 2) {	//낚시줄 1000번 돌리기
				
				if(getInventory().count[index -1] == 0) { //해당 스킬 item count가 0 이면 {0,0}스킬이 없으니깐 다시 낚시대 100번 돌리기 로 조정
					super.setLimit(100);
					System.out.println("<낚시줄500번 돌리기> 스킬을 구매하셔야 사용할 수 있습니다.");
					}else {
				
					System.out.println("<낚시줄 1000번 돌리기> 를 장착합니다.");
					System.out.println("당신은 이제 [참치]를 잡을 수 있는 기회가 생겼습니다.");
					super.setLimit(1000);								//스킬을 선택하면 해당 스킬을 장착하는  limit을 10로 바꿔주고
					this.getInventory().count[index-1]--;			//해당 스킬 item count 는 하나 떨어진다. ex){0,1}->{0,0}
				
					}
				
			}
		}
			
	
	
	
	
	
	
	
	}


	
	public void buy_skill(OceanShop shop) {
		shop.show_skill_fisher(this);
	}
	
	
	
	
	
	//해적 만나기,가위바위보하기
	public void meet_pirate() {
		boolean win = super.playrockpapaerscissor();
		if(win) {
			System.out.println();
			System.out.println("가위바위보를 이겼습니다!");
			System.out.println();
			this.getMoneytank().addMoney(20);
			System.out.println("해적에게 20만원을 획득해 총 "+ this.getMoneytank().getmoney()+" 만원이 되셨습니다~\n"); //돈 20 얻음
		}else {
			System.out.println();
			System.out.println("가위바위보를 졌습니다.");
			System.out.println();
			this.getMoneytank().clearmoney();
			System.out.println("돈 창고가 0 이 되었습니다.다시 열심히 물고기를 잡고 팔아서 돈을 모으세요.");
			System.out.println();
		}
		
	} 
	
	
	
	//2)물고기 잡기
	public void catch_seafood() {
		

		
		this.alarm_strength();
		
		if (super.getStrength() <= 0) {
			
			System.out.println(" ------------------------------게임 실패----------------------------------");
			System.out.println();
			System.out.println("체력이 부족합니다. 게임에 실패하셨습니다.");
			System.out.println();
			System.out.println(" --------------------------------------------------------------------------");
			System.exit(0);
		}
		
		int spin_rod = super.getLimit();  //기본 낚시줄 100번 돌리기
		
		int type; //어느 물고기를 생성할지
		
		switch(spin_rod) {   
			
		case 100:
			type = 3;
			break; 
		case 500:
			type = 4;
			break;
		case 1000:
			type = 5;
			break;
		default:
			type =3;
			break;
		
		}
		
		fish_index = (int)(Math.random()*type);//잡히는 물고기 인덱스값
		
		FishWait move = new FishWait();  
		move.start();  //입질 시작
		
		synchronized(move) {
			
			try {
				move.wait();  //main이  move스레드 끝날때까지 정지?
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		
		this.getFishtank().addFish(type,fish_index,this);
		
		

		System.out.println();
		System.out.println();
		this.count++; //어부가 물고기 잡을 횟수
		
		
		
		
		
		if (this.count % 8 == 0 && this.count != 0 ) { //물고기를3마리중 한번 잡거나 0번 이상 일때
			
			System.out.println("잠깐! 해적이 나타났습니다!");
			System.out.println("가위바위보에서 이기면 돈 20만원을 획득하고,");
			System.out.println("가위바위보에서 지면 돈을 다 잃게 됩니다.");
			meet_pirate();		//가위바위보결과에 따라 +30만원 or 돈 창고 0
			
		}else if(this.count % 5 ==0 ) {
			
			System.out.println("어머! 해일이 덮쳤습니다!"); 
			meet_hail();
			
		}
		

		
		
		
		
		
		
		
		
		//this.strength-=10;
		super.setLimit(100);
		
		
	} 
	
	
	//어부용  돈,물고기 창고 확인하기
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

	//어부 체력깍이는 메소드
	
	
	public synchronized void pull_fish() {
		
		
		
		for(int i =0 ; i< this.getFishtank().fish_resist[fish_index];i++) {
		
		

		this.setStrength(super.strength-1);//어부의 체력을 가져오서 1빼주고 변경한걸로 다시 설정
		System.out.println("어부가 낚시대를 당깁니다(현재 체력: "+ super.getStrength()+")"   );

//		notify();
		try {
				Thread.sleep(500);
//			wait(); //어부 스레드쉬어
		} catch (InterruptedException e) {}
			
		}

	}
	
	
	
	//체력이 깎임
	@Override
	public  void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		
			pull_fish();
			
	}
	

	
	
	
	
	
}
