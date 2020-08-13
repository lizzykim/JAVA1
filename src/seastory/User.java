package seastory;

import java.util.Scanner;

public class User {
	
	//Music music;//�������
	
	public Scanner sc;
	protected int strength; //�سʴ� ����� Ƚ������, ��δ� ��⳵�� Ȼ�� �ö� ����
	
	protected int count; //�س�� ����� ���� �� or ��δ� ����� ������ ����
	
	private int limit;	//fisher�� �� rolling_Rod(���ô� ������ Ƚ��), diver�� �� depth(����)
	
	
	
	//moneytank ��â�� ���۷���
	private Moneytank moneytank;
	
	//inventory�κ� ���۷���	
	private Inventory inventory;
	
	//Fishtank �����â�� ���۷���	
	private Fishtank fishtank;
	
	
	
	
	
	//user������
	public User() { //�سฦ �������ָ�  �� �޼ҵ�� �� �ǵ���� �ٲ��شٴ� ��
		this.strength =100;
		this.count = 0;
		this.moneytank = new Moneytank();
		this.inventory = new Inventory(this);
		/*
		 * Fishtank�� ������ Diver���� Fisher���� �Ǻ��ϰ� �ϱ� ����
		 * User �ڱ� �ڽ��� �Ѱ��� (�� ��, User�� Diver�� Fisher�� Ưȭ�Ǿ� ����)
		 */
		this.fishtank = new Fishtank(this);
		this.sc = new Scanner(System.in);
	}
	
	
	
	public User( User user) {				//���� ����ϴ� ����� ��â��,�����â��,�κ��丮�� ����
		this.strength = user.strength;		//���� ����� ü��
		this.count = user.count;					//���� ��ΰ� ����⸦ ���� Ƚ��
		this.moneytank = user.getMoneytank();		//���� ����� ��â�� ����
		this.inventory = user.getInventory();		//���� ����� �κ��丮����
		
		this.fishtank = user.getFishtank();
		this.sc = new Scanner(System.in);
	}
	
	
	
	//���� ������ �޼ҵ�//

	//action :user ��  ���� ��� -> oceanshop���� show_foodȣ�� 
	public void buy_food(OceanShop shop){
		shop.show_food(this);  //this�� �Ѱ��ִ� �Ŵ� user�� �س����� ������� �Ѱ��ַ���
	} 

	
	
	//Diver�� Fisher���� ����
	public void buy_skill(OceanShop shop) {

	}
	//��ų���
	
	
	//action: �κ��丮 Ȯ���ϱ�
	//diver, fisher���� ����
	public void check_inven(Inventory inven) {
		
	}
	
	//����� ���
	//diver, fisher���� ����
	//abstract�� �ٲܼ� �ִ��� ���߿� Ȯ���غ���
	public void catch_seafood() {
		
	}
	
	
	
	
	
