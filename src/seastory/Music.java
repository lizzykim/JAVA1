package seastory;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import com.sun.tools.javac.Main;

import javazoom.jl.player.Player;

public class Music extends Thread{

	private Player player;
	private boolean stop = false;
	private boolean isLoop; //isLoop true�� �ʱ�ȭ
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) { //���� ����, �ش� ���� ���ѹݺ����� ����
	
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
	
	
	
	public void close() {		//�뷡 ����
		isLoop = false;  //�׸� �Ѷ� isLoop�� false�� ������
		player.close();
		this.interrupt();
	}
	
	@Override
	public void run() {  //�������� ���� �κ�
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
	
	
	
	
	
	//false������ ����
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
