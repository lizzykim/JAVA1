package seastory;

public class FishWait extends Thread {
	


	public void run () {
		System.out.println("입질이 시작됩니다!!");
		
		synchronized(this) {
			for( int i =0;i<3 ; i++) {
				System.out.println("톡!");
				
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
