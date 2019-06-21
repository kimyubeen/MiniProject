//실무적 관점 예제
//[문제] Person이라는 클래스에 아이디와 패스워드가 멤버변수로 정의되어 있습니다.
//main클래스에서 Person클래스로 아이디와 패스워드를 넘겨주고
//기존 아이디와 패스워드가 main에서 넘겨준 아이디와 패스워드를 비교하여 같으면 true를 리턴하고
//다르면 false를 리턴하는 프로그램을 작성하여 보세요.


class Person{ //클래스이름과 생성자이름은 같아야한다. public을 적으면 안된다. public을 적으려면 다른 클래스창에서 코딩해야한다.
	//필드 영역
	String id; //홍길동 저장  ......멤버변수
	String pw; //12345678 저장
	
	Person(String id, String pw){ //생성자 : 클래스 단위에서 넘어온 데이터를 받아줍니다.
		this.id = id;
		this.pw = pw;
	}
	
	public boolean equals(Person p) {
		if((this.id.equals(p.id)) && (this.pw.equals(p.pw))){ //나중에는 DB랑 비교 
			return true; //일치하면
		}else {
			return false; //불일치하면
		}
	}
}

public class EqualsSample {
	//필드 영역
	
	public static void main(String[] args) {
		Person p1 = new Person("홍길동", "12345678"); //원본
		Person p2 = new Person("홍길동", "1234568"); //사용자 입력 id/pw
		
	
		if(p1.equals(p2)) {
			System.out.println("로그인되었습니다.");
		}else {
			System.out.println("로그인할 수 없습니다.");
			System.out.println("아이디/패스워드를 확인해 주세요");
		}

	}

}
