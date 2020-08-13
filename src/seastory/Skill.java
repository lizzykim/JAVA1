package seastory;

public class Skill {
	
	
	
	private String name; //��ų �̸�
	
	private int price; //����
	
	private int meter_or_spin; //��ų,����
	
	
	public Skill(String name , int price , int meter_spin) { 
	
		
		this.name = name;

		this.meter_or_spin = meter_spin;
		
		calculatePrice();
	}


	
	public void calculatePrice() {
		if( name.equals("5m ��������")  )
		{
			this.price = 3;
			
		}else if(name.equals("10m ��������")) {
			
			this.price = 5;
			
		}else if(name.equals("������ 500�� ������")) {
			
			this.price = 25;
			
		}else if(name.equals("������ 1000�� ������"))
		
			this.price = 50;
	}

	

	public String getName() {
		return name;
	}


	public int getPrice() {
		return price;
	}


	public int getMeterorSpin() {
		return meter_or_spin;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public void setMeterorSpin(int meter_spin) {
		this.meter_or_spin = meter_spin;
	}
	
	
	
	
	
	
	
	
}
