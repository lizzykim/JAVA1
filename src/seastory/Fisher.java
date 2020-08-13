//����:297�� �ٿ� setStrength�� ü�� -1���� ������ �������ִµ� menu�޼ҵ忡�� ���� ���°� ���� �� 100���� �ٽ� ���õ�

package seastory;

import java.util.Scanner;

public class Fisher extends User implements Runnable{
	

	int fish_index;
	public boolean stop = false; //�������� �������
	public boolean work = true;  //yeid f�� ȣ���� ������ �˱� ����

	
	public Fisher() {
		
		super();
		super.setLimit(100);
	
	}
	
	
	public Fisher(User user) {
		
		super(user);
		super.setLimit(user.getLimit());
	}

	
	//���ϸ�����: ����� â�� 0 �̵�
	public void meet_hail() {
		super.getFishtank().cleartank();
		System.out.println("����� â�� 0 �� �Ǿ����ϴ�.�ٽ� ������ ����⸦ ��������.");
		System.out.println();
	}
	
	
	
	//��ο� 
	public void check_inven(Inventory inven) {
	
	System.out.println("�κ��丮���� ������ �ִ� ��ų�� Ȯ���ϰ� ���� �Ҽ� �ֽ��ϴ�.");
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
			
			System.out.println(	(i+1) + ") "+this.getInventory().skillname[i] + " : " + this.getInventory().count[i]  );
			
			}
		
