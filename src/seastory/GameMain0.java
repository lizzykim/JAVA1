//僥薯: 120廓還 , 羹溘擊 陛螳螃朝等 user縑憮 儅撩濠煎 蟾晦�� 脹 100擊 蕾斬ж朝 匙偽嬴
package seastory;


import java.util.Scanner;



public class GameMain0 { //shop擎 樹薯萇雖 斜濠葬縑 氈橫撿腋 斜陽葆棻 憧檜 儅晦賊 檜鼻ж濫嬴 斜楚憮 嬴蕨 虜菟橫 幗萼剪撿 
	
	private User user;
	
	private OceanShop shop;
	private Inventory inven;
	
	private boolean superfisherFlag = false;  //餌辨濠陛 fisher檜堅 絲檜 100 檜鼻檣雖 �挫恉炴� if陛 и廓 褒чп撿腎棲械 ->薯橫僥 false 
	
	public GameMain0() {
		
		
		
		this.shop = new OceanShop(); //憧擊 虜菟橫輿剪
		this.inven = new Inventory(user);
	}
	

	public User choiceuser() {
		
		System.out.println(" 嶸盪蒂 摹鷗п 輿撮蹂.");
		System.out.println(
				"忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("");
		System.out.println("  	   (1)п喪    (か癒)僭堅晦曖 っ衙 陛問檜 雪雖虜 и廓縑 罹楝 僭堅晦 閉擊熱 氈擠   ");

		System.out.println("  	   (2)橫睡    (か癒)僭堅晦曖 っ衙 陛問檜 堪雖虜 и廓縑 и偃曖 僭堅晦蒂 閉堅 渦 號擎 寞п蹂模陛 襄營  ");

		System.out.println("");
		System.out.println(
				"戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");

		Scanner sc1 = new Scanner(System.in);
		int choice = sc1.nextInt();

		if (choice == 1) {

			System.out.println("渡褐擎 п喪殮棲棻! 翮褕�� п骯僭擊 濩嬴獐梱蹂?");
			System.out.println("Tip)п骯僭擊 獄問瞳戲煎 濩晦 瞪縑 夥棻 鼻薄縑憮 億霤婁 蝶鑒擊 餌朝 匙檜 橫雲梱蹂? ");
			System.out.println("");		
			System.out.println("");
			Diver diver1 = new Diver();
			
			
			
			return diver1;
			
		}
		else if(choice ==2 ) {
			System.out.println("渡褐擎 橫睡殮棲棻. 翮褕�� 僭堅晦蒂 濩嬴獐梱蹂?");
			System.out.println("Tip)п骯僭擊 獄問瞳戲煎 濩晦 瞪縑 夥棻 鼻薄縑憮 億霤婁 蝶鑒擊 餌朝 匙檜 橫雲梱蹂? ");
			System.out.println("");	
			System.out.println("");	
			Fisher fisher1 = new Fisher();
			
			
			return fisher1; 
		} else {
			
			
			return null;//choice 1,2嬴棍陽 null檜塭紫 葬欐 
		}
		
	}
	///
	

	public int menu() {
	
			Music dingdong = new Music("upgrade.mp3", true);
			
		if(!superfisherFlag && user instanceof Fisher && user.getMoneytank().getmoney()>=100) {  //餌辨濠陛 橫睡檜堅&&餌辨濠曖 絲檜 100檜鼻橾陽
	 		
			
	 		dingdong.start();
	 		
	 		
			user = new SuperFisher(user);  //蓬ぷ橫睡 儅撩, 晦襄 橫睡陛 陛霞 薑爾蒂 衙偃滲熱煎 剩啖醜
			
			System.out.println("===================<<蓬ぷ 橫睡煎 機斜溯檜萄 憲葡>> ====================");
			System.out.println();
			System.out.println("渡褐擎 橫睡縑憮 <蓬ぷ 橫睡>煎 機斜溯檜萄 腎樟蝗棲棻!");
			System.out.println("<蓬ぷ橫睡>朝 濩擎 п骯僭擊 晦襄爾棻 2寡 堪擎 陛問戲煎 つ 熱 氈蝗棲棻.");
			System.out.println();
			System.out.println("===============================================================");
			superfisherFlag = true;
			
			

			//dingdong.isLoop(false);
			
			
		}
		
		
		dingdong.isLoop(false);

		
		
		
		user.alarm_money();
		user.game_clear();
		
		Loading tomenu = new Loading("ⅡⅡⅡⅡⅡⅡⅡⅡⅡⅡⅡⅡⅡⅡⅡ詭景煎 檜翕м棲棻.ⅡⅡⅡⅡⅡⅡⅡⅡⅡⅡⅡⅡ");
		
		tomenu.start();
		
	
		try {
			tomenu.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(
				"忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("");
		System.out.println("        (1)夥棻鼻薄	  (2)п骯僭 濩晦	 (3)п骯僭 璽堅	  (4) п骯僭 つ晦	   (5)檣漸饜葬	 ");
		System.out.println("");
		System.out.println(
				"戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		
		System.out.println("============== ⑷營  鼻鷓==============="); 
		System.out.println(" (羹溘  0檜 腎賊 啪歜檜 謙猿腌棲棻.) ");
		System.out.println("                                  ");
 		System.out.println("  羹 溘: "+ user.getStrength()       );
 		System.out.println("  濤 堅: "+ user.getMoneytank().getmoney()+"虜錳");  //絲 梧擠
 		System.out.println("=====================================");
 		System.out.println();	 
		
		
 		
		System.out.println("廓�ㄧ� 殮溘ж撮蹂:");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		return choice;
		

	
		
	}
	
	
	
	//////
	public static void main(String[] args) {
		

		
		GameMain0  gamemain0 = new GameMain0();
		int choice;
		
		System.out.println("薯輿紫 憮餌塭煎 檜餌諮棻.\n罹晦 餌塋菟 棻 橫機擊 ж賊憮 儅啗蒂 紱萼棻.");
		Scanner sc0 = new Scanner(System.in);
		String enter1 = sc0.nextLine();
		System.out.println("釭紫 и廓 橫機擊 獄問瞳戲煎 й梱? 堅團縑 緒霞棻. 斬等 頂啪 陴擊 絲擎 10虜錳... 斜楚 橾欽 跡ル蒂 300虜錳擊 虜菟橫 爾濠 ж朝 葆擊戲煎 橫機擊 唸褕и棻.");
		String enter2 = sc0.nextLine();
		
	 	System.out.println("啪歜 跡ル : 蟾晦 濠獄 10 虜錳擊 300虜錳戲煎 虜菟賊 啪歜擊 部陶棲棻.");
		System.out.println("濠 斜歲 衛濛п爾濠!\n");
		
	
		
		//罹晦 擠學 鳶殮
		Music intromusic = new Music("introMusic.mp3", true);
		
		intromusic.start();
		
		
		String enter3 = sc0.nextLine();
		
		new Thread(()-> {
			System.out.println("-----------------------------------------------------啪歜 寞徹-------------------------------------------------------");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step1) 試盪 嶸盪蒂 摹鷗п輿撮蹂.п喪朝 и廓縑 罹楝偃曖 п骯僭擊, 橫睡朝 и廓縑 и偃曖 п骯僭擊 濩擊 熱 氈蝗棲棻.");
			System.out.println("             п喪朝 и廓縑 罹楝偃曖 п骯僭擊, 橫睡朝 и廓縑 и偃曖 п骯僭擊 濩擊 熱 氈蝗棲棻.");
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step2) 詭景縑憮 2)п骯僭濩晦 4)п骯僭つ晦 蒂 鱔п 僭堅晦蒂 濩堅 つ嬴輿撮蹂.   ");
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step3) п喪朝 濡熱 й�� 葆棻, 橫睡朝 僭堅晦蒂 и葆葬噶 濩擊陽 葆棻 羹溘檜 -10噶 雲橫餵棲棻.");
			System.out.println("             雲橫雖朝 羹溘擊 �蛹嘎炱� 嬪п 1)夥棻鼻薄縑憮 億霤擊 詳橫輿撮蹂.");
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step4) п喪諦 橫睡曖 晦獄 蝶鑒檜 薑п螳氈晦 陽僥縑 п渡 蝶鑒縑 渠и п骯僭 夤縑 濩雖 跤м棲棻.");
			System.out.println("             渦 棻曄и п骯僭擊 濩晦 嬪п 1)夥棻鼻薄縑 陛憮 蝶鑒擊 餌堅 5)檣漸饜葬縑憮 蝶鑒擊 濰雜ж堅 渦 堅陛曖 п骯僭擊 濩嬴爾撮蹂.");
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step5) 2)僭堅晦蒂 濩戲賊憮  罹楝 檜漸お陛 釭褫棲棻.檜漸お蒂 鱔п 絲擊 弊堅 檠擊 熱 氈蝗棲棻.");
			System.out.println("");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("step6) 橫睡朝 100虜錳擊 賅戲賊 <蓬ぷ橫睡>煎 機斜楚檜萄 腌棲棻. 蓬ぷ 橫睡朝 п骯僭擊 2寡 渦 堪擎 陛問縑 っ衙 й 熱 氈戲賊 嬴Ъ 堅楚蒂 紫諦輿賊 濤堅蒂 ");
			System.out.println("              蓬ぷ 橫睡朝 п骯僭擊 2寡 渦 堪擎 陛問縑 っ衙 й 熱 氈戲賊 嬴Ъ 堅楚蒂 紫諦輿賊 濤堅蒂 2寡煎 堪橾 熱  氈蝗棲棻.");
			System.out.println("-------------------------------------------------------------------------------------------------------------------");
			
			
			
			
		}).start();
		

		String enter4 = sc0.nextLine();
		
	
		
		gamemain0.user = gamemain0.choiceuser();//橫睡陛 菟橫陛
		
	
		
		while (true) { //詭景陛 �阱抴炱� 啗樓 嗑啪 虜菟橫輿晦
			
			choice = gamemain0.menu();  //詭景爾罹輿晦
			
			
			
			
			
			switch (choice) {
			
			
			
			case 1: //夥棻 鼻薄 陛晦
				int get;
				get =gamemain0.shop.choice_skill_food(); //億霤 髦雖 蝶鑒 髦雖 爾罹輿堅 int return嫡嬴
				
				if( get ==1  ) {	// 夥棻鼻濠 -億霤 贗葛
				gamemain0.user.buy_food(gamemain0.shop); 
				}
				else if( get ==2) {		//夥棻鼻濠 -蝶鑒贗葛
					gamemain0.user.buy_skill(gamemain0.shop);
				}
				
				break;
			
			case 2 : //п骯僭 濩戲楝 陛晦
				//intromusic.close();
				
				gamemain0.user.catch_seafood();
				
			
				break;
			case 3 : //僭堅晦 璽堅 �挫恉炱�
				gamemain0.user.check_fishandmoney();
				break;
			case 4:  //п骯僭 つ晦
				//gamemain0.user.sell_seafood();
				gamemain0.user.sell_seafood(gamemain0.user);
				break;
			case 5: //檣漸饜葬陛晦
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




