//07.09 목표//
//잡은 물고기 보관하는거 배열에서 베열 리스트 사용하기!!
//nullpointerexception없애기
//현재 nullpointerexception 들어간 메소드 ( getBenefit /drawfish/addfish/cleartank)



package seastory;
import java.util.ArrayList;
import java.util.Scanner;

public class Fishtank extends Thread{

	protected int total_fish;
	
	protected ArrayList<Seafood> block;
	

	int fish_index;


	protected String[] fish_name; 
	
	protected int[] fish_price;  // 해녀 {5,5,5,10,20}    어부{20,20,20,50,100}
	
	protected int[] count;
	
	protected int[] fish_resist;
	
//	boolean stop;
//	boolean work;
//	
	public int strength;
	

	
	protected int now_total_fish; //현재 잡힌 물고기 갯수   //어부는 1개    but, 해녀는 여러개(해녀 count갯수)
	
	protected Seafood[] justnow_catch ;  //현재 잡힌 물고기 넣는 임시 배열
	
	
	//생성자
	public Fishtank(User user) {
		
		
		this.strength = user.strength;
		
		if (user instanceof Diver) {
			
			fish_name = new String[] {"소라", "미역", "꽃게" , "문어", "전복"};
			fish_price = new int[]{5,5,5,10,20};
			
			
			
			justnow_catch=  new Seafood[10];  //해녀가 한번 잠수할 때  잡히는 물고기 보관 배열 생성 , user 에서 count 한것만큼 배열크기 만들어줬는데 사실...이게 왜 맞는지 모르겠여...그냥 하다 보니 돌아가더라고
			
			
			
			
		}
		else if( user instanceof Fisher) {
			
			fish_name = new String[] {"연어", "광어", "새우" , "복어", "참치"};
			fish_price = new int[] {20,20,20,50,100};
			fish_resist = new int[] {5,5,5,10,20};
			
			justnow_catch = new Seafood[1];  //어부는 한번에 한개 잡음
			fish_index = ((Fisher) user).fish_index;
		
//		
		}
		block = new ArrayList<Seafood>();  //잡은 물고기 보관하는 배열 리스트
		
		count = new int[5];  //{0.0.0.0.0}
		
		
	}
	
	
	public Fishtank() {
		// TODO Auto-generated constructor stub
	}


	public void getBenefit(Fishtank fishtank) {  //기존 어부의 물고기 창고 들어가
		
		fish_name = new String[] {"연어 ", "광어 ","새우 ", "복어 ","참치 "};
		fish_price = new int[] {40, 40, 40, 100, 200};
		
		block = fishtank.getBlock();
		count = fishtank.getCount();
 		
	}
	
	
	
	

	
	//내가 생성한 메소드//

	//*물고기 팔기 (해산물팔기에서)  
	
	//fisher tank 에서 일어나는 일
	//1)해당 물고기 갯수 빼기
	//2)돈 창고 오르기, 
	//3)총 물고기 갯수 하나 줄이기
	
	//메소드가 받는 매게변수에서 일어나는 일
	//1) 갯수 받은 count 를 0 으로 만들기
	//2) name은 물고기 배열에서 해당 물고기 접근을 위해 인덱스 역할
	public void drawfish(int name , int counts, User user ) //물고기 줄이기( int 물고기 인덱스 번호, int 갯수)

