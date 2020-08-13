//문제: 120번줄 , 체력을 가져오는데 user에서 생성자로 초기화 된 100을 접근하는 것같아
package seastory;


import java.util.Scanner;



public class GameMain0 { //shop은 언제든지 그자리에 있어야돼 그때마다 샵이 생기면 이상하잖아 그래서 아예 만들어 버린거야 
	
	private User user;
	
	private OceanShop shop;
	private Inventory inven;
	
	private boolean superfisherFlag = false;  //사용자가 fisher이고 돈이 100 이상인지 확인하는 if가 한번 실행해야되니깐 ->제어문 false 
	
	public GameMain0() {
		
		
		
		this.shop = new OceanShop(); //샵을 만들어주거
		this.inven = new Inventory(user);
	}
	

	public User choiceuser() {
		
		System.out.println(" 유저를 선택해 주세요.");
		System.out.println(
				"┌──────────────────────────────────────────────────────────────────────────────────────────────────────┐");
		System.out.println("");
		System.out.println("  	   (1)해녀    (특징)물고기의 판매 가격이 낮지만 한번에 여러 물고기 낚을수 있음   ");

		System.out.println("  	   (2)어부    (특징)물고기의 판매 가격이 높지만 한번에 한개의 물고기를 낚고 더 많은 방해요소가 존재  ");

		System.out.println("");
		System.out.println(
				"└──────────────────────────────────────────────────────────────────────────────────────────────────────┘");

		Scanner sc1 = new Scanner(System.in);
		int choice = sc1.nextInt();

		if (choice == 1) {

			System.out.println("당신은 해녀입니다! 열심히 해산물을 잡아볼까요?");
			System.out.println("Tip)해산물을 본격적으로 잡기 전에 바다 상점에서 새참과 스킬을 사는 것이 어떨까요? ");
			System.out.println("");		
			System.out.println("");
			Diver diver1 = new Diver();
			
			
			
			return diver1;
			
		}
		else if(choice ==2 ) {
			System.out.println("당신은 어부입니다. 열심히 물고기를 잡아볼까요?");
			System.out.println("Tip)해산물을 본격적으로 잡기 전에 바다 상점에서 새참과 스킬을 사는 것이 어떨까요? ");
			System.out.println("");	
			System.out.println("");	
			Fisher fisher1 = new Fisher();
			
			
			return fisher1; 
		} else {
			
			
			return null;//choice 1,2아닐때 null이라도 리턴 
		}
		
	}
	///
	

