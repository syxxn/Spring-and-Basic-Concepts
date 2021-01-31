# Spring boot test code



```java
//JUnit4인경우
@RunWith(SpringRunner.class) 
//JUnit5인 경우
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ScienceOxApplication.class)
@ActiveProfiles("test")
class QuestionServiceTest {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private QuestionRepository questionRepository;

    private MockMvc mvc;

    @BeforeEach
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @AfterEach
    public void deleteAll(){
        questionRepository.deleteAll();
    }

    @Test
    public void getQuestion() throws Exception{
        int id = addQue();

        mvc.perform(get("/question/"+id))
                .andExpect(status().isOk()).andDo(print());
    }
}
```

#### JUnit

단위 테스트를 위한 프레임워크를 말하며, 언어마다 xUnit이 있다.

JUnit은 Java에서 독립된 단위테스를 지원해준다.



#### @RunWith

> Junit4에서 사용할 수 있는 어노테이션이다.
>
> ```java
> implementation 'junit:junit:4.12' //또는
> import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
> ```

@RunWith는 현재 테스트 코드가 스프링을 실행하는 역할을 할 것이라는 일종의 알림 역할을 한다. @RunWith에 Runner 클래스를 설정하면 JUnit에 내장된 runner 대신 이 클래스를 사용한다.

Mockito의 Mock 객체를 사용하기 위한 Annotation이다.

JUnit5에서는 `@ExtendWith(SpringExtension.class)`를 사용한다.

```java
testImplementation('org.springframework.boot:spring-boot-starter-test') {
		exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
	}
// spring-boot-starter-test는 junit4에 대한 의존성을 가지고 있기 때문에 제외해주는 것이다.
```



#### @SpringBootTest

@SpringBootTest는 통합 테스트를 제공하는 기본적인 SpringBoot Test 어노테이션이다. 스프링부트 애플리케이션 테스트에 필요한 거의 모든 의존성을 제공한다. 

> 매우 다양한 기능을 제공한다. 전체 빈 중 특정 빈을 선택하여 생성한다던지, Mock으로 대체한다던지 ...

@SpringBootTest는 @SpringBootApplication이 붙은 어노테이션을 찾아 context를 찾는다. 붙이지 않은 경우에는 위의 코드와 같이 classes 필드를 통해 지정해야 한다.

다양한 기능들을 사용하기 위해서 잊지 말아야 할 것은 @RunWith 또는 @ExtendWith와 함께 사용해야 한다는 것이다.



#### @ActiveProfiles

테스트할 때 특정한 환경을 맞춰야 할 때 사용한다.

@Profile과 @ActiveProfiles 둘 다 application.properties 파일들에 따라서 Spring Bean을 만드는데(개발환경과 배포환경을 구분지어줄 수 있다는 뜻이다), `@ActiveProfile`는 테스트 할 때 사용한다.

프로파일 환경을 갖는다면, `@ActiveProfiles("test")`와 같은 방식으로 원하는 프로파일 환경값을 부여 가능하다.



> 'src/main/resources' 폴더에 application.properties 파일을 넣어 놓는다는 것은 배포 시에 jar 파일에 함께 묶여서 배포가 된다는 것이다.
>
> 흔히 볼 수 있는 가장 중요한 설정 파일이다. Spring boot는 애플리케이션을 구동할 때 자동으로 이 파일을 로딩한다

#### @Autowired

생성자, 필드, 메소드에 모두 적용이 가능한 어노테이션으로서, 의존성 주입을 할 때 사용하는 annotation으로 의존 객체의 타입에 해당하는 bean을 찾아 주입하는 역할을 한다.

매우 간단한 방법이고, 각각에게 의존성을 주입하기 간편하지만, 단점이 많아서 권장되고 있지 않은 방법이다. > 현재 가장 권장되고 있는 방법은 Constructor Injection 방법이다.



#### MockMvc

> Mock은 실제의 모듈을 흉내내는 *가짜* 모듈을 작성하여 테스트의 효용성을 높이는 데 사용된다.

MockMvc는 브라우저에서 요청과 응답을 의미하는 객체로서, Controller 테스트 사용을 용이하게 해 주는 라이브러리이다. 실제 객체와 비슷하지만 테스트에 필요한 기능만 가지는 가짜 객체를 만들어서, 애플리케이션 서버에 배포하지 않고도 스프링 MVC 동작을 재현할 수 있다. 테스트할 컨텍스트를 지정한 MockMvc를 생성한다.



#### WebApplicationContext

spring에서 말하는 "애플리케이션 컨텍스트"는 스프링이 관리하는 빈들이 담겨있는 컨테이너라고 생각 할 수 있다. 

웹 애플리케이션 컨텍스트는 ApplicationContext를 확장한 WebApplicationContext 인터페이스의 구현체를 말한다. WebApplicationContext는 ApplicationContext에 getServletContext() 메소드가 추가된 인터페이스이다. 

즉, WebApplicationContext는 스프링 애플리케이션 컨텍스트(빈 저장소)의 변종이면서 서블릿 컨텍스트와 연관 관계에 있다.



#### @BeforeEach @AfterEach

각각의 메소드가 실행 전, 실행 후에 호출되어 처리되는 것들이다. `@BeforeEach`는 공통적인 Param 및 설정을 할 때 호출되면 좋은 부분들이고, `@AfterEach`는 사용되고 난 후 종료되어야 할 리소스를 처리하는 부분으로 사용될 가능성이 높다.



#### @Test

Junit에서 제공하는 테스트를 지원하는 어노테이션으로서, 각각의 테스트가 서로 영향을 주지 않고 실행됨을 원칙으로 `@Test`마다 객체를 생성한다.



#### mvc.perform()

perform은 요청을 전송하는 역할을 한다.