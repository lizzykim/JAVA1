//07.09 ��ǥ//
//���� ����� �����ϴ°� �迭���� ���� ����Ʈ ����ϱ�!!
//nullpointerexception���ֱ�
//���� nullpointerexception �� �޼ҵ� ( getBenefit /drawfish/addfish/cleartank)



package seastory;
import java.util.ArrayList;
import java.util.Scanner;

public class Fishtank extends Thread{

	protected int total_fish;
	
	protected ArrayList<Seafood> block;
	

	int fish_index;


	protected String[] fish_name; 
	
	protected int[] fish_price;  // �س� {5,5,5,10,20}    ���{20,20,20,50,100}
	
	protected int[] count;
	
	protected int[] fish_resist;
	
//	boolean stop;
//	boolean work;
//	
	public int strength;
	

	
	protected int now_total_fish; //���� ���� ����� ����   //��δ� 1��    but, �س�� ������(�س� count����)
	
	protected Seafood[] justnow_catch ;  //���� ���� ����� �ִ� �ӽ� �迭
	
	
	//������
	public Fishtank(User user) {
		
		
		this.strength = user.strength;
		
		if (user instanceof Diver) {
			
			fish_name = new String[] {"�Ҷ�", "�̿�", "�ɰ�" , "����", "����"};
			fish_price = new int[]{5,5,5,10,20};
			
			
			
			justnow_catch=  new Seafood[10];  //�سడ �ѹ� ����� ��  ������ ����� ���� �迭 ���� , user ���� count �Ѱ͸�ŭ �迭ũ�� �������µ� ���...�̰� �� �´��� �𸣰ڿ�...�׳� �ϴ� ���� ���ư������
			
			
			
			
		}
		else if( user instanceof Fisher) {
			
			fish_name = new String[] {"����", "����", "����" , "����", "��ġ"};
			fish_price = new int[] {20,20,20,50,100};
			fish_resist = new int[] {5,5,5,10,20};
			
			justnow_catch = new Seafood[1];  //��δ� �ѹ��� �Ѱ� ����
			fish_index = ((Fisher) user).fish_index;
		
//		
		}
		block = new ArrayList<Seafood>();  //���� ����� �����ϴ� �迭 ����Ʈ
		
		count = new int[5];  //{0.0.0.0.0}
		
		
	}
	
	
	public Fishtank() {
		// TODO Auto-generated constructor stub
	}


	public void getBenefit(Fishtank fishtank) {  //���� ����� ����� â�� ��
		
		fish_name = new String[] {"���� ", "���� ","���� ", "���� ","��ġ "};
		fish_price = new int[] {40, 40, 40, 100, 200};
		
		block = fishtank.getBlock();
		count = fishtank.getCount();
 		
	}
	
	
	
	

	
	//���� ������ �޼ҵ�//

	//*����� �ȱ� (�ػ깰�ȱ⿡��)  
	
	//fisher tank ���� �Ͼ�� ��
	//1)�ش� ����� ���� ����
	//2)�� â�� ������, 
	//3)�� ����� ���� �ϳ� ���̱�
	
	//�޼ҵ尡 �޴� �ŰԺ������� �Ͼ�� ��
	//1) ���� ���� count �� 0 ���� �����
	//2) name�� ����� �迭���� �ش� ����� ������ ���� �ε��� ����
	public void drawfish(int name , int counts, User user ) //����� ���̱�( int ����� �ε��� ��ȣ, int ����)

