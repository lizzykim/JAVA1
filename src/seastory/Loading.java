package seastory;

public class Loading extends Thread {
	
	String str;
	char[] array_word ;
	
	public Loading (String str) {
	this.str = str;
	this.array_word = new char[str.length()];
	}	
	

	
	
	public void run() {
		
		for( int i =0 ;i < array_word.length ;i++) {
			
			array_word[i] = str.charAt(i);
		
			System.out.print(array_word[i]);
			
		try {

			
			Thread.sleep(30);
			
		}catch(InterruptedException e) {
			e.getStackTrace();
			}
		
		}
		System.out.println("");
	}

}