		System.out.println("--------------------------------------------------");
		
		
		}else if (a == 2)
		{
	
	
			System.out.println("��ų Ȯ���ϰ� �����ϱ�\n");
			System.out.println("-------------------��ų Ȯ���ϱ�---------------------");
			for(int i =0 ; i< this.getInventory().skillname.length ; i++ ) {
				
				System.out.println(	(i+1) + ") "+this.getInventory().skillname[i] + " : " + this.getInventory().count[i]  );
		
			}
			
			System.out.println("--------------------------------------------------");
			System.out.println();
			
			String line   = sc.nextLine();
			
			System.out.println("������ ��ų�� ��ȣ�� �Է����ּ���.(��ų�� 0�� �� ��� ������ �Ұ��մϴ�)");
			
			int index= sc.nextInt();  //��ų ��ȣ�� �Է¹޾�
			
			//�ش� ��ų item count �� �ϳ� ��������.
			
			if( index == 1 ) {   //������ 500�� ������
	
				if(getInventory().count[index-1]==0 ) {  //�ش� ��ų item count�� 0 �̸� {0,0}��ų�� �����ϱ� �ٽ� ���ô� 100�� ������ �� ����
					super.setLimit(100);
					System.out.println("<������100�� ������> ��ų�� �����ϼž� ����� �� �ֽ��ϴ�.");
					
					}else {
					
					System.out.println("<������ 500��> ������ �� �����մϴ�.");
				    System.out.println("����� ���� [����]�� ���� �� �ִ� ��ȸ�� ������ϴ�.");
				    super.setLimit(500);						//��ų�� �����ϸ� �ش� ��ų�� �����ϴ�  limit�� 5�� �ٲ��ְ�
				    this.getInventory().count[index-1 ]--;	//�ش� ��ų item count �� �ϳ� ��������. ex){1,0}->{0,0}
				
				}
				
			}else if( index == 2) {	//������ 1000�� ������
				
				if(getInventory().count[index -1] == 0) { //�ش� ��ų item count�� 0 �̸� {0,0}��ų�� �����ϱ� �ٽ� ���ô� 100�� ������ �� ����
					super.setLimit(100);
					System.out.println("<������500�� ������> ��ų�� �����ϼž� ����� �� �ֽ��ϴ�.");
					}else {
				
					System.out.println("<������ 1000�� ������> �� �����մϴ�.");
					System.out.println("����� ���� [��ġ]�� ���� �� �ִ� ��ȸ�� ������ϴ�.");
					super.setLimit(1000);								//��ų�� �����ϸ� �ش� ��ų�� �����ϴ�  limit�� 10�� �ٲ��ְ�
					this.getInventory().count[index-1]--;			//�ش� ��ų item count �� �ϳ� ��������. ex){0,1}->{0,0}
				
					}
				
			}
		}
			
	
	
	
	
	
	
	
	}


	
	public void buy_skill(OceanShop shop) {
		shop.show_skill_fisher(this);
	}
	
	
	
	
	
	//���� ������,�����������ϱ�
	public void meet_pirate() {
		boolean win = super.playrockpapaerscissor();
		if(win) {
			System.out.println();
			System.out.println("������������ �̰���ϴ�!");
			System.out.println();
			this.getMoneytank().addMoney(20);
			System.out.println("�������� 20������ ȹ���� �� "+ this.getMoneytank().getmoney()+" ������ �Ǽ̽��ϴ�~\n"); //�� 20 ����
		}else {
			System.out.println();
			System.out.println("������������ �����ϴ�.");
			System.out.println();
			this.getMoneytank().clearmoney();
			System.out.println("�� â�� 0 �� �Ǿ����ϴ�.�ٽ� ������ ����⸦ ��� �ȾƼ� ���� ��������.");
			System.out.println();
		}
		
	} 
	
	
	
	//2)����� ���
	public void catch_seafood() {
		

		
		this.alarm_strength();
		
		if (super.getStrength() <= 0) {
			
			System.out.println(" ------------------------------���� ����----------------------------------");
			System.out.println();
			System.out.println("ü���� �����մϴ�. ���ӿ� �����ϼ̽��ϴ�.");
			System.out.println();
			System.out.println(" --------------------------------------------------------------------------");
			System.exit(0);
		}
		
		int spin_rod = super.getLimit();  //�⺻ ������ 100�� ������
		
		int type; //��� ����⸦ ��������
		
		switch(spin_rod) {   
			
		case 100:
			type = 3;
			break; 
		case 500:
			type = 4;
			break;
		case 1000:
			type = 5;
			break;
		default:
			type =3;
			break;
		
		}
		
		fish_index = (int)(Math.random()*type);//������ ����� �ε�����
		
		FishWait move = new FishWait();  
		move.start();  //���� ����
		
		synchronized(move) {
			
			try {
				move.wait();  //main��  move������ ���������� ����?
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		
		this.getFishtank().addFish(type,fish_index,this);
		
		

		System.out.println();
		System.out.println();
		this.count++; //��ΰ� ����� ���� Ƚ��
		
		
		
		
		
		if (this.count % 8 == 0 && this.count != 0 ) { //����⸦3������ �ѹ� ��ų� 0�� �̻� �϶�
			
			System.out.println("���! ������ ��Ÿ�����ϴ�!");
			System.out.println("�������������� �̱�� �� 20������ ȹ���ϰ�,");
			System.out.println("�������������� ���� ���� �� �Ұ� �˴ϴ�.");
			meet_pirate();		//��������������� ���� +30���� or �� â�� 0
			
		}else if(this.count % 5 ==0 ) {
			
			System.out.println("���! ������ ���ƽ��ϴ�!"); 
			meet_hail();
			
		}
		

		
		
		
		
		
		
		
		
		//this.strength-=10;
		super.setLimit(100);
		
		
	} 
	
	
	//��ο�  ��,����� â�� Ȯ���ϱ�
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

	//��� ü�±��̴� �޼ҵ�
	
	
	public synchronized void pull_fish() {
		
		
		
		for(int i =0 ; i< this.getFishtank().fish_resist[fish_index];i++) {
		
		

		this.setStrength(super.strength-1);//����� ü���� �������� 1���ְ� �����Ѱɷ� �ٽ� ����
		System.out.println("��ΰ� ���ô븦 ���ϴ�(���� ü��: "+ super.getStrength()+")"   );

//		notify();
		try {
				Thread.sleep(500);
//			wait(); //��� �����彬��
		} catch (InterruptedException e) {}
			
		}

	}
	
	
	
	//ü���� ����
	@Override
	public  void run() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}
		
			pull_fish();
			
	}
	

	
	
	
	
	
}