	{

		
	for( int i =0 ; i<block.size() ; i++) {
		
		if( block.get(i).getName().contains(fish_name[name-1])  ) {
			user.getMoneytank().addMoney(block.get(i).getPrice());
			
			
			counts -= 1;
			count[name-1]-=1;
			
			total_fish-=1;
			
			if(counts ==0) {
				break;
			}
		}
	}
		
		
		
		
		
	}
	
	
	//���۾���
		public void addFish(int type,int fish_index, SuperFisher user) { 	
	
	
 		
 		System.out.println(fish_name[fish_index]+ "�� ��Ÿ�����ϴ�.");
 		System.out.println(fish_name[fish_index]+ "�� ���׷��� <"+fish_resist[fish_index] +"> �Դϴ�.");
 		System.out.println();
 		System.out.println();
 		System.out.println();
 		
 		
 		
 		
 		Thread fisher = new Thread(user); //��� ���� ������ ����
 		fisher.start();   //��� ���� ������ ����  
 		
 		FishResistence fish = new FishResistence(fish_index);//����Ⱑ �����ϴ� ������(�Ĺ�����)
 		fish.start();
 		 
 	
 		

 		
 		//���ϸ� ��ΰ� ���� �ִµ� �ٷ� ����� �����ٰ� ����...
 		try {
			fisher.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		try {
			fish.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		System.out.println();
 		System.out.println();
 		System.out.println();
 		
 		
 	
 		
 		
 		this.block.add(new Seafood(fish_name[fish_index]));  //����� ������ ����! 
 		
 		this.justnow_catch[now_total_fish] = new Seafood(fish_name[fish_index]);  //�ӽ� �迭�� ���� ���� ����⸸ ���� -> ��¿�
 		
 		
 		

 		
 		//���� �̰� ���� ���� �����尡 �� ������ ����Ǿ� �Ǵ°� �ʹ� ���ﳪ��
 		System.out.println( "<"+ fish_name[fish_index] +">�� �������ϴ�~!!!!");


 		
 		
 		for(int i =0 ; i<this.now_total_fish+1 ; i++) {
 			System.out.println("<"+ justnow_catch[i].getName()+ ">�� ����� â�� �߰��˴ϴ�.");
		}
 		
 		//dingdong.isLoop(false);
 		
 		
 		
 		
 		
 		this.total_fish++;
 		count[fish_index]++;
 		System.out.println(this);
 		
 		//dingdong.isLoop(false);
 		
 	
 		
 		
 		
 	} 
	
	
	

	
	
	
	//��ο� :����� �߰��ϱ�
 	
	  public void addFish(int type,int fish_index, Fisher user) { 	
	
	
 		
 		System.out.println(fish_name[fish_index]+ "�� ��Ÿ�����ϴ�.");
 		System.out.println(fish_name[fish_index]+ "�� ���׷��� <"+fish_resist[fish_index] +"> �Դϴ�.");
 		System.out.println();
 		System.out.println();
 		System.out.println();
 		
 		
 		
 		
 		Thread fisher = new Thread(user); //��� ���� ������ ����
 		fisher.start();   //��� ���� ������ ����  
 		
 		FishResistence fish = new FishResistence(fish_index);//����Ⱑ �����ϴ� ������(�Ĺ�����)
 		fish.start();
 		
 	
 		

 		
 		//���ϸ� ��ΰ� ���� �ִµ� �ٷ� ����� �����ٰ� ����...
 		try {
			fisher.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		try {
			fish.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		System.out.println();
 		System.out.println();
 		System.out.println();
 		
 		
 	
 		
 		
 		this.block.add(new Seafood(fish_name[fish_index]));  //����� ������ ����! 
 		
 		this.justnow_catch[now_total_fish] = new Seafood(fish_name[fish_index]);  //�ӽ� �迭�� ���� ���� ����⸸ ���� -> ��¿�
 		
 		
 		

 		
 		//���� �̰� ���� ���� �����尡 �� ������ ����Ǿ� �Ǵ°� �ʹ� ���ﳪ��
 		System.out.println( "<"+ fish_name[fish_index] +">�� �������ϴ�~!!!!");


 		
 		
 		for(int i =0 ; i<this.now_total_fish+1 ; i++) {
 			System.out.println("<"+ justnow_catch[i].getName()+ ">�� ����� â�� �߰��˴ϴ�.");
		}
 		
 	
 		ImagePrint ascii = new ImagePrint();
 		
 		ascii.start();
 		
 		try {
			ascii.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		this.total_fish++;
 		count[fish_index]++;
 		System.out.println(this);
 		
 		
 		
 	
 		
 		
 		
 	} 
 	
 	
 	//�س�� ����� ���
 	public Fishtank addFish(int type, User user) {
 		

 		
 		int fish_index = (int)(Math.random()*type);
 		this.block.add(new Seafood(fish_name[fish_index]));
 		
 		this.justnow_catch[now_total_fish] = new Seafood(fish_name[fish_index]);  //�ӽ� �迭�� ���� ���� ����⸸ ���� -> ��¿�
 	
 		++this.now_total_fish;
 		
 		this.total_fish++;
 		count[fish_index]++;
 		return this;
 		
 		
 		
 	}
 	
 	
 	
 	//����� �� 0���� ����� 1)�سడ ���� ������ 2)��ΰ� ���� ������
 	 
 	public void cleartank() {
 	
 		this.block = new ArrayList<>();
 		this.setTotal_fish(0);
 		for (int i = 0; i < fish_name.length; i++) {
 			count[i] = 0;
 		}
 	} 
 	
 	
 	
 	

 	
 	//getter
	public int getTotal_fish() { 
		return total_fish;
	}



	public ArrayList<Seafood> getBlock() {
		return block;
	}
	
	
	public int[] getCount() {
		return count;
	}
	
	
	public Seafood[] getJustnow_catch() {
		return justnow_catch;
	}
	
	public int getNow_total_fish() {
		return now_total_fish;
	}
	

	//setter
	
	public void setBlock(ArrayList<Seafood> block) {
		this.block = block;
	}
	
	public void setTotal_fish(int total_fish) {
		this.total_fish = total_fish;
	}


	
	public void setCount(int[] count) {
		this.count = count;
	}

	public void setJustnow_catch(Seafood []  justnow_catch) {
		this.justnow_catch = justnow_catch;
	}
	
	public void setNow_total_fish(int now_total_fish) {
		this.now_total_fish = now_total_fish;
	}
	


//�ӽ� �迭�� ���� �Ȱ��� ����ϱ�
	public String toString() {
		String str = "" ;
		
		for( int  i =0 ; i < this.now_total_fish ; i++) {
			
			str += "<" + justnow_catch[i].getName()+ "> " ;
			
		}
		
		return str;
	}





}
