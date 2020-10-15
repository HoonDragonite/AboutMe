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

Controller에서 @RequestBody로 외부에서 데이터를 받는 경우엔 기본생성자 + set메소드를 통해서만 값이 할당됩니다.
그래서 이때만 setter를 허용합니다.

ibatis/MyBatis 등에서 Dao라고 불리는 DB Layer 접근자입니다.
JPA에선 Repository라고 부르며 인터페이스로 생성합니다.

<br>

## 테스팅

- given : 테스트 기반 환경을 구축하는 단계, 여기선 @builder의 사용법도 같이 확인
- when : 테스트 하고자 하는 행위 선언, 여기선 Posts가 DB에 insert 되는것을 확인하기 위함
- then : 테스트 결과 검증, 실제로 DB에 insert 되었는지 확인하기 위해 조회후, 입력된 값 확인

DB가 설치가 안되어있는데 Repository를 사용할 수 있는 이유는, SpringBoot에서의 테스트 코드는 메모리 DB인 H2를 기본적으로 사용하기 때문입니다.
테스트 코드를 실행하는 시점에 H2 DB를 실행시킵니다.
테스트가 끝나면 H2 DB도 같이 종료됩니다.

## Bean

스프링프레임워크에선 Bean 을 주입받는 방식들이 아래와 같이 있는데요.

1. @Autowired
2. setter
3. 생성자  

이중 가장 권장하는 방식이 생성자로 주입받는 방식입니다. (@Autowired는 비권장방식입니다.)  
즉, 생성자로 Bean 객체를 받도록 하면 @Autowired와 동일한 효과를 볼 수 있다는 것입니다.

## Entity Class

실제 DB와 매칭될 Class 이다.  
절대로 테이블과 매핑되는 Entity 클래스를 Request/ Response 클래스로 사용해서는 안됩니다.
