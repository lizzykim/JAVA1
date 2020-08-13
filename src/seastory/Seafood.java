package seastory;

public class Seafood {
	

	
	private int price; //해산물 가격

	private String name; //내가 생성한 해산물 이름 ex) 연어 random 밑에 인덱스로 접근해서 집어놔준거
	
	//생성자
	public Seafood(String name) {
		this.name = name;
		
		calculatePrice(); //이건 
	}
	
	
	
	
	//해산물 가격 계산해주기
	public void calculatePrice() {
		if (name.equals("소라") || name.equals("미역")|| name.equals("꽃게")) {
			this.price = 5;
		} else if(name.equals("문어") ){
			this.price = 10;
		} else if(name.equals("전복") || name.equals("연어")|| name.equals("광어")||  name.equals("새우")) {
			this.price = 20;
		}else if(name.equals("복어")) {
			this.price = 50;
		}else if( name.equals("참치")) {
			this.price = 100;
		}
		
		//SuperFisher전용//
		
		else if(name.equals("연어 ") || name.equals("광어 ") || name.equals("새우 ")) {
			this.price = 40;
		}else if(name.equals("복어 ")) {
			this.price = 100;
		}else if(name.equals("참치 ")) {
			this.price = 200;
		}
		
	}

	

	
	
	
	//getter&setter
	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	

	

}
		
