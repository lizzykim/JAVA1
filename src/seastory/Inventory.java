package seastory;

public class Inventory {
	

 
	 
	 protected Skill [] block;  // ��ü ������ ���ִ� ��� , (�̸�, ����, ��ų����)
		
	 protected String[] skillname; //��ų�̸� ����
	 
	 protected int[] count; //�����ϴ� ���� Ȯ�� {0,0}
	 
	 protected int totalCount;  //��ų�� ��ü ����  
	 
	 
	 
	 public Inventory(User user) {
		 
		 if(user instanceof Diver) {
			 skillname = new String[]{ "5m ��������" ,"10m ��������" };
		 }else if(user instanceof Fisher) {
			 skillname = new String[]{ "������ 500�� ������" ,"������ 1000��  ������" };
		 }
		 
		 this.block = new Skill [20];
	
		 this.count = new int[2];    
		 
	 }
	 
	 
	 
	 public void addInventory(Skill skill) {  //skill�� ��Ͽ� ��������
		 this.block[totalCount++] = skill;
	 }
	 

}
