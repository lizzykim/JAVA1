package seastory;

public class FishResistence extends Thread {

	int fish_index;
	String [] fish_name = new String[] {"���� ", "���� ","���� ", "���� ","��ġ "};
	int [] fish_resist = new int[] {5,5,5,10,20};//���װ�
	int [] fish_resist_indexbox = new int[] {5,5,5,10,20};
	
	
	public FishResistence(int fish_index) {
		this.fish_index = fish_index;
	}

	public synchronized void fishresistence() {
		
		for(int i =0 ; i<fish_resist_indexbox[fish_index]; i++) {
			
		System.out.println("<"+fish_name[fish_index]  +">�� �����մϴ�! (���� "+fish_name[fish_index] +" ���׷�:"+fish_resist[fish_index]+")" );
		fish_resist[fish_index]-=1;
		
		
		//notify();
		try {
			Thread.sleep(500);
		
			//wait();
		} catch (InterruptedException e) {
			
		}
	}
	}
	
	 @Override
	public void run() {
	
		 //for(int i=0 ;i <5 ;i++) {
			 fishresistence();
		// }
	}
	
}
