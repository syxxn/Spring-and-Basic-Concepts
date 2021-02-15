# CORS

CORS란 **교차 출처 자원 공유(Cross-Origin Resource Sharing)**의 줄임말로, 추가 HTTP 헤더를 사용하여, 한 출처에서 실행 중인 웹 애플리케이션이 다른 출처의 선택한 자원에 접근할 수 있도록 하는 구조이다. `교차 출처`라고 하는 것은 `다른 출처`를 의미한다. **REST API의 리소스가 비 단순 cross-origin HTTP 요청을 받을 경우 CORS 지원을 활성화**해야 한다.



#### 출처

**출처(Origin)**이란, url의 protocol, host, port 번호를 모두 합친 것, 즉 서버의 위치를 찾아가기 위해 필요한 가장 기본적인 것들을 합쳐 놓은 것이다.



웹에서는 다른 출처로의 리소스 요청을 제한하는 것과 관련된 CORS와 SOP(Same-Origin Policy) 정책이 존재한다. **SOP**는 '같은 출처에서만 리소스를 공유할 수 있다'라는 규칙을 가진 정책이다. 무작정 요청을 막을 순 없어서 몇 가지 예외 조항을 두고, 이에 해당하는 것은 허용하도록 하는 것이 CORS이다.



두 개의 출처가 같다고 판단하는 기준은 두 URL의 `Scheme`, `Host`, `Port` 세 가지가 동일하냐는 것이다.

> URL에서 가장 앞에 자원에 접근할 방법을 정의해 둔 프로토콜 자리를 scheme이라 한다.



____



#### 왜 발생하는가?

> CORS 에러는 브라우저에서 서로 다른 도메인/포트의 서버로 요청이 갈 때 **브라우저에서 발생**한다.

프론트와 서버의 ip주소가 다르기 때문에 발생한다.

> ip 주소가 같으면 오류 안난다.



#### 해결법

+ 미들웨어 설치 & 설정(프론트/백 둘 다 해당)

  > 미들웨어는 운영체제와 응용 소프트웨어의 중간에서 조정과 중개의 역할을 수행한다.

  > 서버단에서 특정 도메인에서의 요청을 허용해 줌.

+ **프록시방식 사용** : 브라우저에서 프론트 서버로 요청 > 프론트서버에서 백엔드 서버로 요청



____



```java
//@EnableWebSecurity
@Configuration
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/ implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*");
    }

}
```

+ `@EnableWebSecurity`는 웹 보안을 활성화한다. `WebSecurityConfigurerAdapter`를 상속받은 config 클래스에 이 어노테이션을 달면, SpringSecurityFilterChain이 자동으로 포함된다.

+ `@Configuration`은 `@Bean`을 사용하는 클래스 위에 반드시 붙여 해당 클래스에서 Bean을 등록하고자 함을 명시해주어야 한다.

  이 어노테이션은 설정파일임을 알려준다.

+ `WebSecurityConfigurerAdapter`는 WebSecurity와 HttpSecurity 모두 사용자가 원하는대로 맞춤 변경할 수 있도록 하는 편리한 클래스이다.
+ `WebMvcConfigurer`에는 Spring MVC에서 유용하게 사용되는 기능들이 선언되어 있어서, 웹과 관련된 처리를 하기 위해서는 구현하는 것이 좋다.
+ `registry.addMapping`을 이용해서 CORS를 적용할 URL 패턴을 정의할 수 있다.
+ `allowedOrigins` 메소드를 이용해서 자원 공유를 허락할 출처를 지정할 수 있다. "*"는 모든 Origin을 허락하는 것이다.
+ `allowedMethods`를 이용해서 허용할 HTTP method를 지정할 수 있다. 이것 또한 "*"는 모든 메소드를 허락하는 것이다.