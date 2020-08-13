package seastory;

import java.util.Scanner;

public class Diver extends User {

	boolean skill;
	
	private final int TIMER = 10;
	public Scanner sc;
	
	public Diver(){
		super(); //User  ���� �޼ҵ� �� ȣ�� �⺻ �����ڷ�
		super.setLimit(1);   //setLimit ȣ�� 1�� �ʱ�ȭ
				
	}
	

	//�س��
	public void check_inven(Inventory inven) {
		System.out.println("�κ��丮���� ������ �ִ� ��ų�� Ȯ���� �� ���� �Ҽ� �ֽ��ϴ�.");
		System.out.println(
				"����������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("");
		System.out.println(" 			  (1)��ų Ȯ���ϱ�               (2) ��ų  �����ϱ�");
		System.out.println("");
		System.out.println(
				"����������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		Scanner  sc = new Scanner(System.in);
		
		int a  = sc.nextInt();
		//openShop �������� �� diver���� �ʿ���
		
		if( a== 1) {
			
			System.out.println("��ų Ȯ���ϱ�\n");
			System.out.println("-------------------��ų Ȯ���ϱ�---------------------");
		
			
			for(int i =0 ; i< this.getInventory().skillname.length ; i++ ) {
				
				System.out.println((i+1)+")"+this.getInventory().skillname[i] + " : " + this.getInventory().count[i]  );
				
				}
			
			System.out.println("--------------------------------------------------");
			
			
			
			}else if (a == 2)
			{
			
			System.out.println("��ų Ȯ���ϰ� �����ϱ�\n");
			System.out.println("-------------------��ų Ȯ���ϱ�---------------------");
			for(int i =0 ; i< this.getInventory().skillname.length ; i++ ) {
				
				System.out.println(	(i+1)+")"+this.getInventory().skillname[i] + " : " + this.getInventory().count[i]  );
		
			}
			
			System.out.println("--------------------------------------------------");
			System.out.println();
			
			String line   = sc.nextLine();
			
			System.out.println("������ ��ų�� ��ȣ�� �Է����ּ���.(��ų�� 0�� �� ��� ������ �Ұ��մϴ�)");
			
			int index= sc.nextInt();  //��ų ��ȣ�� �Է¹޾�
			
			//�ش� ��ų item count �� �ϳ� ��������.
			
			
			if( index == 1 ) {   //5m ��������
				
			
					if(getInventory().count[index-1]==0 ) {  //�ش� ��ų item count�� 0 �̸� {0,0}��ų�� �����ϱ� �ٽ� ��� ���� 1m �� ����
						super.setLimit(1);
						System.out.println("<5m ��������>  ��ų�� �����ϼž� ����� �� �ֽ��ϴ�.");
						
					}else {
					
					System.out.println("<5m ��������> �� �����մϴ�.");
					System.out.println("����� ���� [����]�� ���� �� �ִ� ��ȸ�� ������ϴ�.");
					super.setLimit(5);						//��ų�� �����ϸ� �ش� ��ų�� �����ϴ�  limit�� 5�� �ٲ��ְ�
					this.getInventory().count[index-1 ]--;	//�ش� ��ų item count �� �ϳ� ��������. ex){1,0}->{0,0}
					
					}
					
					
			}else if( index == 2 ) {

				
				if(getInventory().count[index -1] == 0) {     //�ش� ��ų item count�� 0 �̸� {0,0}��ų�� �����ϱ� �ٽ� ��� ���� 1m �� ����
					super.setLimit(1);
					System.out.println("<10m ��������> ��ų�� �����ϼž� ����� �� �ֽ��ϴ�.");
				}else {
				
			System.out.println("<10m ��������> �� �����մϴ�.");
			System.out.println("����� ���� [����]�� ���� �� �ִ� ��ȸ�� ������ϴ�.");
			super.setLimit(10);								//��ų�� �����ϸ� �ش� ��ų�� �����ϴ�  limit�� 10�� �ٲ��ְ�
			this.getInventory().count[index-1]--;			//�ش� ��ų item count �� �ϳ� ��������. ex){0,1}->{0,0}
			
			
						}
					}
			
			
				}
			}
			
			
			
			
			
		
			

	
	//��ų���(�ٴ� ����)
	public void buy_skill(OceanShop shop) {
		shop.show_skill_diver(this);  // ���� Diver�� ������ ��
	}
	
	// �س� ���ϸ�����
	//user meet_thief()�������̵�
	public void meet_thief() {      
		boolean win = super.playrockpapaerscissor();
		if (win) {
			System.out.println();
			System.out.println("������������ �̰���ϴ�!");
			System.out.println();
			this.getMoneytank().addMoney(30);
			System.out.println("�س� ���Ͽ��� 30������ ȹ���� �� "+ this.getMoneytank().getmoney()+" ������ �Ǽ̽��ϴ�~\n"); //�� �� ���� ������
			System.out.println();
		} else {
			System.out.println();
			System.out.println("������������ �����ϴ�.");
			System.out.println();
			this.getFishtank().cleartank();
			System.out.println("����� â�� 0 �� �Ǿ����ϴ�.�ٽ� ������ ����⸦ ����ּ���.");
			System.out.println();
		}
	} 
	
	
	//Overriding
	//user catch_seafood()�������̵�
	//2)����� ���
	public void catch_seafood() { //dive_depth�� limit
	
		//Music oceansound = new Music("Water Sound.mp3",true);
		
		
		
		
		
		Fishtank currentFishtank = null; //1round�� ���� ����� 
		
		
		this.alarm_strength();
		
		if (super.getStrength() <= 0) {
			System.out.println("ü���� �����մϴ�. ���ӿ� �����ϼ̽��ϴ�.");
			System.exit(0);
		}
		
		int dive_depth = super.getLimit();   // �⺻1m ���
		
		int term; //= (int)(Math.random()*20) + 1; // ����⸦ ��� ���� �ð� 
		int type;  //��� ����⸦ ��������
		
		switch(dive_depth) { //
		
		case 1:  	 	//1m����϶�  type=3���� 5���� 3��(index)���� �޾���
			type = 3; 
			break;
		case 5:			//5m����϶�  type=4���� 5���� 4��(index)���� �޾���
			type = 4;
			break;
		case 10:		//10m����϶�  type=5���� 5���� 5��(index)���� �޾���
			type = 5;
			break;
		default:
			type =3;
			break;
			
		}
		
		//�س� ����� â�� ����� ������ֱ�
		for(int i =0 ; i <= TIMER ; i+= term) {  //10�� ���� ������ �ʸ� �������ؼ�
			
			
			
			currentFishtank = this.getFishtank().addFish(type, this);
			
			System.out.println();
			System.out.println();
			term =(int)(Math.random()*5)+1;
			this.count++;  //�سడ ����⿡ ����⸦ 10�� ������
			if (this.count % 10 == 0 && this.count != 0 ) { //����⸦ 10������ �ѹ� ��ų� 0�� �̻� �϶�
				System.out.println("���! ���� �سడ ��Ÿ�����ϴ�!\n");
				System.out.println("�������������� �̱�� �� 30������ ȹ���ϰ�,");
				System.out.println("�������������� ���� ����⸦ �� �Ұ� �˴ϴ�.");
				meet_thief( );
			}
			
			
		}
		//this.strength -= 10; //user�� ü�� ����Ʈ��
		
		System.out.println("�ػ깰�� "+ currentFishtank.getNow_total_fish() + "�� �������ϴ�.");
		System.out.println(currentFishtank);
		currentFishtank.setNow_total_fish(0);
		currentFishtank.setJustnow_catch(new Seafood[10]);
		super.setLimit(1);
	}
	
	
	//Overriding diver��(�س��)
	public void check_fishandmoney() {
	
			
			System.out.println("-------------------------------����� â��---------------------------");
			System.out.println(" �� �ػ깰 ����: " + super.getFishtank().getTotal_fish() +"��");
			System.out.println();
			
			for(int i=0 ; i< 5; i++) {
				
				System.out.println( super.getFishtank().fish_name[i]+ ": "+ getFishtank().count[i]+ "��");
			
			
			}
			
			System.out.println("------------------------------------------------------------------");
			System.out.println();
			
		}
		
		
}
		

	
	
	
	
	
	
	
	
	
		
	



