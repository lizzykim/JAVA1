//����: 120���� , ü���� �������µ� user���� �����ڷ� �ʱ�ȭ �� 100�� �����ϴ� �Ͱ���
package seastory;


import java.util.Scanner;



public class GameMain0 { //shop�� �������� ���ڸ��� �־�ߵ� �׶����� ���� ����� �̻����ݾ� �׷��� �ƿ� ����� �����ž� 
	
	private User user;
	
	private OceanShop shop;
	private Inventory inven;
	
	private boolean superfisherFlag = false;  //����ڰ� fisher�̰� ���� 100 �̻����� Ȯ���ϴ� if�� �ѹ� �����ؾߵǴϱ� ->��� false 
	
	public GameMain0() {
		
		
		
		this.shop = new OceanShop(); //���� ������ְ�
		this.inven = new Inventory(user);
	}
	

	public User choiceuser() {
		
		System.out.println(" ������ ������ �ּ���.");
		System.out.println(
				"����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("");
		System.out.println("  	   (1)�س�    (Ư¡)������� �Ǹ� ������ ������ �ѹ��� ���� ����� ������ ����   ");

		System.out.println("  	   (2)���    (Ư¡)������� �Ǹ� ������ ������ �ѹ��� �Ѱ��� ����⸦ ���� �� ���� ���ؿ�Ұ� ����  ");

		System.out.println("");
		System.out.println(
				"����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");

		Scanner sc1 = new Scanner(System.in);
		int choice = sc1.nextInt();

		if (choice == 1) {

			System.out.println("����� �س��Դϴ�! ������ �ػ깰�� ��ƺ����?");
			System.out.println("Tip)�ػ깰�� ���������� ��� ���� �ٴ� �������� ������ ��ų�� ��� ���� ����? ");
			System.out.println("");		
			System.out.println("");
			Diver diver1 = new Diver();
			
			
			
			return diver1;
			
		}
		else if(choice ==2 ) {
			System.out.println("����� ����Դϴ�. ������ ����⸦ ��ƺ����?");
			System.out.println("Tip)�ػ깰�� ���������� ��� ���� �ٴ� �������� ������ ��ų�� ��� ���� ����? ");
			System.out.println("");	
			System.out.println("");	
			Fisher fisher1 = new Fisher();
			
			
			return fisher1; 
		} else {
			
			
			return null;//choice 1,2�ƴҶ� null�̶� ���� 
		}
		
	}
	///
	

	public int menu() {
	
			Music dingdong = new Music("upgrade.mp3", true);
			
		if(!superfisherFlag && user instanceof Fisher && user.getMoneytank().getmoney()>=100) {  //����ڰ� ����̰�&&������� ���� 100�̻��϶�
	 		
			
	 		dingdong.start();
	 		
	 		
			user = new SuperFisher(user);  //���۾�� ����, ���� ��ΰ� ���� ������ �Ű������� �Ѱ���
			
			System.out.println("===================<<���� ��η� ���׷��̵� �˸�>> ====================");
			System.out.println();
			System.out.println("����� ��ο��� <���� ���>�� ���׷��̵� �Ǽ̽��ϴ�!");
			System.out.println("<���۾��>�� ���� �ػ깰�� �������� 2�� ���� �������� �� �� �ֽ��ϴ�.");
			System.out.println();
			System.out.println("===============================================================");
			superfisherFlag = true;
			
			

			//dingdong.isLoop(false);
			
			
		}
		
		
		dingdong.isLoop(false);

		
		
		
		user.alarm_money();
		user.game_clear();
		
		Loading tomenu = new Loading("�������������������������������޴��� �̵��մϴ�.������������������������");
		
		tomenu.start();
		
	
		try {
			tomenu.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(
				"����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("");
		System.out.println("        (1)�ٴٻ���	  (2)�ػ깰 ���	 (3)�ػ깰 â��	  (4) �ػ깰 �ȱ�	   (5)�κ��丮	 ");
		System.out.println("");
		System.out.println(
				"����������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		
		System.out.println("============== ����  ����==============="); 
		System.out.println(" (ü��  0�� �Ǹ� ������ ����˴ϴ�.) ");
		System.out.println("                                  ");
 		System.out.println("  ü ��: "+ user.getStrength()       );
 		System.out.println("  �� ��: "+ user.getMoneytank().getmoney()+"����");  //�� ����
 		System.out.println("=====================================");
 		System.out.println();	 
		
		
 		
		System.out.println("��ȣ�� �Է��ϼ���:");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		return choice;
		

	
		
	}
	
	
	
	//////
	public static void main(String[] args) {
		

		
		GameMain0  gamemain0 = new GameMain0();
		int choice;
		
		System.out.println("���ֵ� ������ �̻�Դ�.\n���� ����� �� ����� �ϸ鼭 ���踦 �ٸ���.");
		Scanner sc0 = new Scanner(System.in);
		String enter1 = sc0.nextLine();
		System.out.println("���� �ѹ� ����� ���������� �ұ�? ��ο� ������. �ٵ� ���� ���� ���� 10����... �׷� �ϴ� ��ǥ�� 300������ ����� ���� �ϴ� �������� ����� ����Ѵ�.");
		String enter2 = sc0.nextLine();
		
	 	System.out.println("���� ��ǥ : �ʱ� �ں� 10 ������ 300�������� ����� ������ �����ϴ�.");
		System.out.println("�� �׷� �����غ���!\n");
		
	
		
		//���� ���� ����
		Music intromusic = new Music("introMusic.mp3", true);
		
		intromusic.start();
		
		
		String enter3 = sc0.nextLine();
		
		new Thread(()-> {
			System.out.println("-----------------------------------------------------���� ���-------------------------------------------------------");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step1) ���� ������ �������ּ���.�س�� �ѹ��� �������� �ػ깰��, ��δ� �ѹ��� �Ѱ��� �ػ깰�� ���� �� �ֽ��ϴ�.");
			System.out.println("             �س�� �ѹ��� �������� �ػ깰��, ��δ� �ѹ��� �Ѱ��� �ػ깰�� ���� �� �ֽ��ϴ�.");
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step2) �޴����� 2)�ػ깰��� 4)�ػ깰�ȱ� �� ���� ����⸦ ��� �Ⱦ��ּ���.   ");
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step3) �س�� ��� �ҋ� ����, ��δ� ����⸦ �Ѹ����� ������ ���� ü���� -10�� �������ϴ�.");
			System.out.println("             �������� ü���� ȸ���ϱ� ���� 1)�ٴٻ������� ������ �Ծ��ּ���.");
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step4) �س�� ����� �⺻ ��ų�� �������ֱ� ������ �ش� ��ų�� ���� �ػ깰 �ۿ� ���� ���մϴ�.");
			System.out.println("             �� �پ��� �ػ깰�� ��� ���� 1)�ٴٻ����� ���� ��ų�� ��� 5)�κ��丮���� ��ų�� �����ϰ� �� ���� �ػ깰�� ��ƺ�����.");
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step5) 2)����⸦ �����鼭  ���� �̺�Ʈ�� ���ɴϴ�.�̺�Ʈ�� ���� ���� ���� ���� �� �ֽ��ϴ�.");
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step6) ��δ� 100������ ������ <���۾��>�� ���׷��̵� �˴ϴ�. ���� ��δ� �ػ깰�� 2�� �� ���� ���ݿ� �Ǹ� �� �� ������ ���� ���� �����ָ� �ܰ� ");
			System.out.println("              ���� ��δ� �ػ깰�� 2�� �� ���� ���ݿ� �Ǹ� �� �� ������ ���� ���� �����ָ� �ܰ� 2��� ���� ��  �ֽ��ϴ�.");
			System.out.println("-------------------------------------------------------------------------------------------------------------------");
			
			
			
			
		}).start();
		

		String enter4 = sc0.nextLine();
		
	
		
		gamemain0.user = gamemain0.choiceuser();//��ΰ� ��
		
	
		
		while (true) { //�޴��� Ȩ�̴ϱ� ��� �߰� ������ֱ�
			
			choice = gamemain0.menu();  //�޴������ֱ�
			
			
			
			
			
			switch (choice) {
			
			
			
			case 1: //�ٴ� ���� ����
				int get;
				get =gamemain0.shop.choice_skill_food(); //���� ���� ��ų ���� �����ְ� int return�޾�
				
				if( get ==1  ) {	// �ٴٻ��� -���� Ŭ��
				gamemain0.user.buy_food(gamemain0.shop); 
				}
				else if( get ==2) {		//�ٴٻ��� -��ųŬ��
					gamemain0.user.buy_skill(gamemain0.shop);
				}
				
				break;
			
			case 2 : //�ػ깰 ������ ����
				//intromusic.close();
				
				gamemain0.user.catch_seafood();
				
			
				break;
			case 3 : //����� â�� Ȯ���ϱ�
				gamemain0.user.check_fishandmoney();
				break;
			case 4:  //�ػ깰 �ȱ�
				//gamemain0.user.sell_seafood();
				gamemain0.user.sell_seafood(gamemain0.user);
				break;
			case 5: //�κ��丮����
				gamemain0.user.check_inven(gamemain0.inven);
				break;
				
			default:
				intromusic.close();
				System.exit(0);
				break;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		}
	}