	//public void sell_seafood() {
	public void sell_seafood(User user) {
	
	
		System.out.println("----------------------------���� ���� ����� Ȯ���ϱ�---------------------------");
		System.out.println(" �� �ػ깰 ����: " + getFishtank().getTotal_fish() +"��");
		System.out.println();
		
		for(int i=0 ; i< 5; i++) {
			
			System.out.println( getFishtank().fish_name[i]+ ": "+ getFishtank().count[i]+ "��");
		
		
		}
		
		System.out.println("--------------------------------------------------------------------------");
		System.out.println();
		
		//String a = sc.nextLine();
		
		
	
		//��� �س�� //���۾�ο� �ػ깰 �Ǹ� ���� �ٸ��� �߰�
		
		if(this instanceof SuperFisher) {
		 System.out.println("������������������������������������������������������������������������������������������������������ ��ο� �ػ깰 �Ǹ� ���ݦ���������������������������������������������������������������������������������������������������������");
			 
		}else {
		
		 System.out.println("�������������������������������������������������������������������������������������������������������������ػ깰 �Ǹ� ���ݦ���������������������������������������������������������������������������������������������������������������");
		}
		System.out.println();
		
		for(int i =0 ; i<5 ; i++) {
				
			System.out.print("\t"+(i+1)+")" + getFishtank().fish_name[i]+ ": "+ getFishtank().fish_price[i]+ "����              " );
				
		}
		
		System.out.println();
		System.out.println();
		System.out.println("����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("�Ǹ��� �ػ깰�� ��ȣ�� �Է����ּ���.");
		int sell_name= sc.nextInt();  //�Ǹ��� �ػ깰�� ��ȣ ex) 1�̸� �Ҷ�
		
		
		System.out.println("�Ǹ��� ������ �Է����ּ���.");
		int sell_count= sc.nextInt();	//�Ǹ��� ���� ex)1�̸� 1����
		
		
		if(sell_count>this.getFishtank().count[sell_name-1]  ) {
			System.out.println("�ش� �ػ깰�� �������� �ʽ��ϴ�!!");
		}else {
		
		
		getFishtank().drawfish( sell_name , sell_count, this );  //�Ǹ� �ػ깰 ��ȣ, �Ǹ��� ���� �Ѱ�, Fishtank�� user ��� �Ѱ���
		System.out.println();
		System.out.println( this.fishtank.fish_name[sell_name-1] + " ��(��) " + sell_count + "�� �ȷȽ��ϴ�." );
		this.getMoneytank().getmoney();
		
		System.out.println();
		}
		
		
	}
	
	
	//diver�̶� fisher�� overriding
	public void check_fishandmoney() {

	}
	
	
	//�س� ��� overriding
	public boolean playrockpapaerscissor() {
		//�����������ϴ� ��
		boolean flag = false;	//�ºθ� �ô��� �� �ô���
		boolean win = false;	//������ ���� false
		
		
		String a = sc.nextLine();

		 System.out.println("play)  0: ����            1: ����             2:��      ");
		 System.out.println();
		
		while (!flag) {  //true�϶� ����
			System.out.print("��ȣ�� �Է����ּ��� ");
			int computer = (int) (Math.random() * 3);
			int me = sc.nextInt();
			switch (me) {
			case 0:   //����
				if (computer == 0) { //����
					System.out.println("�����ϴ�. �ٽ� �ϼ���.");
					continue;
				} else {
					if (computer == 1) //����
						
						{
						win = false;  //������ ��
						}
					else if(computer ==2) { //��
						win = true;  //������ �̱�
					}
					flag = true; //���������� ���
				}
				break;
			case 1: //user ����
				if (computer == 1) {  //����
					System.out.println("�����ϴ�. �ٽ� �ϼ���.");
					continue;
				} else {	
					if (computer == 0) { //����
						win = true;  //������ �̱�
					}
					else if(computer == 2) { //��
						win = false; //������ ��
					}
					flag = true;  //���Ƽ�
				}
				break;
			case 2: //user ��
				if (computer == 2) {  //��
					System.out.println("�����ϴ�. �ٽ� �ϼ���.");
					continue;
				} else {
					if (computer == 0) { //����
						win = false; //������ 
						}
					else if (computer ==1) { //����
						win = true; //������ �̱�
					}
					flag = true;
				}
				break;
			default: System.out.println("�߸� �½��ϴ�. �ٽ� �ϼ���. ");
			}
		}
		if (win) 
			return true;  //������ �̱�� true
		else 
			return false; //������ ���� false����
	}
	
	
	
	
	
	//showfood ���� �� ������ ü���� �Ѱ� �޾Ƽ� �÷�
	public void addstrength(int strength) {
		this.strength += strength;
	}
	
	
	public void alarm_strength() {  //ü�� 20���� �ϋ� ��� ǥ��
		
		if(this.strength == 20) {
			System.out.println(" ------------------------------ü�� ���� ���----------------------------------");
			System.out.println();
			System.out.println("                 ü���� 20�Դϴ�!! �������� ü���� �������ּ���!!");
			System.out.println();
			System.out.println(" --------------------------------------------------------------------------");
			System.out.println();
		}

	}
	
	
	public void alarm_money() {  //���� 0 �϶� ��� ǥ��
		 if(this.getMoneytank().getmoney() == 0) {
			 	System.out.println(" ------------------------------�ܾ� ���� ----------------------------------");
				System.out.println();
				System.out.println("                 ���� 0�Դϴ�!! �� ���� �����ּ���.");
				System.out.println();
				System.out.println(" ------------------------------------------------------------------------");
				System.out.println();
		 }
	}

	public void game_clear() {
		
		if(this.getMoneytank().getmoney() >= 300){
			System.out.println(" ------------------------------���� ����--------------------------------");
			System.out.println();
			System.out.println("                 ��ǥ �ݾ� 300 ������ �� ��ҽ��ϴ�~!");
			System.out.println();
			System.out.println(" ---------------------------------------------------------------------");
			System.out.println();
			
			System.exit(0);
		}		
	}
	
	
	
	
	
	//setter&getter	
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	public int getStrength() {
		return strength;
	}

	public int getCount() { //����
		return count;
	}

	public Moneytank getMoneytank() {
		return moneytank;
	}


	public Inventory getInventory() {
		return inventory;
	}
	
	public Fishtank getFishtank() {
		return fishtank;
	}



	public void setStrength(int strength) {
		this.strength = strength;
	}



	public void setCount(int count) { 
		this.count = count;
	}


	public void setMoneytank(Moneytank moneytank) {
		this.moneytank = moneytank;
	}


	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void setFishtank(Fishtank fishtank) {
		this.fishtank = fishtank;
	}
	
//	public void setStrengthminusone(int strength) {
//		this.strength -=strength;
//	}
//	
}
