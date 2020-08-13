package seastory;

public class Skill {
	
	
	
	private String name; //스킬 이름
	
	private int price; //가격
	
	private int meter_or_spin; //스킬,미터
	
	
	public Skill(String name , int price , int meter_spin) { 
	
		
		this.name = name;

		this.meter_or_spin = meter_spin;
		
		calculatePrice();
	}


	
	public void calculatePrice() {
		if( name.equals("5m 내려가기")  )
		{
			this.price = 3;
			
		}else if(name.equals("10m 내려가기")) {
			
			this.price = 5;
			
		}else if(name.equals("낚시줄 500번 돌리기")) {
			
			this.price = 25;
			
		}else if(name.equals("낚시줄 1000번 돌리기"))
		
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
