package seastory;

import java.util.Scanner;

public class OceanShop {
	private Scanner sc;
	
	
	
	private String [] food_name; // 새참 보여줄배열
	private int[] food_price;	 //새참 가격 담을 배열
	private int[] food_strength;  //새참이 주는 채력 담을 배열
	
	public String [] skills_diver_name; //해녀 스킬보여줄 배열
	public int[] skills_diver_price;  //해녀스킬 가격
	public int[] skills_diver_meter;  //해녀 스킬 미터
	
	
	public String [] skills_fisher_name; //어부 스킬 보여줄 배열
	public int[] skills_fisher_price;  //어부스킬 가격
	public int[] skills_fisher_spin;  //어부 스킬 미터
	
	
	//생성자
	public OceanShop() {
		//음식(새참)
		this.food_name = new String[]{"고구마", "옥수수", "컵라면", "한라봉", "오메기떡", "홍삼"};
		this.food_price = new int[] {1, 1, 1, 1, 2, 3}; //가격
		this.food_strength = new int[] {30, 30, 30, 30, 70, 100}; //주는 체력
		this.sc = new Scanner(System.in);
		
		this.skills_diver_name = new String[] {"5m 내려가기", "10m 내려가기"};
		this.skills_diver_price = new int [] {3,5}; //가격
		this.skills_diver_meter = new int [] {5,10}; //주는 깊이 미터
		
		this.skills_fisher_name = new String[] {"낚시줄 500번 돌리기" , "낚시줄 1000번 돌리기"};
		this.skills_fisher_price = new int[] {25,50};
		this.skills_fisher_spin = new int[] {500,1000};
		
	}
	
	
	
