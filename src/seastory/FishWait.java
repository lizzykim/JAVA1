package seastory;

public class FishWait extends Thread {
	


	public void run () {
		System.out.println("������ ���۵˴ϴ�!!");
		
		synchronized(this) {
			for( int i =0;i<3 ; i++) {
				System.out.println("��!");
				
				try {
					sleep(500);
				}catch(Exception e) {
					e.printStackTrace();
					}
			}
			notify();
		}
		
		
	}
	
	
	
	
}
