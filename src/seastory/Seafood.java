package seastory;

public class Seafood {
	

	
	private int price; //�ػ깰 ����

	private String name; //���� ������ �ػ깰 �̸� ex) ���� random �ؿ� �ε����� �����ؼ� ������ذ�
	
	//������
	public Seafood(String name) {
		this.name = name;
		
		calculatePrice(); //�̰� 
	}
	
	
	
	
	//�ػ깰 ���� ������ֱ�
	public void calculatePrice() {
		if (name.equals("�Ҷ�") || name.equals("�̿�")|| name.equals("�ɰ�")) {
			this.price = 5;
		} else if(name.equals("����") ){
			this.price = 10;
		} else if(name.equals("����") || name.equals("����")|| name.equals("����")||  name.equals("����")) {
			this.price = 20;
		}else if(name.equals("����")) {
			this.price = 50;
		}else if( name.equals("��ġ")) {
			this.price = 100;
		}
		
		//SuperFisher����//
		
		else if(name.equals("���� ") || name.equals("���� ") || name.equals("���� ")) {
			this.price = 40;
		}else if(name.equals("���� ")) {
			this.price = 100;
		}else if(name.equals("��ġ ")) {
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
		
