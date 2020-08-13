package seastory;

public class SuperFisher extends Fisher{
	
	public SuperFisher(User fisher) {
		super(fisher);   //fisher �޼ҵ� ���� ��������
		super.getFishtank().getBenefit(fisher.getFishtank()); //getBenefit �� ���� ��� �������ũ �Ѱ���
	}
	
	
	public void meet_whale(User fisher) {
		
		
		System.out.println("��???? ���� ��Һ����� �� ������ ���Ƽ� ���ο��ϴ� ���� �־��!!!");
		System.out.println(
				"����������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("");
		System.out.println(" 			       (1)�����ش�               (2) �����ϰ� ��������");
		System.out.println("");
		System.out.println(
				"����������������������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��ȣ�� �Է����ּ���:");
		int a = sc.nextInt();
		
		if(a ==1 ) {
			
			
			System.out.println("-------------------------------<�˸�>--------------------------------");
			
			System.out.println();
			System.out.println("	���� ��δ��� ���� ������ �������� �ܰ� ���� 2��� ä�������ϴ�~ ");
			System.out.println();
			System.out.println("-------------------------------------------------------------------");
			super.getMoneytank().doubleMoney(fisher.getMoneytank().getmoney());
			
			
		}else{
			
			System.out.println("���� �׳� �������Ŵٰ��??? ");
		}
	}
	
	
	
public void catch_seafood() {
		
		this.alarm_strength();
		
		if (super.getStrength() <= 0) {
			
			System.out.println(" ------------------------------���� ����----------------------------------");
			System.out.println();
			System.out.println("ü���� �����մϴ�. ���ӿ� �����ϼ̽��ϴ�.");
			System.out.println();
			System.out.println(" --------------------------------------------------------------------------");
			System.exit(0);
		}
		
		int spin_rod = super.getLimit();  //�⺻ ������ 100�� ������
		
		int type; //��� ����⸦ ��������
		
		switch(spin_rod) {   //
			
		case 100:
			type = 3;
			break; 
		case 500:
			type = 4;
			break;
		case 1000:
			type = 5;
			break;
		default:
			type =3;
			break;
		
		}
		
		int fish_index = (int)(Math.random()*type);
		
		//this.getFishtank().addFish(type ,fish_index);
		this.getFishtank().addFish(type,fish_index,this);

		System.out.println();
		System.out.println();
		this.count++; //��ΰ� ����� ���� Ƚ��
		
		if (this.count % 8 == 0 && this.count != 0 ) { //����⸦3������ �ѹ� ��ų� 0�� �̻� �϶�
			
			System.out.println("���! ������ ��Ÿ�����ϴ�!");
			System.out.println("�������������� �̱�� �� 20������ ȹ���ϰ�,");
			System.out.println("�������������� ���� ���� �� �Ұ� �˴ϴ�.");
			meet_pirate();		//��������������� ���� +30���� or �� â�� 0
			
		}else if(this.count % 5 ==0 && this.count!=0) {
			
			System.out.println("���! ������ ���ƽ��ϴ�!"); 
			meet_hail();
			
		}else if(this.count %3 == 0 && this.count!=0) { //3���� 1�� �÷� �����ڵ���
			meet_whale(this);
		}
		
		//this.strength-=10;
	} 
	
	
	
	
	
	
	
	
}
