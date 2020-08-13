package seastory;

public class SuperFisher extends Fisher{
	
	public SuperFisher(User fisher) {
		super(fisher);   //fisher 메소드 변수 가져오기
		super.getFishtank().getBenefit(fisher.getFishtank()); //getBenefit 에 기존 어부 물고기탱크 넘겨줘
	}
	
	
	public void meet_whale(User fisher) {
		
		
		System.out.println("어???? 저기 비닐봉지가 숨 구멍을 막아서 괴로워하는 고래가 있어요!!!");
		System.out.println(
				"┌────────────────────────────────────────────────────────────────────────────────────┐");
		System.out.println("");
		System.out.println(" 			       (1)도와준다               (2) 무시하고 지나간다");
		System.out.println("");
		System.out.println(
				"└────────────────────────────────────────────────────────────────────────────────────┘");
		System.out.println("번호를 입력해주세요:");
		int a = sc.nextInt();
		
		if(a ==1 ) {
			
			
			System.out.println("-------------------------------<알림>--------------------------------");
			
			System.out.println();
			System.out.println("	슈퍼 어부님이 고래를 도와준 보답으로 잔고가 지금 2배로 채워졌습니다~ ");
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			super.getMoneytank().doubleMoney(fisher.getMoneytank().getmoney());
			
			
		}else{
			
			System.out.println("정말 그냥 지나가신다고요??? ");
		}
	}
	
	
	
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
		
		switch(spin_rod) {   //
			
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
		
		int fish_index = (int)(Math.random()*type);
		
		//this.getFishtank().addFish(type ,fish_index);
		this.getFishtank().addFish(type,fish_index,this);

		System.out.println();
		System.out.println();
		this.count++; //어부가 물고기 잡을 횟수
		
		if (this.count % 8 == 0 && this.count != 0 ) { //물고기를3마리중 한번 잡거나 0번 이상 일때
			
			System.out.println("잠깐! 해적이 나타났습니다!");
			System.out.println("가위바위보에서 이기면 돈 20만원을 획득하고,");
			System.out.println("가위바위보에서 지면 돈을 다 잃게 됩니다.");
			meet_pirate();		//가위바위보결과에 따라 +30만원 or 돈 창고 0
			
		}else if(this.count % 5 ==0 && this.count!=0) {
			
			System.out.println("어머! 해일이 덮쳤습니다!"); 
			meet_hail();
			
		}else if(this.count %3 == 0 && this.count!=0) { //3번에 1번 꼴로 조력자등장
			meet_whale(this);
		}
		
		//this.strength-=10;
	} 
	
	
	
	
	
	
	
	
}
