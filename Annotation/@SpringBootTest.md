# @SpringBootTest



+ @SpringBootTest를 사용하면 테스트에서 사용할 ApplicationContext를 쉽게 생성하고 조작할 수 있다.

  > Application Context란, IoC(제어권 역전) 방식을 따라 만들어진 일종의 빈 팩토리로서, 별도의 정보를 참고해서 빈의 생성, 관계설정 등의 제어를 총괄한다.

+ 이 어노테이션을 사용하면 테스트에 사용할 빈을 아주 손쉽게 생성할 수 있다. 
+ classes 속성을 통해서 클래스를 지정하지 않으면 애플리케이션 상에 정의된 모든 빈을 생성한다.

+ JUnit4인 경우엔 `@RunWith(SpringRunner.class)`를, JUnit5인 경우에는 `@ExtendWith(SpringExtension.class)` 을 반드시 함께 사용해야 한다.

