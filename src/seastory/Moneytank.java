package seastory;

public class Moneytank {

	private int money; //��â�� ��
	
	//������
	public Moneytank() {
		this.money = 10;
	}
	
	
	
	
	//���� ������ �޼ҵ�//
	

	//������(�ٴٻ�������) (1. ���� �춧, 2 ��ų �춧)
	public void drawmoney(int price) {
			this.money -= price;
		} 
	 
	//*�� â�� 0����� (�ػ깰 ��� ����) ���� ���� ��	
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