	{

		
	for( int i =0 ; i<block.size() ; i++) {
		
		if( block.get(i).getName().contains(fish_name[name-1])  ) {
			user.getMoneytank().addMoney(block.get(i).getPrice());
			
			
			counts -= 1;
			count[name-1]-=1;
			
			total_fish-=1;
			
			if(counts ==0) {
				break;
			}
		}
	}
		
		
		
		
		
	}
	
	
	//슈퍼어뷰용
		public void addFish(int type,int fish_index, SuperFisher user) { 	
	
	
 		
 		System.out.println(fish_name[fish_index]+ "가 나타났습니다.");
 		System.out.println(fish_name[fish_index]+ "의 저항력은 <"+fish_resist[fish_index] +"> 입니다.");
 		System.out.println();
 		System.out.println();
 		System.out.println();
 		
 		
 		
 		
 		Thread fisher = new Thread(user); //어부 당기기 스레드 생성
 		fisher.start();   //어부 당기기 스레드 시작  
 		
 		FishResistence fish = new FishResistence(fish_index);//물고기가 저항하는 스레드(후발주자)
 		fish.start();
 		 
 	
 		

 		
 		//안하면 어부가 당기고 있는데 바로 물고기 잡혔다고 나옴...
 		try {
			fisher.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		try {
			fish.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		System.out.println();
 		System.out.println();
 		System.out.println();
 		
 		
 	
 		
 		
 		this.block.add(new Seafood(fish_name[fish_index]));  //물고기 잡을거 성공! 
 		
 		this.justnow_catch[now_total_fish] = new Seafood(fish_name[fish_index]);  //임시 배열에 현재 잡은 물고기만 저장 -> 출력용
 		
 		
 		

 		
 		//현재 이게 연어 저항 스레드가 다 나오고 실행되야 되는게 너무 일찍나와
 		System.out.println( "<"+ fish_name[fish_index] +">가 잡혔습니다~!!!!");


 		
 		
 		for(int i =0 ; i<this.now_total_fish+1 ; i++) {
 			System.out.println("<"+ justnow_catch[i].getName()+ ">가 물고기 창고에 추가됩니다.");
		}
 		
 		//dingdong.isLoop(false);
 		
 		
 		
 		
 		
 		this.total_fish++;
 		count[fish_index]++;
 		System.out.println(this);
 		
 		//dingdong.isLoop(false);
 		
 	
 		
 		
 		
 	} 
	
	
	

	
	
	
	//어부용 :물고기 추가하기
 	
	  public void addFish(int type,int fish_index, Fisher user) { 	
	
	
 		
 		System.out.println(fish_name[fish_index]+ "가 나타났습니다.");
 		System.out.println(fish_name[fish_index]+ "의 저항력은 <"+fish_resist[fish_index] +"> 입니다.");
 		System.out.println();
 		System.out.println();
 		System.out.println();
 		
 		
 		
 		
 		Thread fisher = new Thread(user); //어부 당기기 스레드 생성
 		fisher.start();   //어부 당기기 스레드 시작  
 		
 		FishResistence fish = new FishResistence(fish_index);//물고기가 저항하는 스레드(후발주자)
 		fish.start();
 		
 	
 		

 		
 		//안하면 어부가 당기고 있는데 바로 물고기 잡혔다고 나옴...
 		try {
			fisher.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		try {
			fish.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		System.out.println();
 		System.out.println();
 		System.out.println();
 		
 		
 	
 		
 		
 		this.block.add(new Seafood(fish_name[fish_index]));  //물고기 잡을거 성공! 
 		
 		this.justnow_catch[now_total_fish] = new Seafood(fish_name[fish_index]);  //임시 배열에 현재 잡은 물고기만 저장 -> 출력용
 		
 		
 		

 		
 		//현재 이게 연어 저항 스레드가 다 나오고 실행되야 되는게 너무 일찍나와
 		System.out.println( "<"+ fish_name[fish_index] +">가 잡혔습니다~!!!!");


 		
 		
 		for(int i =0 ; i<this.now_total_fish+1 ; i++) {
 			System.out.println("<"+ justnow_catch[i].getName()+ ">가 물고기 창고에 추가됩니다.");
		}
 		
 	
 		ImagePrint ascii = new ImagePrint();
 		
 		ascii.start();
 		
 		try {
			ascii.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		this.total_fish++;
 		count[fish_index]++;
 		System.out.println(this);
 		
 		
 		
 	
 		
 		
 		
 	} 
 	
 	
 	//해녀용 물고기 잡기
 	public Fishtank addFish(int type, User user) {
 		

 		
 		int fish_index = (int)(Math.random()*type);
 		this.block.add(new Seafood(fish_name[fish_index]));
 		
 		this.justnow_catch[now_total_fish] = new Seafood(fish_name[fish_index]);  //임시 배열에 현재 잡은 물고기만 저장 -> 출력용
 	
 		++this.now_total_fish;
 		
 		this.total_fish++;
 		count[fish_index]++;
 		return this;
 		
 		
 		
 	}
 	
 	
 	
 	//물고기 수 0으로 만들기 1)해녀가 도둑 맞을때 2)어부가 해일 만날때
 	 
 	public void cleartank() {
 	
 		this.block = new ArrayList<>();
 		this.setTotal_fish(0);
 		for (int i = 0; i < fish_name.length; i++) {
 			count[i] = 0;
 		}
 	} 
 	
 	
 	
 	

 	
 	//getter
	public int getTotal_fish() { 
		return total_fish;
	}



	public ArrayList<Seafood> getBlock() {
		return block;
	}
	
	
	public int[] getCount() {
		return count;
	}
	
	
	public Seafood[] getJustnow_catch() {
		return justnow_catch;
	}
	
	public int getNow_total_fish() {
		return now_total_fish;
	}
	

	//setter
	
	public void setBlock(ArrayList<Seafood> block) {
		this.block = block;
	}
	
	public void setTotal_fish(int total_fish) {
		this.total_fish = total_fish;
	}


	
	public void setCount(int[] count) {
		this.count = count;
	}

	public void setJustnow_catch(Seafood []  justnow_catch) {
		this.justnow_catch = justnow_catch;
	}
	
	public void setNow_total_fish(int now_total_fish) {
		this.now_total_fish = now_total_fish;
	}
	


//임시 배열에 저장 된것을 출력하기
	public String toString() {
		String str = "" ;
		
		for( int  i =0 ; i < this.now_total_fish ; i++) {
			
			str += "<" + justnow_catch[i].getName()+ "> " ;
			
		}
		
		return str;
	}





}
