package seastory;

import java.util.Scanner;

public class OceanShop {
	private Scanner sc;
	
	
	
	private String [] food_name; // ���� �����ٹ迭
	private int[] food_price;	 //���� ���� ���� �迭
	private int[] food_strength;  //������ �ִ� ä�� ���� �迭
	
	public String [] skills_diver_name; //�س� ��ų������ �迭
	public int[] skills_diver_price;  //�سེų ����
	public int[] skills_diver_meter;  //�س� ��ų ����
	
	
	public String [] skills_fisher_name; //��� ��ų ������ �迭
	public int[] skills_fisher_price;  //��ν�ų ����
	public int[] skills_fisher_spin;  //��� ��ų ����
	
	
	//������
	public OceanShop() {
		//����(����)
		this.food_name = new String[]{"����", "������", "�Ŷ��", "�Ѷ��", "���ޱⶱ", "ȫ��"};
		this.food_price = new int[] {1, 1, 1, 1, 2, 3}; //����
		this.food_strength = new int[] {30, 30, 30, 30, 70, 100}; //�ִ� ü��
		this.sc = new Scanner(System.in);
		
		this.skills_diver_name = new String[] {"5m ��������", "10m ��������"};
		this.skills_diver_price = new int [] {3,5}; //����
		this.skills_diver_meter = new int [] {5,10}; //�ִ� ���� ����
		
		this.skills_fisher_name = new String[] {"������ 500�� ������" , "������ 1000�� ������"};
		this.skills_fisher_price = new int[] {25,50};
		this.skills_fisher_spin = new int[] {500,1000};
		
	}
	
	
	
