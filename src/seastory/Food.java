package seastory;

public class Food {

	private int price; //새참가격
	private String name; //음식 이름
	private int strength; //음식이 주는 체력
	
	public Food(String name, int price, int strength) {  // 새참 생성하는 생성자
		this.name = name;
		this.price = price;
		this.strength = strength;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	

}