	public int menu() {
	
			Music dingdong = new Music("upgrade.mp3", true);
			
		if(!superfisherFlag && user instanceof Fisher && user.getMoneytank().getmoney()>=100) {  //사용자가 어부이고&&사용자의 돈이 100이상일때
	 		
			
	 		dingdong.start();
	 		
	 		
			user = new SuperFisher(user);  //슈퍼어부 생성, 기존 어부가 가진 정보를 매개변수로 넘겨줘
			
			System.out.println("===================<<슈퍼 어부로 업그레이드 알림>> ====================");
			System.out.println();
			System.out.println("당신은 어부에서 <슈퍼 어부>로 업그레이드 되셨습니다!");
			System.out.println("<슈퍼어부>는 잡은 해산물을 기존보다 2배 높은 가격으로 팔 수 있습니다.");
			System.out.println();
			System.out.println("===============================================================");
			superfisherFlag = true;
			
			

			//dingdong.isLoop(false);
			
			
		}
		
		
		dingdong.isLoop(false);

		
		
		
		user.alarm_money();
		user.game_clear();
		
		Loading tomenu = new Loading("▶▶▶▶▶▶▶▶▶▶▶▶▶▶▶메뉴로 이동합니다.▶▶▶▶▶▶▶▶▶▶▶▶");
		
		tomenu.start();
		
	
		try {
			tomenu.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(
				"┌──────────────────────────────────────────────────────────────────────────────────────────────────────┐");
		System.out.println("");
		System.out.println("        (1)바다상점	  (2)해산물 잡기	 (3)해산물 창고	  (4) 해산물 팔기	   (5)인벤토리	 ");
		System.out.println("");
		System.out.println(
				"└──────────────────────────────────────────────────────────────────────────────────────────────────────┘");
		
		System.out.println("============== 현재  상태==============="); 
		System.out.println(" (체력  0이 되면 게임이 종료됩니다.) ");
		System.out.println("                                  ");
 		System.out.println("  체 력: "+ user.getStrength()       );
 		System.out.println("  잔 고: "+ user.getMoneytank().getmoney()+"만원");  //돈 깍음
 		System.out.println("=====================================");
 		System.out.println();	 
		
		
 		
		System.out.println("번호를 입력하세요:");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		return choice;
		

	
		
	}
	
	
	
	//////
	public static void main(String[] args) {
		

		
		GameMain0  gamemain0 = new GameMain0();
		int choice;
		
		System.out.println("제주도 서사라로 이사왔다.\n여기 사람들 다 어업을 하면서 생계를 꾸린다.");
		Scanner sc0 = new Scanner(System.in);
		String enter1 = sc0.nextLine();
		System.out.println("나도 한번 어업을 본격적으로 할까? 고민에 빠진다. 근데 내게 남을 돈은 10만원... 그래 일단 목표를 300만원을 만들어 보자 하는 마을으로 어업을 결심한다.");
		String enter2 = sc0.nextLine();
		
	 	System.out.println("게임 목표 : 초기 자본 10 만원을 300만원으로 만들면 게임을 끝납니다.");
		System.out.println("자 그럼 시작해보자!\n");
		
	
		
		//여기 음악 삽입
		Music intromusic = new Music("introMusic.mp3", true);
		
		intromusic.start();
		
		
		String enter3 = sc0.nextLine();
		
		new Thread(()-> {
			System.out.println("-----------------------------------------------------게임 방법-------------------------------------------------------");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step1) 먼저 유저를 선택해주세요.해녀는 한번에 여러개의 해산물을, 어부는 한번에 한개의 해산물을 잡을 수 있습니다.");
			System.out.println("             해녀는 한번에 여러개의 해산물을, 어부는 한번에 한개의 해산물을 잡을 수 있습니다.");
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step2) 메뉴에서 2)해산물잡기 4)해산물팔기 를 통해 물고기를 잡고 팔아주세요.   ");
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step3) 해녀는 잠수 할떄 마다, 어부는 물고기를 한마리씩 잡을때 마다 체력이 -10씩 떨어집니다.");
			System.out.println("             떨어지는 체력을 회복하기 위해 1)바다상점에서 새참을 먹어주세요.");
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step4) 해녀와 어부의 기본 스킬이 정해져있기 때문에 해당 스킬에 대한 해산물 밖에 잡지 못합니다.");
			System.out.println("             더 다양한 해산물을 잡기 위해 1)바다상점에 가서 스킬을 사고 5)인벤토리에서 스킬을 장착하고 더 고가의 해산물을 잡아보세요.");
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step5) 2)물고기를 잡으면서  여러 이벤트가 나옵니다.이벤트를 통해 돈을 벌고 잃을 수 있습니다.");
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step6) 어부는 100만원을 모으면 <슈퍼어부>로 업그래이드 됩니다. 슈퍼 어부는 해산물을 2배 더 높은 가격에 판매 할 수 있으면 아픈 고래를 도와주면 잔고를 ");
			System.out.println("              슈퍼 어부는 해산물을 2배 더 높은 가격에 판매 할 수 있으면 아픈 고래를 도와주면 잔고를 2배로 높일 수  있습니다.");
			System.out.println("-------------------------------------------------------------------------------------------------------------------");
			
			
			
			
		}).start();
		

		String enter4 = sc0.nextLine();
		
	
		
		gamemain0.user = gamemain0.choiceuser();//어부가 들어가
		
	
		
		while (true) { //메뉴가 홈이니깐 계속 뜨게 만들어주기
			
			choice = gamemain0.menu();  //메뉴보여주기
			
			
			
			
			
			switch (choice) {
			
			
			
			case 1: //바다 상점 가기
				int get;
				get =gamemain0.shop.choice_skill_food(); //새참 살지 스킬 살지 보여주고 int return받아
				
				if( get ==1  ) {	// 바다상자 -새참 클릭
				gamemain0.user.buy_food(gamemain0.shop); 
				}
				else if( get ==2) {		//바다상자 -스킬클릭
					gamemain0.user.buy_skill(gamemain0.shop);
				}
				
				break;
			
			case 2 : //해산물 잡으러 가기
				//intromusic.close();
				
				gamemain0.user.catch_seafood();
				
			
				break;
			case 3 : //물고기 창고 확인하기
				gamemain0.user.check_fishandmoney();
				break;
			case 4:  //해산물 팔기
				//gamemain0.user.sell_seafood();
				gamemain0.user.sell_seafood(gamemain0.user);
				break;
			case 5: //인벤토리가기
				gamemain0.user.check_inven(gamemain0.inven);
				break;
				
			default:
				intromusic.close();
				System.exit(0);
				break;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		}
	}




