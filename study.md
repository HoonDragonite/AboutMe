# Study

## Builder 패턴

기본적인 구조는 생성자를 통해 최종 값을 채운후 DB에 Insert 하는것이며, 값 변경이 필요한 경우 해당 이벤트에 맞는 public 메소드를 호출하여 변경하는 것을 전제로 합니다.
여기서 생성자 대신에 @Builder를 통해 제공되는 빌더 클래스를 사용합니다.
생성자나 빌더나 생성시점에 값을 채워주는 역할은 똑같습니다.
다만, 생성자의 경우 지금 채워야할 필드가 무엇인지 명확히 지정할수가 없습니다.
예를 들어 아래와 같은 생성자가 있다면

public Example(String a, String b){
    this.a = a;
    this.b = b;
}
개발자가 new Example(b,a)처럼 a와 b의 위치를 변경 해도 실제로 코드를 실행하기전까진 전혀 문제를 찾을수가 없습니다.
하지만 빌더를 사용하게 되면 아래와 같이

Example.builder()
    .a(a)
    .b(b)
    .build();
어느 필드에 어떤 값을 채워야 할지 명확하게 인지할 수 있습니다.


ibatis/MyBatis 등에서 Dao라고 불리는 DB Layer 접근자입니다.
JPA에선 Repository라고 부르며 인터페이스로 생성합니다.