	//��ų���� ���� ���� ����
	public int choice_skill_food() { 
		
		System.out.println(
				"����������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("");
		System.out.print("            (1)���� ���               (2)��ų ��� ");
		System.out.println();
		System.out.println("");
		System.out.println(
				"����������������������������������������������������������������������������������������������������������������������������������������������");
//		Loading loading = new Loading("��ȣ�� �����ϼ���.");
//		loading.start();
		System.out.print(" ��ȣ�� �����ϼ���. ");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt() ;
		
		if(choice == 1) {
			return 1;
		}else if(choice == 2){
			return 2;
		}
		return 0;
	}
	
	
	
		//action:���� �����ֱ�,���� �Է� �ޱ�,ü�� �÷�->user�� addStrengthȣ��, �� ���->
		// ��ȯ �Ǵ� int strenght�� �÷�
		
	public void show_food(User user) {                  //���λ��� �ϸ� �ȵǴ� ���� �춧 ���� user �� �����ָ� user�� ���� �춧 ����,ü�� ��ȭ�� ���� �׳� �״뷯��
		//System.out.println("�����Դϴ�");
		System.out.println("------------------ ����----------------------");
		for (int i = 0; i < food_name.length; i++) {
			
			System.out.println((i+1) + ") " + food_name[i] + 
					", " + food_price[i] + "����, ü�� ���� : " + food_strength[i]);
			
			
		}
		System.out.println("------------------------------------------");	
		System.out.println();
		
		System.out.println("���� ��ȣ�� �����ϼ���. ");
		int choice = sc.nextInt() - 1; //choice 0: ����      1:������   2:�Ŷ��    3:�Ѷ��  4:���ޱⶱ  5:ȫ�� 
		
		System.out.println();
		System.out.println();
		
		Food food = new Food(food_name[choice], food_price[choice], food_strength[choice]);  //����  ��ü ����~~~
		
		
		//���� �ش� ���� ���ݺ��� ��â�� ���� ���ٸ� ���� ���ٴ� ������ ����ְ� ����������!
		if(food_price[choice] > user.getMoneytank().getmoney()    ) {  //���� ������ ���� �� ��â�� ���� ������ Ŭ��
			 
		 	System.out.println(" ------------------------------�ܾ� ����----------------------------------");
			System.out.println();
			System.out.println("                 ���� �����մϴ�. ����⸦ �ȾƼ� ���� ������.");
			System.out.println();
			System.out.println(" -----------------------------------------------------------------------");
			System.out.println();
			
			}else {
		 
	 		System.out.println("<"+food_name[choice] +">"+ "�� �����ϼ̽��ϴ�.\n\n ");
		
	 		user.addstrength(food.getStrength()); //food��ü�� Strength��ŭ addstrength�� �Ѱ���
	 		user.getMoneytank().drawmoney(food.getPrice()); //food��ü price��ŭ drawmoney�� �Ѱ���
		
	 
	 			}
	} 
	
	
	
	
	
	
	
	//�سེų �����ֱ�
	//1)�� ���
	//2)�κ��丮�� ��ų ���� �÷�
	public void show_skill_diver (User user) {
		
		System.out.println();
		System.out.println();
		System.out.println("------------------ ��ų----------------------");
		for (int i = 0; i < skills_diver_name.length; i++) {

			System.out.println((i+1) + ") " + skills_diver_name[i] + 
					", " + skills_diver_price[i] + "����" );
		}
		System.out.println("--------------------------------------------");	
		System.out.println();
		
		System.out.println("��ų ��ȣ�� �����ϼ���. ");
	
		
		int choice = sc.nextInt() - 1;
		
		System.out.println();
		System.out.println();
		
		//Skill Ŭ������ ��ü ����
		Skill skill = new Skill(skills_diver_name[choice], skills_diver_price[choice], skills_diver_meter[choice]);  //�س� ��ų ��ü ����~!
		
		if(skills_diver_price[choice] > user.getMoneytank().getmoney()    ) { //�س� ��ų ������ ���� �� ��â�� ���� ������ Ŭ��
			
			System.out.println(" ------------------------------�ܾ� ����----------------------------------");
			System.out.println();
			System.out.println("                 ���� �����մϴ�. ����⸦ �ȾƼ� ���� ������.");
			System.out.println();
			System.out.println(" -----------------------------------------------------------------------");
			System.out.println();	
			
		}else {
		
			
		user.getMoneytank().drawmoney(skill.getPrice()); // �� â�� �� ���
		user.getInventory().addInventory(skill);		 // skill ��Ͽ� �߰� {"5m " ,"10m" ,"10m" ,"10".....}
		user.getInventory().count[choice]++ ;			 //�ش� ��ų�� ��� inventory��  �ش� count ���ڵ� �÷���ߵ� {0,0 }-> {0,1}
														 //choice�� 0�� ���� inven �� count �迭���� choice�ε��� ������ +1 ����ߵ�
		
		System.out.println("<"+skills_diver_name[choice] +">"+ "(��)�� �����ϼ̽��ϴ�. ");
		
		}
	} 
	
	
	
	
	
	
	
	
	
	
	 //��� ��ų�����ֱ�
	//<��� �ȵǴ°�>
	//1.��ų ��� ���� �ٴ°� �ȵ�
	//2. ��ų��� �� ��ų ���� �þ�°� �ȵ�
	//3. �κ��丮�� ��ų �߰� �Ǵ� �� �ȵ�
	public void show_skill_fisher(User user) {
		System.out.println();
		System.out.println();
		System.out.println("------------------ ��ų----------------------");
		for (int i = 0; i < skills_fisher_name.length; i++) {

			System.out.println((i+1) + ") " + skills_fisher_name[i] + 
					", " + skills_fisher_price[i] + "����" );
		}
		System.out.println("------------------------------------------");	
		System.out.println();
		
		System.out.println("��ų ��ȣ�� �����ϼ���. ");
		
		int choice = sc.nextInt() - 1;
		
		System.out.println();
		System.out.println();
		
//		if(choice !=0 || choice != 1){
//			System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�. ");	
//		}else {
		
		Skill skill = new Skill(skills_fisher_name[choice], skills_fisher_price[choice], skills_fisher_spin[choice]);  // ��� ��ų ��ü ����~!
		
		
		if( skills_fisher_price[choice] > user.getMoneytank().getmoney()    ) { //�س� ��ų ������ ���� �� ��â�� ���� ������ Ŭ��
			
			System.out.println(" ------------------------------�ܾ� ����----------------------------------");
			System.out.println();
			System.out.println("                 ���� �����մϴ�. ����⸦ �ȾƼ� ���� ������.");
			System.out.println();
			System.out.println(" -----------------------------------------------------------------------");
			System.out.println();	
			
		}
		else {
		
		user.getMoneytank().drawmoney(skill.getPrice()); // �� â�� �� ���
		user.getInventory().addInventory(skill);		 // skill ��Ͽ� �߰� {"500�� " ,"500m" ,"1000��" ,"500��".....}
		user.getInventory().count[choice]++ ;			 //�ش� ��ų�� ��� inventory��  �ش� count ���ڵ� �÷���ߵ� {0,0 }-> {0,1}
														 //choice�� 0�� ���� inven �� count �迭���� choice�ε��� ������ +1 ����ߵ�
		
		System.out.println("<"+skills_fisher_name[choice] +">" +"(��)�� �����ϼ̽��ϴ�. ");

		}
		}
	} 
	
 	
	
	
//}
