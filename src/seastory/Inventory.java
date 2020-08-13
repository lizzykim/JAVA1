package seastory;

public class Inventory {
	

 
	 
	 protected Skill [] block;  // 전체 아이템 놔주는 블록 , (이름, 가격, 스킬미터)
		
	 protected String[] skillname; //스킬이름 적기
	 
	 protected int[] count; //현존하는 갯수 확인 {0,0}
	 
	 protected int totalCount;  //스킬의 전체 갯수  
	 
	 
	 
	 public Inventory(User user) {
		 
		 if(user instanceof Diver) {
			 skillname = new String[]{ "5m 내려가기" ,"10m 내려가기" };
		 }else if(user instanceof Fisher) {
			 skillname = new String[]{ "낚시줄 500번 돌리기" ,"낚시줄 1000번  돌리기" };
		 }
		 
		 this.block = new Skill [20];
	
		 this.count = new int[2];    
		 
	 }
	 
	 
	 
	 public void addInventory(Skill skill) {  //skill을 블록에 저장해줘
		 this.block[totalCount++] = skill;
	 }
	 

}