	//스킬살지 새참 살지 고르기
	public int choice_skill_food() { 
		
		System.out.println(
				"┌─────────────────────────────────────────────────────────────────────┐");
		System.out.println("");
		System.out.print("            (1)새참 사기               (2)스킬 사기 ");
		System.out.println();
		System.out.println("");
		System.out.println(
				"└─────────────────────────────────────────────────────────────────────┘");
//		Loading loading = new Loading("번호를 선택하세요.");
//		loading.start();
		System.out.print(" 번호를 선택하세요. ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt() ;
		
		if(choice == 1) {
			return 1;
		}else if(choice == 2){
			return 2;
		}
		return 0;
	}
	
	
	
		//action:새참 보여주기,새참 입력 받기,체력 올려->user의 addStrength호출, 돈 깍아->
		// 반환 되는 int strenght를 올려
		
	public void show_food(User user) {                  //새로생성 하면 안되는 새참 살때 마다 user 안 보내주면 user이 물건 살때 가격,체력 변화가 없어 그냥 그대러야
		//System.out.println("새참입니다");
		System.out.println("------------------ 새참----------------------");
		for (int i = 0; i < food_name.length; i++) {
			
			System.out.println((i+1) + ") " + food_name[i] + 
					", " + food_price[i] + "만원, 체력 보충 : " + food_strength[i]);
			
			
		}
		System.out.println("------------------------------------------");	
		System.out.println();
		
		System.out.println("음식 번호를 선택하세요. ");
		int choice = sc.nextInt() - 1; //choice 0: 고구마      1:옥수수   2:컵라면    3:한라봉  4:오메기떡  5:홍삼 
		
		System.out.println();
		System.out.println();
		
		Food food = new Food(food_name[choice], food_price[choice], food_strength[choice]);  //음식  객체 생성~~~
		
		
		//만약 해당 새참 가격보다 돈창고에 돈이 없다면 돈이 없다는 에러를 뱉어주고 구매하지마!
		if(food_price[choice] > user.getMoneytank().getmoney()    ) {  //새참 가격이 현재 내 돈창고 보다 가격이 클때
			 
		 	System.out.println(" ------------------------------잔액 부족----------------------------------");
			System.out.println();
			System.out.println("                 돈이 부족합니다. 물고기를 팔아서 돈을 버세요.");
			System.out.println();
			System.out.println(" -----------------------------------------------------------------------");
			System.out.println();
			
			}else {
		 
	 		System.out.println("<"+food_name[choice] +">"+ "를 선택하셨습니다.\n\n ");
		
	 		user.addstrength(food.getStrength()); //food객체의 Strength만큼 addstrength에 넘겨줘
	 		user.getMoneytank().drawmoney(food.getPrice()); //food객체 price만큼 drawmoney로 넘겨줘
		
	 
	 			}
	} 
	
	
	
	
	
	
	
	//해녀스킬 보여주기
	//1)돈 깍아
	//2)인벤토리에 스킬 갯수 올려
	public void show_skill_diver (User user) {
		
		System.out.println();
		System.out.println();
		System.out.println("------------------ 스킬----------------------");
		for (int i = 0; i < skills_diver_name.length; i++) {

			System.out.println((i+1) + ") " + skills_diver_name[i] + 
					", " + skills_diver_price[i] + "만원" );
		}
		System.out.println("--------------------------------------------");	
		System.out.println();
		
		System.out.println("스킬 번호를 선택하세요. ");
	
		
		int choice = sc.nextInt() - 1;
		
		System.out.println();
		System.out.println();
		
		//Skill 클래스로 객체 생성
		Skill skill = new Skill(skills_diver_name[choice], skills_diver_price[choice], skills_diver_meter[choice]);  //해녀 스킬 객체 생성~!
		
		if(skills_diver_price[choice] > user.getMoneytank().getmoney()    ) { //해녀 스킬 가격이 현재 내 돈창고 보다 가격이 클때
			
			System.out.println(" ------------------------------잔액 부족----------------------------------");
			System.out.println();
			System.out.println("                 돈이 부족합니다. 물고기를 팔아서 돈을 버세요.");
			System.out.println();
			System.out.println(" -----------------------------------------------------------------------");
			System.out.println();	
			
		}else {
		
			
		user.getMoneytank().drawmoney(skill.getPrice()); // 돈 창고 돈 깍아
		user.getInventory().addInventory(skill);		 // skill 블록에 추가 {"5m " ,"10m" ,"10m" ,"10".....}
		user.getInventory().count[choice]++ ;			 //해당 스킬을 사면 inventory의  해당 count 숫자도 늘려줘야돼 {0,0 }-> {0,1}
														 //choice에 0이 들어가면 inven 의 count 배열에서 choice인덱스 갯수를 +1 해줘야돼
		
		System.out.println("<"+skills_diver_name[choice] +">"+ "(을)를 선택하셨습니다. ");
		
		}
	} 
	
	
	
	
	
	
	
	
	
	
	 //어부 스킬보여주기
	//<어부 안되는거>
	//1.스킬 사면 돈이 줄는거 안됨
	//2. 스킬사면 총 스킬 숫자 늘어나는거 안돼
	//3. 인벤토리에 스킬 추가 되는 거 안됨
	public void show_skill_fisher(User user) {
		System.out.println();
		System.out.println();
		System.out.println("------------------ 스킬----------------------");
		for (int i = 0; i < skills_fisher_name.length; i++) {

			System.out.println((i+1) + ") " + skills_fisher_name[i] + 
					", " + skills_fisher_price[i] + "만원" );
		}
		System.out.println("------------------------------------------");	
		System.out.println();
		
		System.out.println("스킬 번호를 선택하세요. ");
		
		int choice = sc.nextInt() - 1;
		
		System.out.println();
		System.out.println();
		
//		if(choice !=0 || choice != 1){
//			System.out.println("번호를 잘못 입력하셨습니다. ");	
//		}else {
		
		Skill skill = new Skill(skills_fisher_name[choice], skills_fisher_price[choice], skills_fisher_spin[choice]);  // 어부 스킬 객체 생성~!
		
		
		if( skills_fisher_price[choice] > user.getMoneytank().getmoney()    ) { //해녀 스킬 가격이 현재 내 돈창고 보다 가격이 클때
			
			System.out.println(" ------------------------------잔액 부족----------------------------------");
			System.out.println();
			System.out.println("                 돈이 부족합니다. 물고기를 팔아서 돈을 버세요.");
			System.out.println();
			System.out.println(" -----------------------------------------------------------------------");
			System.out.println();	
			
		}
		else {
		
		user.getMoneytank().drawmoney(skill.getPrice()); // 돈 창고 돈 깍아
		user.getInventory().addInventory(skill);		 // skill 블록에 추가 {"500번 " ,"500m" ,"1000번" ,"500번".....}
		user.getInventory().count[choice]++ ;			 //해당 스킬을 사면 inventory의  해당 count 숫자도 늘려줘야돼 {0,0 }-> {0,1}
														 //choice에 0이 들어가면 inven 의 count 배열에서 choice인덱스 갯수를 +1 해줘야돼
		
		System.out.println("<"+skills_fisher_name[choice] +">" +"(을)를 선택하셨습니다. ");

		}
		}
	} 
	
 	
	
	
//}
