package seastory;

public class Moneytank {

	private int money; //돈창고 돈
	
	//생성자
	public Moneytank() {
		this.money = 10;
	}
	
	
	
	
	//내가 생성한 메소드//
	

	//돈빼기(바다상점에서) (1. 새참 살때, 2 스킬 살때)
	public void drawmoney(int price) {
			this.money -= price;
		} 
	 
	//*돈 창고 0만들기 (해산물 잡기 에서) 해적 만날 떄	
	public void clearmoney() {
		this.money=0;
	} 
		
		
	
	
	
	public void addMoney(int money) {
		this.money += money;
	}
	
	
	
	//setter&getter
	public void setmoney() {}
	
	
	public int getmoney() {
		return money;
	}
	
	
	
	public void doubleMoney(int money) {
		this.money = money *2;
	}
	
	
	
	
}
