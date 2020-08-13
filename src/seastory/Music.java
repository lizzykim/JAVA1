package seastory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import com.sun.tools.javac.Main;

import javazoom.jl.player.Player;

public class Music extends Thread{

	private Player player;
	private boolean stop = false;
	private boolean isLoop; //isLoop true로 초기화
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) { //곡의 제목, 해당 곡이 무한반복인지 여부
	
		try {
			this.isLoop = isLoop;
			file = new File("C:\\Users\\User\\Music\\bgm\\"+ name);
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	
	public void close() {		//노래 중지
		isLoop = false;  //그만 둘때 isLoop를 false로 고쳐줘
		player.close();
		this.interrupt();
	}
	
	@Override
	public void run() {  //쓰레드의 동작 부분
//		try {
//
//			while(!stop) {
//			if(isLoop) {
//				player.play();
//				fis = new FileInputStream(file);
//				bis = new BufferedInputStream(fis);
//				player = new Player(bis);
//				
//			}
//			else {
//				notify();
//			}
//			
//			}
		
		synchronized(this) {
			try {
			while(!stop) {
				if(isLoop) {
					player.play();
					fis = new FileInputStream(file);
					bis = new BufferedInputStream(fis);
					player = new Player(bis);
					}
				}
			}catch(Exception e) {
			System.out.println(e.getMessage());
			}
			notify();
		}
		//notify();
		
	}
	
	
	
	
	
	//false들어오면 쉬기
	public void isLoop(boolean isLoop) {
		this.isLoop = isLoop;
	}
	
	public void setStop (boolean stop) {
		this.stop = stop;
	}
	
}



//do {
//player.play();
//fis = new FileInputStream(file);
//bis = new BufferedInputStream(fis);
//player = new Player(bis);
//}while(isLoop);
