package seastory;

public class Food {

	private int price; //��������
	private String name; //���� �̸�
	private int strength; //������ �ִ� ü��
	
	public Food(String name, int price, int strength) {  // ���� �����ϴ� ������
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
