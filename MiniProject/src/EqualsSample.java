//�ǹ��� ���� ����
//[����] Person�̶�� Ŭ������ ���̵�� �н����尡 ��������� ���ǵǾ� �ֽ��ϴ�.
//mainŬ�������� PersonŬ������ ���̵�� �н����带 �Ѱ��ְ�
//���� ���̵�� �н����尡 main���� �Ѱ��� ���̵�� �н����带 ���Ͽ� ������ true�� �����ϰ�
//�ٸ��� false�� �����ϴ� ���α׷��� �ۼ��Ͽ� ������.


class Person{ //Ŭ�����̸��� �������̸��� ���ƾ��Ѵ�. public�� ������ �ȵȴ�. public�� �������� �ٸ� Ŭ����â���� �ڵ��ؾ��Ѵ�.
	//�ʵ� ����
	String id; //ȫ�浿 ����  ......�������
	String pw; //12345678 ����
	
	Person(String id, String pw){ //������ : Ŭ���� �������� �Ѿ�� �����͸� �޾��ݴϴ�.
		this.id = id;
		this.pw = pw;
	}
	
	public boolean equals(Person p) {
		if((this.id.equals(p.id)) && (this.pw.equals(p.pw))){ //���߿��� DB�� �� 
			return true; //��ġ�ϸ�
		}else {
			return false; //����ġ�ϸ�
		}
	}
}

public class EqualsSample {
	//�ʵ� ����
	
	public static void main(String[] args) {
		Person p1 = new Person("ȫ�浿", "12345678"); //����
		Person p2 = new Person("ȫ�浿", "1234568"); //����� �Է� id/pw
		
	
		if(p1.equals(p2)) {
			System.out.println("�α��εǾ����ϴ�.");
		}else {
			System.out.println("�α����� �� �����ϴ�.");
			System.out.println("���̵�/�н����带 Ȯ���� �ּ���");
		}

	}

}
